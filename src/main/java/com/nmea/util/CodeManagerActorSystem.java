package com.nmea.util;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.nmea.datasource.TCPHandlerAkka;

/**
 * Created by zhongwei on 15/5/16.
 */
public class CodeManagerActorSystem {

    private ActorSystem system;
    private ActorRef actor;

    public CodeManagerActorSystem() {
        system = ActorSystem.create("ServerSys");

        actor = system.actorOf(Props.create(CodeManagerActor.class), "serverActor");
    }

    public static void main(String[] args) {
        new CodeManagerActorSystem();
    }

    public ActorRef getActor() {
        return this.actor;
    }
}
