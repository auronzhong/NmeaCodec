package com.nmea.codec;

import com.nmea.sentence.GsvNmeaObject;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhongwei on 15/3/22.
 */
public class GsvNmeaCodec extends AbstractNmeaCodec {

    public GsvNmeaCodec() {
        object = new GsvNmeaObject();
    }


    @Override
    public void postDecode() throws IllegalAccessException, InstantiationException, InvocationTargetException {
    }
}
