package com.nmea.sentence;

import com.nmea.annotation.SentenceField;
import com.nmea.sentence.AbstractNmeaObject;

import java.util.Date;

public class GgaNmeaObject extends AbstractNmeaObject {


    @SentenceField(order = 1,fieldType = "hhmmss.ss")
    private Date UTC;

    @SentenceField(order = 2,fieldType = "llll.ll")
	private double latitude;

    @SentenceField(order = 3,fieldType = "a")
	private String NSIndicator;

    @SentenceField(order = 4,fieldType = "yyyyy.yy")
	private double longitude;

    @SentenceField(order = 5,fieldType = "a")
	private String EWIndicator;

    @SentenceField(order = 6,fieldType = "a")
	private String positionFixIndicator;

    @SentenceField(order = 7,fieldType = "aa")
	private String satellitesUsed;

    @SentenceField(order = 8,fieldType = "x.x")
	private Double HDOP;

    @SentenceField(order = 9,fieldType = "x.x")
	private Double MSLAltitude;

    @SentenceField(order = 10,fieldType = "a")
	private String mUnits;

    @SentenceField(order = 11,fieldType = "x.x")
	private Double geoidSeparation;

    @SentenceField(order = 12,fieldType = "a")
	private String gUnits;

    @SentenceField(order = 13,fieldType = "x.x")
	private Double ageOfDiffCorr;

    @SentenceField(order = 14,fieldType = "a")
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
