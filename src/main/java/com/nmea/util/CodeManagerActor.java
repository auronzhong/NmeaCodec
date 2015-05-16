package com.nmea.util;

import akka.actor.UntypedActor;
import org.zeromq.ZMQ;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zhongwei on 15/5/16.
 */
public class CodeManagerActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        // 序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(message);
        byte[] bytes = baos.toByteArray();

        //通过zeromq发送
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket publisher = context.socket(ZMQ.PUB);


        publisher.bind("tcp://*:5563");
        while (!Thread.currentThread().isInterrupted()) {
            // Write two messages, each with an envelope and content
            publisher.sendMore("Codec");
            publisher.send(bytes);
        }
        publisher.close();
        context.term();
    }
}