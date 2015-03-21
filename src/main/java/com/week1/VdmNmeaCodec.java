package com.week1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class VdmNmeaCodec extends AbstractNmeaCodec {

    private static final long INIT_DELAY = 200;
    private static final long CHECK_INTERVAL = 500;
    private SentenceStore sentenceStore;
    private AisMessage message;

    private Timer checkTimer;

    public VdmNmeaCodec() {

        this.object = new VdmNmeaObject();

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
                decodeContent(sentence.getContent());
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
    }

    @Override
    public void postDecode() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        VdmNmeaObject obj = (VdmNmeaObject) this.object;

        obj = this.sentenceStore.addItem(obj.getSerialNo(), obj);

        if (obj != null) {
            message = new AisMessage1();
            decodeContent(obj.getContent());
        }
    }


    private void decodeContent(String content)
            throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, InstantiationException {

        List<Field> annotatedFields = AbstractNmeaCodec.getMessageFields(message);

        int position = 0;
        for (Field field : annotatedFields) {

            MessageField annotation = field.getAnnotation(MessageField.class);

            Integer value = Integer.valueOf(
                    content.substring(position, position + annotation.requiredBits()), 2);

            for (Method m : message.getClass().getMethods()) {
                if (m.getName().toLowerCase()
                        .equals("set" + field.getName().toLowerCase())) {
                    m.invoke(message, value);
                }
            }
            position += annotation.requiredBits();
        }
    }

}
