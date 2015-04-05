package com.nmea;


import com.nmea.codec.AbstractNmeaCodec;
import com.nmea.datasource.TCPHandler;
import com.nmea.util.Factory;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhongwei on 15/4/5.
 */
public class testCodeManager {

    @Test
    public void testTCPHandler() {
        try {
            FileReader in = new FileReader("src/test/test.txt");
            BufferedReader read = new BufferedReader(in);
            TCPHandler tcpHandler = new TCPHandler(new Socket());
            tcpHandler.doDecode(read);
            AbstractNmeaCodec codec = (AbstractNmeaCodec) Factory.getBean("GLL");
            assertEquals("$GPGLL,3723.2475,N,12158.3416,W,161229.487,A,A*41", codec.encode(codec.object).get(0));

            codec = (AbstractNmeaCodec) Factory.getBean("GSV");
            assertEquals("$GPGSV,2,1,07,07,79,048,42,02,51,062,43,26,36,256,42,27,27,138,42*71", codec.encode(codec.object).get(0));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
