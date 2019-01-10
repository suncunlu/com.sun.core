package com.sun.core.synchronizedAndLock.notifyAndwait.handler;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.core.synchronizedAndLock.notifyAndwait.RowDealer;
import com.sun.core.synchronizedAndLock.notifyAndwait.RowProcessor;


public class HtgFileChangeHandler extends SsBaseFileChangeHandler implements RowDealer{
	/**
	 * 
	 * 成员变量
	 * 
	 * 
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	private OpenPriceMonitor monitor = null;
	private Properties openPriceMap = null;
	private int len =0;
	private RowProcessor[] processors = null;
	private boolean shutDown=false;
	private String cls=null;
	public HtgFileChangeHandler() {
		logger.info("init HtgFileChangeHandler........"+LocalDateTime.now().toString());
		targetFileName = "mmm.txt";
		monitor = new OpenPriceMonitor();
		monitor.start();
		openPriceMap = new Properties();
		len=5;
		processors = new RowProcessor[len];
		for (int i = 0; i < len; i++) {
			processors[i] = new RowProcessor(this);
			processors[i].start();
		}
		
	}
	@Override
	public void processRows(int fromRow, int toRow) {
		// TODO Auto-generated method stub
		/**
		 * 具体实现
		 */
		try {
			logger.info("模拟业务操作，耗时1秒");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void changed(long lastModified, ByteBuffer buffer) {
		// TODO Auto-generated method stub
		/**
		 * 具体实现
		 */
		//分配任务
		for(int i=0;i<len;i++) {
			processors[i].setRange(0, 0);
		}
		//等待任务执行完成
		for(int i=0;i<len;i++) {
			processors[i].waitDone();
		}
		
		
	}
	private class OpenPriceMonitor extends Thread{
		
		final private long checkInterval = 6000L;
		long lastUpdDate = 0;
		final long startTime = 928;
		
		public OpenPriceMonitor() {
			/*Reader inStream = null;
			*//**
			 * 初始化一些业务数据
			 *//*
			try {
				openPriceMap.load(inStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		@Override
		public void run() {
			
			while(!shutDown) {
				/**
				 * 业务处理
				 */
/*				try {
					openPriceMap.store(new FileOutputStream(targetFile), "");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}
	}
}
