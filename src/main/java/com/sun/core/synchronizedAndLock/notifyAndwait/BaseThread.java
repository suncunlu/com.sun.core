package com.sun.core.synchronizedAndLock.notifyAndwait;

import java.util.concurrent.atomic.AtomicLong;

public class BaseThread extends Thread {
	private static AtomicLong count=new AtomicLong(1);
	protected long generThreadNum() {
		return count.getAndIncrement();
	}
	protected void initCount() {
		count.set(1);
	}
}
