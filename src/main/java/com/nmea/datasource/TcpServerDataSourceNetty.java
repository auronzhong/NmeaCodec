package com.nmea.datasource;


import com.nmea.util.Factory;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.net.InetSocketAddress;

public class TcpServerDataSourceNetty {

    private TcpServerHandlerNetty handler;

    public TcpServerDataSourceNetty() {
        TCPHandlerAkkaSystem system = (TCPHandlerAkkaSystem) Factory.getBean("TCPHandlerAkkaSystem");
        this.handler = new TcpServerHandlerNetty(system.getActor());
    }

    public void run() {

        while (true) {
            EventLoopGroup g = new NioEventLoopGroup();

            try {
                Bootstrap bs = new Bootstrap().group(g).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true);
                bs.handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ReadTimeoutHandler(15));
                        ch.pipeline().addLast(handler);
                    }

                });

                ChannelFuture f = bs.connect(new InetSocketAddress(
                        "localhost", 8080)).sync();
                f.channel().closeFuture().sync();
            } catch (InterruptedException e) {
            } finally {
                g.shutdownGracefully();
            }
        }
    }


}
