package com.sun.core.base4static;

import com.sun.core.util.ConfigManager;

//import static com.sun.core.util.ConfigManager.*;//静态导入
public class MainClient {
	final String a="";
	//private final String b="";
	private static String configPath =ConfigManager.getConfigPath();
	 static {
		System.out.println("excute static code block in MainClient");
	}
	public  String  getPath() {
		return configPath + "-" ;
	}
}
