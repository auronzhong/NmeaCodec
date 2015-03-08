package com.week1;

import java.util.Date;

public abstract class AbstractNmeaObject {
	abstract public String getPrefix();
	private Date recievedDate;
	
	protected String content;
	
	public AbstractNmeaObject(){
		this.recievedDate = new Date();
	}
	
	public Date getRecieveDate(){
		return this.recievedDate;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = (String)content;
	}
}
