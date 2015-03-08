package com.week1;

public abstract class AbstractNmeaObject {
	abstract public String getPrefix();
	
	protected String content;
	public String getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = (String)content;
	}
}
