package com.week1;

import java.util.Date;

public class RmcNmeaObject extends AbstractNmeaObject {

	private Date UTC;
	private String status;
	private Double latitude;
	private String NSIndicator;
	private double longitude;
	private String EWIndicator;
	private double speedOverGround;
	private double courseOverGround;
	private Date date;
	private double magneticVariation;
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
