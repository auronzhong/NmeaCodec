package com.nmea.annotation;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * Created by zhongwei on 15/3/22.
 */
public class GroupItemAnnotationSorter implements Comparator<Field> {

    @Override
    public int compare(Field o1, Field o2) {

        GroupItem a = o1.getAnnotation(GroupItem.class);
        GroupItem b = o2.getAnnotation(GroupItem.class);

        return new Integer(a.order()).compareTo(new Integer(b.order()));
    }
}