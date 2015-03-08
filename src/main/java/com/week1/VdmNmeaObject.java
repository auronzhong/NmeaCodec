package com.week1;

public class VdmNmeaObject extends AbstractNmeaObject {
	

	
	private Integer total;
	private Integer current;
	private Integer serialNo;
	private String channel;
	
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
			this.serialNo = 0;
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
		this.content.concat(newSen.content);
	}


}
