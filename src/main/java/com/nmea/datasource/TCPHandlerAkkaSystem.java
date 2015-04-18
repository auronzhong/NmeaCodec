package com.nmea.datasource;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * Created by zhongwei on 15/4/18.
 */
public class TCPHandlerAkkaSystem {

    private ActorSystem system;
    private ActorRef actor;

    public TCPHandlerAkkaSystem() {
        system = ActorSystem.create("ServerSys");

        actor = system.actorOf(Props.create(TCPHandlerAkka.class), "serverActor");
    }

    public static void main(String[] args) {
        new TCPHandlerAkkaSystem();
    }

    public ActorRef getActor() {
        return this.actor;
    }
}
