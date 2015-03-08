package com.week1;

import java.util.HashMap;

public class SentenceStore {
	private HashMap<Integer, VdmNmeaObject> storedSentences = new HashMap<Integer, VdmNmeaObject>();

	
	
	public VdmNmeaObject addItem(int key, VdmNmeaObject value) {
		if(value.getTotal() == 1){
			return value;
		}
		synchronized (this) {
			if (this.storedSentences.containsKey(key)) {
				
				VdmNmeaObject oldValue = this.storedSentences.get(key);
				
				if (oldValue.getCurrent() + 1 == value.getCurrent()) {
					
					if (value.getCurrent() == value.getTotal()) {
						
						oldValue.concatenate(value);
						this.storedSentences.remove(key);
						return oldValue;
					} else {
						oldValue.concatenate(value);
						return null;
					}
					
				} else {
					this.storedSentences.remove(key);
					
					if (value.getCurrent() == 1)
						this.storedSentences.put(key, value);
					return oldValue;
				}
				
			} else if (value.getCurrent() == 1) {
				this.storedSentences.put(key, value);
				return null;
			} else {
				return null;
			}
			
		}
	}

}
