package com.aptemui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.dir")+new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date()));
		
		
	}

}
