package com.sun.core.synchronizedAndLock.notifyAndwait;

public interface Handler<T> {
	void initialize(int index);
	void process(T t);
}
