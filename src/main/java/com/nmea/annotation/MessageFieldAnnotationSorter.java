package com.nmea.annotation;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * Created by zhongwei on 15/3/21.
 */
public class MessageFieldAnnotationSorter implements Comparator<Field> {

    @Override
    public int compare(Field o1, Field o2) {

        MessageField a = o1.getAnnotation(MessageField.class);
        MessageField b = o2.getAnnotation(MessageField.class);

        return new Integer(a.order()).compareTo(new Integer(b.order()));
    }

}