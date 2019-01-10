package com.sun.core.synchronizedAndLock.notifyAndwait.handler;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.core.synchronizedAndLock.notifyAndwait.RowDealer;
import com.sun.core.synchronizedAndLock.notifyAndwait.RowProcessor;

public class SsFileChangeHandler extends SsBaseFileChangeHandler implements RowDealer {
	private RowProcessor[] processors = null;
	private int len =5;
	private Logger logger = LoggerFactory.getLogger(getClass());
	public SsFileChangeHandler() {
		// TODO Auto-generated constructor stub
		processors = new RowProcessor[len];
		for(int i=0;i<len;i++) {
			processors[i] = new RowProcessor(this);
			processors[i].start();
		}
	}
	@Override
	public void processRows(int fromRow, int toRow) {
		// TODO Auto-generated method stub
		try {
			logger.info("模拟业务操作，耗时1秒");
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void changed(long lastModified, ByteBuffer buffer) {
		// TODO Auto-generated method stub
		for (int i = 0; i < len; i++) {
			processors[i].setRange(0, 0);
		}
		
		for (int i = 0; i < len; i++) {
			processors[i].waitDone();
		}
	}

	@Override
	public void getLastModified(File targetFile) {
		// TODO Auto-generated method stub

	}

}
