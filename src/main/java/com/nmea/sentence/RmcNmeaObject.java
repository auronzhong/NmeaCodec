package com.nmea.sentence;

import com.nmea.annotation.SentenceField;
import com.nmea.sentence.AbstractNmeaObject;

import java.util.Date;

public class RmcNmeaObject extends AbstractNmeaObject {


    @SentenceField(order = 1,fieldType = "hhmmss.ss")
	private Date UTC;

    @SentenceField(order = 2,fieldType = "a")
	private String status;

    @SentenceField(order = 3,fieldType = "llll.ll")
	private Double latitude;

    @SentenceField(order = 4,fieldType = "a")
	private String NSIndicator;

    @SentenceField(order = 5,fieldType = "yyyyy.yy")
	private double longitude;

    @SentenceField(order = 6,fieldType = "a")
	private String EWIndicator;

    @SentenceField(order = 7,fieldType = "x.x")
	private double speedOverGround;

    @SentenceField(order = 8,fieldType = "x.x")
	private double courseOverGround;

    @SentenceField(order = 9,fieldType = "ddmmyy")
	private Date date;

    @SentenceField(order = 10,fieldType = "x.x")
	private double magneticVariation;

    @SentenceField(order = 11,fieldType = "a")
	private String mode;

	@Override
	public String getPrefix() {

		return "$GPRMC";
	}

	public Date getUTC() {
		return UTC;
	}

	public void setUTC(Object uTC) {
		this.UTC = (Date) uTC;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = (String) status;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Object latitude) {
		this.latitude = (Double) latitude;
	}

	public String getNSIndicator() {
		return NSIndicator;
	}

	public void setNSIndicator(Object nSIndicator) {
		this.NSIndicator = (String) nSIndicator;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(Object longitude) {
		this.longitude = (Double) longitude;
	}

	public String getEWIndicator() {
		return EWIndicator;
	}

	public void setEWIndicator(Object eWIndicator) {
		this.EWIndicator = (String) eWIndicator;
	}

	public double getSpeedOverGround() {
		return speedOverGround;
	}

	public void setSpeedOverGround(Object speedOverGround) {
		this.speedOverGround = (Double) speedOverGround;
	}

	public double getCourseOverGround() {
		return courseOverGround;
	}

	public void setCourseOverGround(Object courseOverGround) {
		this.courseOverGround = (Double) courseOverGround;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = (Date) date;
	}

	public double getMagneticVariation() {
		return magneticVariation;
	}

	public void setMagneticVariation(Object magneticVariation) {
		this.magneticVariation = (Double) magneticVariation;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(Object mode) {
		this.mode = (String) mode;
	}

}
