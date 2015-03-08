package com.week1;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Buffer {
	 public ArrayList<String> appendContent(String content){
		 String[] inputs = content.split("\r\n");
		 ArrayList<String> output = new ArrayList<String>();
		 for(String input : inputs){
			 if(input.length() > 0)
				 if(Pattern.matches("[$!]", input.substring(0,1)))
					 output.add(input);	 
		 }
		 
		 return output;
	 }
	 
	 public static void main(String[] args){
		 Buffer buffer = new Buffer();
		 String input = "$123214\r\n!12313\r\n";
		 ArrayList<String> output = buffer.appendContent(input);
		 
		 for (String item : output){
			 System.out.println(item);
		 }
	 }
}
