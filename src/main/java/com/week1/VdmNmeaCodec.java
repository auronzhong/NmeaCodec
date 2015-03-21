package com.week1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class VdmNmeaCodec extends AbstractNmeaCodec {

	private static final long INIT_DELAY = 200;
	private static final long CHECK_INTERVAL = 500;
	private SentenceStore sentenceStore;
	private AisMessage message;

	private Timer checkTimer;

	public VdmNmeaCodec() {
		this.checkTimer = new Timer(true);
		this.sentenceStore = new SentenceStore();
		this.checkTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {
					check();
				} catch (Exception e) {
                    e.printStackTrace();
				}
			}
		}, INIT_DELAY, CHECK_INTERVAL);

	}

	protected void check() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Date now = Calendar.getInstance().getTime();

		List<VdmNmeaObject> expiredSentences = this.sentenceStore
				.getExpiredItems(now, (int) VdmNmeaCodec.CHECK_INTERVAL);

		for (VdmNmeaObject sentence : expiredSentences) {
			if (sentence != null) {
				message = new AisMessage1();
				decodeContent(sentence.getContent(), message.getContentFormat());
				this.setChanged();
				this.notifyObservers(this.getObject());
			}
		}
	}

	@Override
	public AbstractNmeaObject getObject() {
		return message;
	}

	@Override
	public void decode(String content) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {

		this.object = new VdmNmeaObject();

		super.decode(content);

		VdmNmeaObject obj = (VdmNmeaObject) this.object;

		this.object = this.sentenceStore.addItem(obj.getSerialNo(), obj);

		if (this.object != null) {
			message = new AisMessage1();
			decodeContent(((VdmNmeaObject)object).getContent(), message.getContentFormat());
		}
	}

	private void decodeContent(String content, String[] contentFormat)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException {

		int position = 0;
        for (String aContentFormat : contentFormat) {
            String field = aContentFormat.split(":")[0];
            int offset = Integer.parseInt(aContentFormat.split(":")[1]);

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

	public static void main(String[] args) {
		

		VdmNmeaCodec codec = new VdmNmeaCodec();
		try {
			codec.decode("!AIVDM,2,1,,B,16:>>s5Oh08dLO8As,0*1F");
			codec.decode("!AIVDM,2,2,,B,MAVqptj0@>p,0*5E");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 获取解析文本
		try {
			for (String result : codec.encode(codec.object)) {
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取解码后文本
		AisMessage1 obj = (AisMessage1) codec.getObject();

		try {
			String result = codec.encodeContest(obj, obj.getContentFormat());
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
