package com.week1;

public class GllNmeaCodec extends AbstractNmeaCodec {

	public GllNmeaCodec(){
		object = new GllNmeaObject();
		format = new String[] { "",
				"latitude:llll.ll", "NSIndicator:a",
				"longitude:yyyyy.yy", "EWIndicator:a", 
				"UTC:hhmmss.ss", "status:a", "mode:a"};
	}
	

}
