package com.week1;

public class AisMessage1 extends AisMessage {
	private Integer messageID;
	private Integer repeatIndicator;
	private Integer userID;
	private Integer navigationalStatus;
	private double rateOfTurn;
	private Integer SOG;
	private Integer positionAccuracy;
	private double longitude;
	private double latitude;
	private double COG;
	private Integer trueHeading;
	private Integer timeStamp;
	private Integer specialManoeuvreIndicator;
	private Integer spare;
	private Integer raimFlag;
	private Integer communicationState;

	public AisMessage1() {
		this.contentFormat = new String[] { "messageID:6", "repeatIndicator:2",
				"userID:30", "navigationalStatus:4", "rateOfTurn:8", "SOG:10",
				"positionAccuracy:1", "longitude:28", "latitude:27", "COG:12",
				"trueHeading:9", "timeStamp:6", "specialManoeuvreIndicator:2",
				"spare:3", "raimFlag:1", "communicationState:19" };
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
