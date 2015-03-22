package com.nmea.sentence;

import com.nmea.annotation.SentenceField;
import com.nmea.sentence.AbstractNmeaObject;

import java.util.Date;

public class GllNmeaObject extends AbstractNmeaObject {


    @SentenceField(order = 1,fieldType = "yyyyy.yy")
	private Double latitude;

    @SentenceField(order = 2,fieldType = "a")
	private String NSIndicator;

    @SentenceField(order = 3,fieldType = "llll.ll")
	private double longitude;

    @SentenceField(order = 4,fieldType = "a")
	private String EWIndicator;

    @SentenceField(order = 5,fieldType = "hhmmss.ss")
    private Date UTC;

    @SentenceField(order = 6,fieldType = "a")
    private String status;

    @SentenceField(order = 7,fieldType = "a")
	private String mode;

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return "$GPGLL";
	}

	public Date getUTC() {
		return UTC;
	}

	public void setUTC(Object uTC) {
		this.UTC = (Date)uTC;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = (String)status;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Object latitude) {
		this.latitude = (Double)latitude;
	}

	public String getNSIndicator() {
		return NSIndicator;
	}

	public void setNSIndicator(Object nSIndicator) {
		this.NSIndicator = (String)nSIndicator;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(Object longitude) {
		this.longitude = (Double)longitude;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(Object mode) {
		this.mode = (String)mode;
	}

	public String getEWIndicator() {
		return EWIndicator;
	}

	public void setEWIndicator(Object eWIndicator) {
		this.EWIndicator = (String)eWIndicator;
	}

}
