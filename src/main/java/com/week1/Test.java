package com.week1;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

public class Test {
	final static Integer[] index = new Integer[]{6,2,30,4,8,10,1,28,27,12,9,6,2,3,1,19};

	/**
	 * TODO ��������������
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Test test = new Test();
		
		String input = "GPAAM,A,A,0.10,N,WPTNME";	
		input = "GPGGA,092204.999,4250.5589,S,14718.5084,E";
		//input = "GPGGA,092204.999,4250.5589,S,14718.5084,E,1,04,24.4,19.7,M,,,,0000";
		//input = "GPRMC,161229.487,A,3723.2475,N,12158.3416,W,0.13,309.62,120598,,0";
		//input = "AIVDM,1,1,,B,16:>>s5Oh08dLO8AsMAVqptj0@>p,0";
		input = "GPGGA,092204.999,4250.5589,S,14718.5084,E,1,04,24.4,19.7,M,,,,0000";
		input = "AIVDM,2,1,,B,16:>>s5Oh08dLO8As,0";
		input = "AIVDM,2,2,,B,MAVqptj0@>p,0";
		try {
			System.out.println(test.getCheckSum(input));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
//		String input = "16:>>s5Oh08dLO8AsMAVqptj0@>p";
//		
//		String output = "";
//		for (int i = 0; i < input.length(); i++) {
//			try {
//				output = output + test.decode(input.substring(i, i + 1));
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		ArrayList<Integer> results = new ArrayList<Integer>();
//		
//		int position = 0;
//		for(Integer offset : index){
//			results.add(Integer.valueOf(output.substring(position,position + offset),2));
//			position += offset;
//		}
//		
//		for (Integer result : results){
//			System.out.println(result);
//		}
		

	}

	private String getCheckSum(String input) throws UnsupportedEncodingException {
		int output = 0;
		byte[] bytes = input.getBytes("ASCII");
		for (int i = 0; i < bytes.length; i++) {
			output = output ^ (int) bytes[i];
		}
		String result = leftPad(Integer.toBinaryString(output));
		//System.out.println(result);
		return Integer.toHexString(Integer.valueOf(result.substring(0, 4), 2)).toString().toUpperCase()
				+ Integer.toHexString(Integer.valueOf(result.substring(4, 8), 2)).toString().toUpperCase();
	}
	
	private String leftPad(String input){
		String result = input;
		for (int j = 0; j < 8 - input.length(); j++)
			result = "0" + result;
		return result;
	}
	
	private String decode(String input) throws UnsupportedEncodingException{
		int temp = (int) (input.getBytes("ASCII")[0]);
		//���Ӷ�����10100
		temp += Integer.valueOf("101000", 2);
		//������10000000
		if(temp > Integer.valueOf("10000000", 2)){
			temp += Integer.valueOf("100000", 2);
		}
		else{
			temp += Integer.valueOf("101000", 2);
		}
		return leftPad(Integer.toBinaryString(temp)).substring(2,8);
	}
	
	public static Object convertMap(Class<?> type,Map<String,Integer> map) throws IntrospectionException, IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException{
		BeanInfo beanInfo = Introspector.getBeanInfo(type);
		Object obj = type.newInstance();
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length;i ++){
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (map.containsKey(propertyName)){
				Object value = map.get(propertyName);
				Object[] args = new Object[1];
				args[0] = value;
				descriptor.getWriteMethod().invoke(obj, args);
			}
		}
		return obj;
		
	}

}
