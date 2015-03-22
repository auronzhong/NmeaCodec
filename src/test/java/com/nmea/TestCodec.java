package com.nmea;

import static org.junit.Assert.*;

import java.util.Date;

import com.nmea.codec.*;
import com.nmea.sentence.AisMessage1;
import org.junit.Test;

public class TestCodec {

    @Test
    public void testAbstractCodec() {

        String input = "010298";
        Date c = (Date) AbstractNmeaCodec.parse(input, "ddmmyy");
        assertEquals(AbstractNmeaCodec.build(c, "ddmmyy"), input);

        input = "092204.999";
        c = (Date) AbstractNmeaCodec.parse(input, "hhmmss.ss");
        assertEquals(AbstractNmeaCodec.build(c, "hhmmss.ss"), input);

    }

    private void testCodec(AbstractNmeaCodec codec, String input) {
        try {
            codec.decode(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            for (String result : codec.encode(codec.object)) {
                assertEquals(result, input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGgaCodec() {
        testCodec(new GgaNmeaCodec(),
                "$GPGGA,092204.999,4250.5589,S,14718.5084,E,1,04,24.4,19.7,M,,,,0000*1F");
    }

    @Test
    public void testRmcCodec() {
        testCodec(new RmcNmeaCodec(),
                "$GPRMC,161229.487,A,3723.2475,N,12158.3416,W,0.13,309.62,120598,,*10");
    }

    @Test
    public void testGllCodec() {
        testCodec(new GllNmeaCodec(),
                "$GPGLL,3723.2475,N,12158.3416,W,161229.487,A,A*41");
    }

    @Test
    public void testVdmCodec() {
        VdmNmeaCodec codec = new VdmNmeaCodec();
        try {
            codec.decode("!AIVDM,1,1,,B,16:>>s5Oh08dLO8AsMAVqptj0@>p,0*67");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获取解析文本
        try {
            for (String result : codec.encode(codec.object)) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取解码后文本
        AisMessage1 obj = (AisMessage1) codec.getObject();

        try {
            String result = codec.encodeContest(obj);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testVdmCodec2() {
        VdmNmeaCodec codec = new VdmNmeaCodec();
        try {
            codec.decode("!AIVDM,2,1,,B,16:>>s5Oh08dLO8As,0*1F");
            codec.decode("!AIVDM,2,2,,B,MAVqptj0@>p,0*5E");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获取解析文本
        try {
            for (String result : codec.encode(codec.object)) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取解码后文本
        AisMessage1 obj = (AisMessage1) codec.getObject();

        try {
            String result = codec.encodeContest(obj);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
