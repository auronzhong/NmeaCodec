package com.nmea.sentence;

import com.nmea.annotation.SentenceField;

public class VdmNmeaObject extends AbstractNmeaObject {


    @SentenceField(order = 1,fieldType = "x")
    private Integer total;

    @SentenceField(order = 2,fieldType = "x")
	private Integer current;

    @SentenceField(order = 3,fieldType = "x")
	private Integer serialNo;

    @SentenceField(order = 4,fieldType = "a")
	private String channel;

    @SentenceField(order = 5,fieldType = "s--s")
    private String content;

    @SentenceField(order = 6,fieldType = "x")
	private Integer pad;
	
	

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return "!AIVDM";
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Object total) {
		this.total = (Integer)total;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Object current) {
		this.current = (Integer)current;
	}

	public Integer getSerialNo() {
		if(this.serialNo == null){
			this.serialNo = -1;
		}
		return serialNo;
	}

	public void setSerialNo(Object serialNo) {		
		this.serialNo = (Integer)serialNo;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(Object channel) {
		this.channel = (String)channel;
	}

	public Integer getPad() {
		return pad;
	}

	public void setPad(Object pad) {
		this.pad = (Integer)pad;
	}
	
	
	public void concatenate(VdmNmeaObject newSen) {	
		this.current++;
		this.content = this.content.concat(newSen.getContent());
	}

    public String getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = (String) content;
    }

}
