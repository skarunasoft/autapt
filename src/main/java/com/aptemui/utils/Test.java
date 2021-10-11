package com.aptemui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test {

	
	public static Integer generateRandomNumberWithSize(String size){
		Random rand = new Random();
		return rand.nextInt(Integer.valueOf(size));
	}
	
	public  static String getRandomNumbers() {
		String SALTCHARS = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) 
		{
			// length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}
	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.dir")+new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date()));
		
		String date = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
		
		String dat = new SimpleDateFormat("yyyyMMddHHmm"+1).format(new Date());
		System.out.println(dat);
		
		int n = generateRandomNumberWithSize("1000000");
		System.out.println(getRandomNumbers());
	}

}
