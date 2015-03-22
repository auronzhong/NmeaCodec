package com.nmea.sentence;

import com.nmea.annotation.SentenceField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongwei on 15/3/22.
 */
public class GsvNmeaObject extends AbstractNmeaObject {

    @SentenceField(order = 1, fieldType = "x")
    private Integer numberOfMessages;

    @SentenceField(order = 2, fieldType = "x")
    private Integer messageNumber;

    @SentenceField(order = 3, fieldType = "a")
    private String satellitesInView;

    @SentenceField(order = 4, isGroup = true, groupItemClass = "com.nmea.sentence.ChannelInfo")
    private List<ChannelInfo> channels;


    @Override
    public String getPrefix() {
        return "$GPGSV";
    }

    public GsvNmeaObject() {
        channels = new ArrayList<ChannelInfo>();
    }


    public Integer getNumberOfMessages() {
        return numberOfMessages;
    }

    public void setNumberOfMessages(Object numberOfMessages) {
        this.numberOfMessages = (Integer) numberOfMessages;
    }

    public Integer getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(Object messageNumber) {
        this.messageNumber = (Integer) messageNumber;
    }

    public String getSatellitesInView() {
        return satellitesInView;
    }

    public void setSatellitesInView(Object satellitesInView) {
        this.satellitesInView = (String) satellitesInView;
    }


    public String getChannels() {
        String result = "";
        for (ChannelInfo channel : channels) {
            result += channel.toString() + ",";
        }
        return result.substring(0, result.length() - 1);
    }

    public void setChannels(Object channel) {
        this.channels.add((ChannelInfo) channel);
    }
}
