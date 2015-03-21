package com.week1;

public class GllNmeaCodec extends AbstractNmeaCodec {

	public GllNmeaCodec(){
		object = new GllNmeaObject();
	}


    @Override
    public void postDecode() {

    }
}
