package com.week1;

public class RmcNmeaCodec extends AbstractNmeaCodec {

	public RmcNmeaCodec() {
		object = new RmcNmeaObject();
		format = new String[] { "", "UTC:hhmmss.ss", "status:a",
				"latitude:llll.ll", "NSIndicator:a",
				"longitude:yyyyy.yy", "EWIndicator:a",
				"speedOverGround:x.x", "courseOverGround:x.x", "date:ddmmyy",
				"magneticVariation:x.x", "mode:a" };
	}


}
