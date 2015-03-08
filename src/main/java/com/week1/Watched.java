package com.week1;

import java.util.Observable;

public class Watched extends Observable {
	private String data = "";

	public String retrieveData() {
		return data;
	}

	public void changeData(String data) {
		if (!this.data.equals(data)) {
			this.data = data;
			setChanged();
		}

		notifyObservers();
	}
}
