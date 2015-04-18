package com.nmea.datasource;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.nmea.util.CodeManager;
import com.nmea.util.Factory;

/**
 * Created by zhongwei on 15/4/18.
 */
public class TCPHandlerAkka extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof String){
            ((CodeManager) Factory.getBean("CodeManager")).decode((String) message);
        }
    }
}
