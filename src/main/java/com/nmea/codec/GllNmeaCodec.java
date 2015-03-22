package com.nmea.codec;

import com.nmea.sentence.GllNmeaObject;

public class GllNmeaCodec extends AbstractNmeaCodec {

	public GllNmeaCodec(){
		object = new GllNmeaObject();
	}


    @Override
    public void postDecode() {

    }
}
