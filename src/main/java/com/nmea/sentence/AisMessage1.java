package com.nmea.sentence;

import com.nmea.annotation.MessageField;

public class AisMessage1 extends AisMessage {

    @MessageField(order = 1,requiredBits = 6)
	private Integer messageID;

    @MessageField(order = 2,requiredBits = 2)
	private Integer repeatIndicator;

    @MessageField(order = 3,requiredBits = 30)
	private Integer userID;

    @MessageField(order = 4,requiredBits = 4)
	private Integer navigationalStatus;

    @MessageField(order = 5,requiredBits = 8)
	private double rateOfTurn;

    @MessageField(order = 6,requiredBits = 10)
	private Integer SOG;

    @MessageField(order = 7,requiredBits = 1)
	private Integer positionAccuracy;

    @MessageField(order = 8,requiredBits = 28)
	private double longitude;

    @MessageField(order = 9,requiredBits = 27)
	private double latitude;

    @MessageField(order = 10,requiredBits = 12)
	private double COG;

    @MessageField(order = 11,requiredBits = 9)
	private Integer trueHeading;

    @MessageField(order = 12,requiredBits = 6)
	private Integer timeStamp;

    @MessageField(order = 13,requiredBits = 2)
	private Integer specialManoeuvreIndicator;

    @MessageField(order = 14,requiredBits = 3)
	private Integer spare;

    @MessageField(order = 15,requiredBits = 1)
	private Integer raimFlag;

    @MessageField(order = 16,requiredBits = 19)
	private Integer communicationState;

	public AisMessage1() {
	}

	public Integer getMessageID() {
		return messageID;
	}

	public void setMessageID(Integer messageID) {
		this.messageID = messageID;
	}

	public Integer getRepeatIndicator() {
		return repeatIndicator;
	}

	public void setRepeatIndicator(Integer repeatIndicator) {
		this.repeatIndicator = repeatIndicator;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getNavigationalStatus() {
		return navigationalStatus;
	}

	public void setNavigationalStatus(Integer navigationalStatus) {
		this.navigationalStatus = navigationalStatus;
	}

	public Integer getRateOfTurn() {
		return (int) (rateOfTurn * 10);
	}

	public void setRateOfTurn(Integer rateOfTurn) {
		this.rateOfTurn = rateOfTurn.doubleValue() / 10;
	}

	public Integer getSOG() {
		return SOG;
	}

	public void setSOG(Integer sOG) {
		this.SOG = sOG;
	}

	public Integer getPositionAccuracy() {
		return positionAccuracy;
	}

	public void setPositionAccuracy(Integer positionAccuracy) {
		this.positionAccuracy = positionAccuracy;
	}

	public Integer getLongitude() {
		return (int) (longitude * 60000);
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude.doubleValue() / 60000;
	}

	public Integer getLatitude() {
		return (int) (latitude * 60000);
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude.doubleValue() / 60000;
	}

	public Integer getCOG() {
		return (int) (COG * 10);
	}

	public void setCOG(Integer cOG) {
		this.COG = cOG.doubleValue() / 10;
	}

	public Integer getTrueHeading() {
		return trueHeading;
	}

	public void setTrueHeading(Integer trueHeading) {
		this.trueHeading = trueHeading;
	}

	public Integer getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Integer timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getSpecialManoeuvreIndicator() {
		return specialManoeuvreIndicator;
	}

	public void setSpecialManoeuvreIndicator(Integer specialManoeuvreIndicator) {
		this.specialManoeuvreIndicator = specialManoeuvreIndicator;
	}

	public Integer getSpare() {
		return spare;
	}

	public void setSpare(Integer spare) {
		this.spare = spare;
	}

	public Integer getRaimFlag() {
		return raimFlag;
	}

	public void setRaimFlag(Integer raimFlag) {
		this.raimFlag = raimFlag;
	}

	public Integer getCommunicationState() {
		return communicationState;
	}

	public void setCommunicationState(Integer communicationState) {
		this.communicationState = communicationState;
	}

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}
}
