package com.sun.core.util;

public class ConfigManager {
	private static String path="hogu";
	public static String configContext="";
	static{
		System.out.println("excute static block in ConfigManager class");
	}
	public static String getConfigPath() {
		
		return path;
		
	}
}
