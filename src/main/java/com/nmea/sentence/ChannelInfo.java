package com.nmea.sentence;

import com.nmea.annotation.GroupItem;

/**
 * Created by zhongwei on 15/3/22.
 */
public class ChannelInfo extends AbstractNmeaObject {

    @GroupItem(order = 1, itemType = "a")
    private String satelliteID;

    @GroupItem(order = 2, itemType = "a")
    private String elevation;

    @GroupItem(order = 3, itemType = "a")
    private String azimuth;

    @GroupItem(order = 4, itemType = "a")
    private String SNR;

    @Override
    public String getPrefix() {
        return null;
    }

    public ChannelInfo() {
    }

    public String getSatelliteID() {
        return satelliteID;
    }

    public void setSatelliteID(Object satelliteID) {
        this.satelliteID = (String) satelliteID;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(Object elevation) {
        this.elevation = (String) elevation;
    }

    public String getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(Object azimuth) {
        this.azimuth = (String) azimuth;
    }

    public String getSNR() {
        return SNR;
    }

    public void setSNR(Object SNR) {
        this.SNR = (String) SNR;
    }

    @Override
    public String toString() {
        return satelliteID + "," + elevation + "," + azimuth + "," + SNR;
    }
}
