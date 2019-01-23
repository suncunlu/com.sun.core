package com.sun.core.synchronizedAndLock.atomicReference;

import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;

public class Client {
	@Test
	public void testAtomicReference() {
		AtomicReference<String> aref = new AtomicReference<>();
		aref.set("mon");
		
		
		String v = aref.get();
		
		System.out.println(v);
	}
}
