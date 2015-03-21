package com.week1;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.*;

public abstract class AbstractNmeaCodec extends Observable {

    protected AbstractNmeaObject object;

    public AbstractNmeaObject getObject() {
        return object;
    }


    public void decode(String content) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException,
            InstantiationException {



        String input = content.split("\\*")[0];
        String checkSum = content.split("\\*")[1];
        try {
            if (!getCheckSum(input.substring(1)).equals(checkSum)) {
                this.object = null;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String[] datas = input.split(",");

        List<Field> annotatedFields = AbstractNmeaCodec.getSentenceFields(object);

        int i = 1;

        for (Field field : annotatedFields) {

            SentenceField annotation = field.getAnnotation(SentenceField.class);


            for (Method m : object.getClass().getMethods()) {
                if (m.getName().toLowerCase()
                        .equals("set" + field.getName().toLowerCase())) {
                    if (i >= datas.length) {
                        m.invoke(object, parse("", annotation.fieldType()));
                    } else {
                        m.invoke(object, parse(datas[i], annotation.fieldType()));
                    }
                }
            }

            i++;
        }


    }

    static public List<Field> getSentenceFields(AbstractNmeaObject sentence) {

        List<Field> annotatedFields = new ArrayList<Field>();
        for (Field field : sentence.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(SentenceField.class)) {
                annotatedFields.add(field);
            }
        }

        Collections.sort(annotatedFields, new SentenceFieldAnnotationSorter());
        return annotatedFields;
    }


    protected String encodeContest(AbstractNmeaObject obj, String[] format)
            throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        String result = "";
        for (int i = 0; i < format.length; i++) {
            String field = format[i].split(":")[0];
            for (Method m : obj.getClass().getMethods()) {
                if (m.getName().toLowerCase()
                        .equals("get" + field.toLowerCase())) {
                    if (i > 0)
                        result += ",";
                    result += m.invoke(obj);
                }
            }
        }
        return result;
    }

    public ArrayList<String> encode(AbstractNmeaObject obj)
            throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        List<Field> annotatedFields = AbstractNmeaCodec.getSentenceFields(object);

        String result = "";

        for (Field field : annotatedFields) {

            SentenceField annotation = field.getAnnotation(SentenceField.class);

            for (Method m : obj.getClass().getMethods()) {
                if (m.getName().toLowerCase()
                        .equals("get" + field.getName().toLowerCase())) {
                    result += ",";
                    result += build(m.invoke(obj), annotation.fieldType());
                }
            }
        }

        ArrayList<String> results = new ArrayList<String>();
        result = obj.getPrefix() + result;
        // 生成校验码
        try {
            result = result + "*" + getCheckSum(result.substring(1));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        results.add(result);
        return results;
    }

    private String getCheckSum(String input)
            throws UnsupportedEncodingException {
        int output = 0;
        byte[] bytes = input.getBytes("ASCII");
        for (int i = 0; i < bytes.length; i++) {
            output = output ^ (int) bytes[i];
        }
        String result = leftPad(Integer.toBinaryString(output), 8);
        // System.out.println(result);
        return Integer.toHexString(Integer.valueOf(result.substring(0, 4), 2))
                .toString().toUpperCase()
                + Integer
                .toHexString(Integer.valueOf(result.substring(4, 8), 2))
                .toString().toUpperCase();

    }

    private static String leftPad(String input, int length) {
        String result = input;
        for (int j = 0; j < length - input.length(); j++)
            result = "0" + result;
        return result;
    }

    protected static Object parse(String source, String format) {
        if (source.equals("")) {
            if (format.equals("x.x"))
                return 0.0;
            return null;
        }

        if (format.equals("llll.ll"))
            return parseLatitude(source);
        if (format.equals("yyyyy.yy"))
            return parseLongitude(source);
        if (format.equals("hhmmss.ss"))
            return parseCommonTime(source);
        if (format.equals("ddmmyy"))
            return parseCommonDate(source);
        if (format.equals("s--s"))
            return parseBytes(source);
        if (format.equals("x.x"))
            return Double.parseDouble(source);
        if (format.equals("x"))
            return Integer.parseInt(source);
        else
            return source;
    }

