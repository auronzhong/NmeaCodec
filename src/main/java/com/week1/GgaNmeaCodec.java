package com.week1;

public class GgaNmeaCodec extends AbstractNmeaCodec {

	public GgaNmeaCodec(){
		object = new GgaNmeaObject();
	}

    @Override
    public void postDecode() {

    }
}
