package com.week1;

public abstract class AisMessage extends AbstractNmeaObject {
	protected String[] contentFormat;
	public String[] getContentFormat() {
		return contentFormat;
	}
}
