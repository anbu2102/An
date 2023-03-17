package com.baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class A {

	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\kaviy\\eclipse-workspace\\OMRBranchAutomation\\Config\\Config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Object object = properties.get("url");
		String v= (String)object;
		System.out.println(v);
		}

}
