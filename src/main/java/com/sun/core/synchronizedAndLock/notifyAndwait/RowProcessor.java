package com.sun.core.synchronizedAndLock.notifyAndwait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class RowProcessor extends Thread {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private int fromRow;
	private int toRow;
	private boolean done;
	
	private Object syncStart = new Object();
	private Object syncDone = new Object();
	private RowDealer dealer = null;
	public RowProcessor(RowDealer dealer) {
		this.dealer = dealer;
		setName(getName()+"---"+dealer.getClass().getName());
	}
	public void setRange(int fromRow,int toRow) {
		this.fromRow = fromRow;
		this.toRow = toRow;
		this.done=false;
		
		//开始执行
		synchronized(syncStart) {
			syncStart.notify();
		}
	}
	
	public void waitDone() {
		//等待执行
		synchronized(syncDone) {
			if(done) {
				return;
			}else {
				try {
					syncDone.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!isInterrupted()) {
			logger.info(">>>>>>>>>>>>>notify");
			//等待执行开始
			synchronized (syncStart) {
			    try {
					syncStart.wait();
				} catch (InterruptedException e) {
					logger.info(e.toString());
				}
			}
			
			//开始执行
			if(!isInterrupted()) {
				dealer.processRows(fromRow,toRow);
				
				synchronized(syncDone) {
					done = true;
					syncDone.notify();
				}
				
			}
		}
	}
	
}
