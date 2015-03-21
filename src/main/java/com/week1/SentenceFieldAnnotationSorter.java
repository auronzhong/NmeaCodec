package com.week1;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * Created by zhongwei on 15/3/21.
 */
public class SentenceFieldAnnotationSorter implements Comparator<Field> {

    @Override
    public int compare(Field o1, Field o2) {

        SentenceField a = o1.getAnnotation(SentenceField.class);
        SentenceField b = o2.getAnnotation(SentenceField.class);

        return new Integer(a.order()).compareTo(new Integer(b.order()));
    }

}
