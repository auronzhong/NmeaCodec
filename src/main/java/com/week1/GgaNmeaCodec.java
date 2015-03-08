package com.week1;

public class GgaNmeaCodec extends AbstractNmeaCodec {

	public GgaNmeaCodec(){
		object = new GgaNmeaObject();
		format = new String[] { "", "UTC:hhmmss.ss",
				"latitude:llll.ll", "NSIndicator:a", "longitude:yyyyy.yy",
				"EWIndicator:a", "positionFixIndicator:a",
				"satellitesUsed:aa", "HDOP:x.x", "MSLAltitude:x.x", "mUnits:a",
				"geoidSeparation:x.x", "gUnits:a", "ageOfDiffCorr:x.x",
				"diffRefStationID:a" };
	}
	
}
