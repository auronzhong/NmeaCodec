package com.week1;

import java.util.Date;

public class GgaNmeaObject extends AbstractNmeaObject {
	private Date UTC;
	private double latitude;
	private String NSIndicator;
	private double longitude;
	private String EWIndicator;
	private String positionFixIndicator;
	private String satellitesUsed;
	private Double HDOP;
	private Double MSLAltitude;
	private String mUnits;
	private Double geoidSeparation;
	private String gUnits;
	private Double ageOfDiffCorr;
	private String diffRefStationID;
	
	@Override
	public String getPrefix() {
		return "$GPGGA";
	}
	public void setUTC(Object uTC) {
		UTC = (Date)uTC;
	}
	public Date getUTC() {
		return UTC;
	}
	public void setLatitude(Object latitude) {
		this.latitude = (Double)latitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setNSIndicator(Object NSIndicator) {
		this.NSIndicator = (String)NSIndicator;
	}
	public String getNSIndicator() {
		return NSIndicator;
	}
	public void setEWIndicator(Object EWIndicator) {
		this.EWIndicator = (String)EWIndicator;
	}
	public String getEWIndicator() {
		return EWIndicator;
	}
	public void setLongitude(Object longitude) {
		this.longitude = (Double)longitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public String getPositionFixIndicator() {
		return positionFixIndicator;
	}
	public void setPositionFixIndicator(Object positionFixIndicator) {
		this.positionFixIndicator = (String)positionFixIndicator;
	}
	public String getSatellitesUsed() {
		return satellitesUsed;
	}
	
	public void setSatellitesUsed(Object satellitesUsed) {
		this.satellitesUsed = (String)satellitesUsed;
	}
	public Double getHDOP() {
		return HDOP;
	}
	public void setHDOP(Object HDOP) {
		this.HDOP = (Double)HDOP;
	}
	public Double getMSLAltitude() {
		return MSLAltitude;
	}
	public void setMSLAltitude(Object mSLAltitude) {
		this.MSLAltitude = (Double)mSLAltitude;
	}
	public String getMUnits() {
		return mUnits;
	}
	public void setMUnits(Object mUnits) {
		this.mUnits = (String)mUnits;
	}
	public Double getGeoidSeparation() {
		return geoidSeparation;
	}
	public void setGeoidSeparation(Object geoidSeparation) {
		this.geoidSeparation = (Double)geoidSeparation;
	}
	public String getgUnits() {
		return gUnits;
	}
	public void setgUnits(Object gUnits) {
		this.gUnits = (String)gUnits;
	}
	public Double getAgeOfDiffCorr() {
		return ageOfDiffCorr;
	}
	public void setAgeOfDiffCorr(Object ageOfDiffCorr) {
		this.ageOfDiffCorr = (Double)ageOfDiffCorr;
	}
	public String getDiffRefStationID() {
		return diffRefStationID;
	}
	public void setDiffRefStationID(Object diffRefStationID) {
		this.diffRefStationID = (String)diffRefStationID;
	}

	
}
