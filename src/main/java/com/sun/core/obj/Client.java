package com.sun.core.obj;


import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Client {
	@Test
	public void fg() {
		ComQueue queue = new ComQueue();
		log.info("start............................");
		for (int i = 0; i < 5; i++) {
			queue.put(i+"");
		}
		for (int i = 0; i < 7; i++) {
			queue.get();
		}
		
	}
}
