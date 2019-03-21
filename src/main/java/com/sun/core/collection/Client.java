package com.sun.core.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
	
	@Test
	public void tHashMap(){
		log.info("------");
		Map<String,Integer> map = new HashMap<String,Integer>(8, 0.75f);
		
		map.put("a", 43);
		map.putIfAbsent("a", 3);
		
	}
}
