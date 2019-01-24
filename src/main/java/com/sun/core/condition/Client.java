package com.sun.core.condition;

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

}
