package com.nmea.util;

import com.nmea.codec.AbstractNmeaCodec;
import com.nmea.sentence.AbstractNmeaObject;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Observable;

public class CodeManager extends Observable {

    private BeanFactory bf;

    private Buffer buffer = new Buffer();

    public CodeManager() {
        bf = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public void decode(String content) {

        ArrayList<String> strings = buffer.appendContent(content);

        for (String string : strings) {
            try {

                AbstractNmeaCodec codec = (AbstractNmeaCodec) bf.getBean(string.substring(3, 6));

                codec.decode(string);

                //通知观察者
                if (codec.getObject() instanceof AbstractNmeaObject) {
                    this.setChanged();
                    this.notifyObservers(codec.getObject());
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    public ArrayList<String> encode(AbstractNmeaObject obj) {
        try {
            AbstractNmeaCodec codec = (AbstractNmeaCodec) bf.getBean(obj.getClass().getName().toUpperCase().substring(0, 3));
            return codec.encode(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
