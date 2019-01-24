package com.sun.core.obj;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ComQueue2 {
	private List<String> queueList = Lists.newArrayList();
	private static final Integer MAX_CAPACITY=10;
	private static final Integer EMPTY_CAPACITY=0;
	private Object sign = new Object();
	
	public void put(String e) {
		while(queueList.size()==MAX_CAPACITY) {
			synchronized (sign) {
				try {
					sign.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		queueList.add(e);
		log.info("存入："+e);
		synchronized (sign) {
			sign.notifyAll();
		}
		
	}
	
	public String get() {
		while(queueList.size()==EMPTY_CAPACITY) {
			synchronized (sign) {
				try {
					log.info("没有数据陷入等待中");
					sign.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		String e = queueList.remove(0);
		log.info("取出："+e);
		return e;
		
	}
}
