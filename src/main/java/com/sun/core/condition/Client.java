package com.sun.core.condition;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;


public class Client {
	@Test
	public void connectors() {
		Connectors connectors = new Connectors();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				connectors.produce("producer1");
			}
		}).start();

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				connectors.consume("consumer1");
			}
		}).start();
		
	}
	@Test
	public void connectorsa() {
		
		
		String s1=" (a1 T1 a2 ) T2 a3 T3 a4";//(70 45) 3 16
		
		String s2=" a1 T1 (a2  T2 a3 ) T3 a4";// 70 (45 3) 16
		
		String s3=" a1 T1 a2  T2 ( a3  T3 a4 )";//70 45 (3 16)
		
		String s4=" (a1 T1 a2  T2  a3 ) T3 a4 ";// (70 45 3) 16
		
		String s5=" a1 T1 ( a2  T2  a3  T3 a4 )";//70 (45 3 16)
		String s6=" a1 T1 ( a2  T2  a3  T3 a4 )";//(70 45) ( 3 16 )
		Set<String> setRe=  new HashSet<String>();
		Random random = new Random();
		String j1 = "+";
		String j2 = "-";
		String j3 = "/";
		String j4 = "*";
		//123 234 341 342 
		String[] r = new String[] { j1, j2, j3, j4 };
		while(true) {
			
			int i = random.nextInt(3);
			int j = random.nextInt(3);
			int k = random.nextInt(3);
			String t1 = r[i];// 运算符
			String t2 = r[j];// 运算符
			String t3 = r[k];// 运算符
			StringBuilder b = new StringBuilder();
			String v = b.append(t1).append(",").append(t2).append(",").append(t3).toString();
			setRe.add(v);
			if(setRe.size()==27) {
				System.out.println(setRe.toString()+">>>>>>>>>>"+setRe.size());
				break;
			}
			
		}

		for (int i = 0; i <7; i++) {
			StrThread s = new StrThread(i,setRe);
			s.setDaemon(true);
			s.start();
		}
		try {
			TimeUnit.MINUTES.sleep(3);
			System.out.println("end...............................");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
