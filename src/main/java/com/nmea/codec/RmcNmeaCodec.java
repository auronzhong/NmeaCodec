package com.nmea.codec;

import com.nmea.sentence.RmcNmeaObject;

public class RmcNmeaCodec extends AbstractNmeaCodec {

	public RmcNmeaCodec() {
		object = new RmcNmeaObject();
	}


    @Override
    public void postDecode() {

    }
}