    protected static String build(Object source, String format) {
        if (source == null)
            return "";
        if (format.equals("llll.ll"))
            return buildLatitude(source);
        if (format.equals("yyyyy.yy"))
            return buildLongitude(source);
        if (format.equals("hhmmss.ss"))
            return buildCommonTime(source);
        if (format.equals("ddmmyy"))
            return buildCommonDate(source);
        if (format.equals("x.x")) {
            if ((Double) source == 0.0)
                return "";
            return Double.toString((Double) source);
        }
        if (format.equals("x")) {
            return Integer.toString((Integer) source);
        } else
            return (String) source;
    }

    private static Date parseCommonTime(String token) {
        double temp = Double.parseDouble(token);

        int sss = (int) ((temp - (int) temp) * 1000.0);
        int hh = (int) ((int) temp / 10000.0);
        int mm = (int) (((int) temp - hh * 10000.0) / 100.0);
        int ss = (int) ((int) temp - hh * 10000.0 - mm * 100.0);

        java.util.Date result = new java.util.Date();
        Calendar cd = Calendar.getInstance();
        cd.setTime(result);
        cd.set(Calendar.HOUR_OF_DAY, hh);
        cd.set(Calendar.MINUTE, mm);
        cd.set(Calendar.SECOND, ss);
        cd.set(Calendar.MILLISECOND, sss);

        return cd.getTime();
    }

    private static Date parseCommonDate(String source) {
        if (source.length() == 6) {
            int date = Integer.parseInt(source.substring(0, 2));
            int month = Integer.parseInt(source.substring(2, 4));
            int year = Integer.parseInt(source.substring(4, 6)) + 2000;
            Calendar cd = Calendar.getInstance();
            cd.set(Calendar.YEAR, year);
            cd.set(Calendar.MONTH, month - 1);
            cd.set(Calendar.DATE, date);

            return cd.getTime();
        } else {
            throw new IllegalArgumentException(String.format(
                    "Date format incorrect in %1$s (must be ddmmyy)", source));
        }
    }

    private static String buildCommonTime(Object token) {
        Calendar cd = Calendar.getInstance();
        cd.setTime((Date) token);
        return leftPad(Integer.toString(cd.get(Calendar.HOUR_OF_DAY)), 2)
                + leftPad(Integer.toString(cd.get(Calendar.MINUTE)), 2)
                + leftPad(Integer.toString(cd.get(Calendar.SECOND)), 2)
                + "."
                + leftPad(Integer.toString(cd.get(Calendar.MILLISECOND) + 1), 2);
    }

    private static String buildCommonDate(Object token) {
        Calendar cd = Calendar.getInstance();
        cd.setTime((Date) token);
        return leftPad(Integer.toString(cd.get(Calendar.DATE)), 2)
                + leftPad(Integer.toString(cd.get(Calendar.MONTH) + 1), 2)
                + Integer.toString(cd.get(Calendar.YEAR)).substring(2);
    }

    private static double parseLatitude(String token) {
        double temp = Double.parseDouble(token);

        double degree = (int) ((int) temp / 100.0);
        double minutes = ((int) temp - degree * 100.0);
        double seconds = (temp - (int) temp) * 60.0;

        return degree + minutes / 60.0 + seconds / 3600.0;
    }

    private static double parseLongitude(String token) {
        return parseLatitude(token);
    }

    private static String buildLatitude(Object token) {
        double temp = (Double) token;

        double seconds = Double.parseDouble(new DecimalFormat("#.####")
                .format(temp * 60 - (int) (temp * 60)));
        double minutes = (int) (temp * 60) % 60;
        double degree = (int) ((int) (temp * 60) / 60);

        return Double.toString(degree * 100 + minutes + seconds);
    }

    private static String buildLongitude(Object token) {
        return buildLatitude(token);
    }

    private static String parseBytes(String token) {
        String result = "";
        for (int i = 0; i < token.length(); i++) {
            try {
                result = result + decodeByte(token.substring(i, i + 1));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static String decodeByte(String input)
            throws UnsupportedEncodingException {
        int temp = (int) (input.getBytes("ASCII")[0]);
        temp += Integer.valueOf("101000", 2);
        if (temp > Integer.valueOf("10000000", 2)) {
            temp += Integer.valueOf("100000", 2);
        } else {
            temp += Integer.valueOf("101000", 2);
        }
        return leftPad(Integer.toBinaryString(temp), 8).substring(2, 8);
    }


}
