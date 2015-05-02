package com.nmea.datasource;


import akka.actor.ActorRef;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class TcpServerHandler extends ChannelInboundHandlerAdapter {

    private ActorRef remoteActor;

    private ChannelHandlerContext context;

    public TcpServerHandler(ActorRef remoteActor) {
        this.remoteActor = remoteActor;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        this.context = ctx;

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        this.remoteActor.tell(msg, null);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.fireExceptionCaught(cause);
        ctx.close();
        this.context = null;
    }

    public void send(List<String> strings) {

        if (this.context == null)
            return;

        try {
            for (String str : strings) {

                byte[] bytes = str.getBytes("ASCII");
                ByteBuf buffer = Unpooled.buffer(bytes.length);
                buffer.writeBytes(bytes);
                this.context.writeAndFlush(buffer);
            }
        } catch (UnsupportedEncodingException e) {
        }
    }
}
