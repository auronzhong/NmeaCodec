package com.week1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class VdmNmeaCodec extends AbstractNmeaCodec {
	
	private SentenceStore sentenceStore = new SentenceStore();
	private AisMessage message;


	public VdmNmeaCodec() {
		object = new VdmNmeaObject();
		format = new String[] { "", "total:x", "current:x", "serialNo:x",
				"channel:a", "content:s--s", "pad:x" };
	}
	
	@Override
	public AbstractNmeaObject getObject(){
		return message;
	}

	@Override
	public void decode(String content) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		super.decode(content);
		
		VdmNmeaObject obj = (VdmNmeaObject)object;
		
		this.object = sentenceStore.addItem(obj.getSerialNo(), obj);
		
		if(this.object != null){		
			message = new AisMessage1();		
			decodeContent(object.getContent(),message.getContentFormat());
		}
	}

	private void decodeContent(String content,String[] contentFormat) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {

		int position = 0;
		for (int i = 0; i < contentFormat.length; i++) {
			String field = contentFormat[i].split(":")[0];
			int offset = Integer.parseInt(contentFormat[i].split(":")[1]);

			Integer value = Integer.valueOf(
					content.substring(position, position + offset), 2);

			for (Method m : message.getClass().getMethods()) {
				if (m.getName().toLowerCase()
						.equals("set" + field.toLowerCase())) {
					m.invoke(message, value);
				}
			}
			position += offset;
		}
	}

}
