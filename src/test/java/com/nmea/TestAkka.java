package com.nmea;

import akka.actor.ActorRef;
import com.nmea.codec.AbstractNmeaCodec;
import com.nmea.datasource.TCPHandlerAkkaSystem;
import com.nmea.util.Factory;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhongwei on 15/4/18.
 */
public class TestAkka {
    @Test
    public void runAkka(){
        TCPHandlerAkkaSystem system = (TCPHandlerAkkaSystem) Factory.getBean("TCPHandlerAkkaSystem");
        ActorRef remoteActor = system.getActor();
        remoteActor.tell("$GPGLL,3723.2475,N,12158.3416,W,161229.487,A,A*41", null);

        AbstractNmeaCodec codec = (AbstractNmeaCodec) Factory.getBean("GLL");
        try {
            assertEquals("$GPGLL,3723.2475,N,12158.3416,W,161229.487,A,A*41", codec.encode(codec.object).get(0));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
