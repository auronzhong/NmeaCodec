package com.nmea.codec;

import com.nmea.sentence.GgaNmeaObject;

public class GgaNmeaCodec extends AbstractNmeaCodec {

	public GgaNmeaCodec(){
		object = new GgaNmeaObject();
	}

    @Override
    public void postDecode() {

    }
}
