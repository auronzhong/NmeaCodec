package com.nmea.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by zhongwei on 15/4/4.
 */
public class Factory {

    private static BeanFactory bf;

    static {
        bf = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static Object getBean(String beanName){
        return bf.getBean(beanName);
    };
}
