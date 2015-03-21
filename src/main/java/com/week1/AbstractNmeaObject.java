package com.week1;

import java.util.Date;

public abstract class AbstractNmeaObject {
	abstract public String getPrefix();
	private Date recievedDate;
	
	public AbstractNmeaObject(){
		this.recievedDate = new Date();
	}
	
	public Date getRecieveDate(){
		return this.recievedDate;
	}

}
