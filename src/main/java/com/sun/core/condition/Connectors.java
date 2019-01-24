package com.sun.core.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Connectors{
	private int size=0;
	private int maxSize=10;
	private int minSize=0;
	private Lock lock = new ReentrantLock();
	private Condition full= lock.newCondition();
	private Condition empty=lock.newCondition();
	
	public void produce(String producer) {
		lock.lock();
		try {
			for (int i = 0; i <20; i++) {
				while(size>=maxSize){
					try {
						full.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				size++;
				log.info("producer {}，size={}",producer,size);
				empty.signalAll();
			}
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}
	
	public void consume(String comsumer) {
		lock.lock();
		try {
			for (int i = 0; i <20; i++) {
				while(size<=minSize){
					try {
						empty.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				size--;
				log.info("comsumer {}，size={}",comsumer,size);
				full.signalAll();
			}
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}
}
