package com.nmea.util;

import com.nmea.codec.*;
import com.nmea.sentence.AbstractNmeaObject;
import com.nmea.util.Buffer;

import java.util.ArrayList;
import java.util.Observable;

public class CodeManager extends Observable {

	private Buffer buffer = new Buffer();
	
	private VdmNmeaCodec vdmCodec = new VdmNmeaCodec();

	public void decode(String content) {

		ArrayList<String> strings = buffer.appendContent(content);

		for (String string : strings) {
			try {
				AbstractNmeaCodec codec = null;

				// GGA
				if (string.substring(3, 6) == "GGA") {
					codec = new GgaNmeaCodec();
				}
				// RMC
				if (string.substring(3, 6) == "RMC") {
					codec = new RmcNmeaCodec();
				}
				// GLL
				if (string.substring(3, 6) == "GLL") {
					codec = new GllNmeaCodec();
				}
				// VDM
				if (string.substring(3, 6) == "VDM") {
					codec = vdmCodec;
				}
				else{
					throw new Exception("error type");
				}
				codec.decode(string);
				
				//通知观察者
				if(codec.getObject() instanceof AbstractNmeaObject){
					this.setChanged();
					this.notifyObservers(codec.getObject());
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	}

	public ArrayList<String> encode(AbstractNmeaObject obj) {
		try {
			AbstractNmeaCodec codec = null;
			if (obj.getClass().getName().toUpperCase().contains("GGA")) {
				codec = new GgaNmeaCodec();
			}
			if (obj.getClass().getName().toUpperCase().contains("RMC")) {
				codec = new RmcNmeaCodec();
			}
			if (obj.getClass().getName().toUpperCase().contains("GLL")) {
				codec = new GllNmeaCodec();
			}else{
				throw new Exception("error type");
			}
			return codec.encode(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
