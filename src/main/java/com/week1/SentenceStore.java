package com.week1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class SentenceStore {
	private HashMap<Integer, VdmNmeaObject> storedSentences = new HashMap<Integer, VdmNmeaObject>();

	public List<VdmNmeaObject> getExpiredItems(Date checkTime, int milliSeconds) {
		
		List<VdmNmeaObject> result = new ArrayList<VdmNmeaObject>();
		List<Integer> keys = new ArrayList<Integer>();
		
		if (checkTime == null || milliSeconds < 0)
			return result;
		
		long time = checkTime.getTime() - milliSeconds;
		
		synchronized (this) {
			
			for (int key : this.storedSentences.keySet()) {
				
				if (this.storedSentences.get(key).getRecieveDate().getTime() < time) {
					keys.add(key);
					result.add(this.storedSentences.get(key));
				}
			}
			
			for (int key : keys) {
				this.storedSentences.remove(key);
			}
		}
		keys.clear();
		
		return result;
	}

	
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
