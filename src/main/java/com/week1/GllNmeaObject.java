package com.week1;

import java.util.Date;

public class GllNmeaObject extends AbstractNmeaObject {
	
	private Date UTC;
	private String status;
	private Double latitude;
	private String NSIndicator;
	private double longitude;
	private String EWIndicator;
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
