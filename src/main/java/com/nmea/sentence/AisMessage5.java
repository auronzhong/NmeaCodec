package com.nmea.sentence;

import com.nmea.annotation.MessageField;

/**
 * Created by zhongwei on 15/3/22.
 */
public class AisMessage5  extends AisMessage {
    @Override
    public String getPrefix() {
        return null;
    }

    @MessageField(order = 1,requiredBits = 6)
    private Integer messageID;

    @MessageField(order = 2,requiredBits = 2)
    private Integer repeatIndicator;

    @MessageField(order = 3,requiredBits = 30)
    private Integer userID;

    @MessageField(order = 4, requiredBits = 2)
    private Integer aisVersionIndicator;

    @MessageField(order = 5, requiredBits = 30)
    private Integer imoNumber;

    @MessageField(order = 6, requiredBits = 42)
    private Integer callSign;

    @MessageField(order = 7, requiredBits = 120)
    private Integer name;

    @MessageField(order = 8, requiredBits = 8)
    private Integer typeOfShipAndCargoType;

    @MessageField(order = 9, requiredBits = 30)
    private Integer overallDimension;

    @MessageField(order = 10, requiredBits = 4)
    private Integer typeOfElectronicPostionFixingDevice;

    @MessageField(order = 11, requiredBits = 20)
    private Integer eta;

    @MessageField(order = 12, requiredBits = 8)
    private Integer maximumPresentStaticDraught;

    @MessageField(order = 13, requiredBits = 120)
    private Integer destination;

    @MessageField(order = 14, requiredBits = 1)
    private Integer dte = 1;

    @MessageField(order = 15, requiredBits = 1)
    private Integer spare;



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


    public Integer getAisVersionIndicator() {
        return aisVersionIndicator;
    }

    public void setAisVersionIndicator(Integer aisVersionIndicator) {
        this.aisVersionIndicator = aisVersionIndicator;
    }

    public Integer getImoNumber() {
        return imoNumber;
    }

    public void setImoNumber(Integer imoNumber) {
        this.imoNumber = imoNumber;
    }

    public Integer getCallSign() {
        return callSign;
    }

    public void setCallSign(Integer callSign) {
        this.callSign = callSign;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getTypeOfShipAndCargoType() {
        return typeOfShipAndCargoType;
    }

    public void setTypeOfShipAndCargoType(Integer typeOfShipAndCargoType) {
        this.typeOfShipAndCargoType = typeOfShipAndCargoType;
    }

    public Integer getOverallDimension() {
        return overallDimension;
    }

    public void setOverallDimension(Integer overallDimension) {
        this.overallDimension = overallDimension;
    }

    public Integer getTypeOfElectronicPostionFixingDevice() {
        return typeOfElectronicPostionFixingDevice;
    }

    public void setTypeOfElectronicPostionFixingDevice(Integer typeOfElectronicPostionFixingDevice) {
        this.typeOfElectronicPostionFixingDevice = typeOfElectronicPostionFixingDevice;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public Integer getMaximumPresentStaticDraught() {
        return maximumPresentStaticDraught;
    }

    public void setMaximumPresentStaticDraught(Integer maximumPresentStaticDraught) {
        this.maximumPresentStaticDraught = maximumPresentStaticDraught;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public Integer getDte() {
        return dte;
    }

    public void setDte(Integer dte) {
        this.dte = dte;
    }

    public Integer getSpare() {
        return spare;
    }

    public void setSpare(Integer spare) {
        this.spare = spare;
    }
}
