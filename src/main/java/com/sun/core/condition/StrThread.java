package com.sun.core.condition;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class StrThread extends Thread {
	private int index;
	String j1 = "+";
	String j2 = "-";
	String j3 = "/";
	String j4 = "*";
	String[] r = new String[] { j1, j2, j3, j4 };

	String s1 = " (70 T1 45 ) T2 3 T3 16";// (70 45) 3 16

	String s2 = " 70 T1 (45  T2 3 ) T3 16";// 70 (45 3) 16

	String s3 = " 70 T1 45  T2 ( 3  T3 16 )";// 70 45 (3 16)

	String s4 = " (70 T1 45  T2  3 ) T3 16 ";// (70 45 3) 16

	String s5 = " 70 T1 ( 45  T2  3  T3 16 )";// 70 (45 3 16)
	
	String s6 = "(70 T1 45) T2 ( 3 T3 16)";// (70 45) ( 3 16)
	
	String s7 = "70 T1 45 T2  3 T3 16";// 70 45  3 16
	
	String[] sT = new String[] { s1, s2, s3, s4, s5 ,s6,s7};
	private  Set<String> setRe;
	public StrThread(int i, Set<String> set) {
		super();
		this.index = i;
		this.setRe=set;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		String script = sT[index];
		ScriptEngineManager m = new ScriptEngineManager();
		ScriptEngine e = m.getEngineByName("js");
		Iterator<String> iterator = setRe.iterator();
		
		
		while (iterator.hasNext()) {
			String s = iterator.next();
			String[] split = s.split(",");
			String t1=split[0];
			String t2=split[1];
			String t3=split[2];
			
			String sC = script.replaceFirst("T1", t1).replaceFirst("T2", t2).replaceFirst("T3", t3);
			//System.out.println(sC);
			try {
				String eval = e.eval(sC).toString();
				//System.out.println(eval);
				System.out.println(String.format("%s,%s,%s,%s,%s", index, t1, t2, t3,eval));
				System.out.println("==============================================================================================");
			} catch (ScriptException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
