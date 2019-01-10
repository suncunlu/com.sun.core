package com.sun.core.synchronizedAndLock.notifyAndwait.handler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public abstract class SsBaseFileChangeHandler extends FileChangeHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());
	public SsBaseFileChangeHandler() {
		logger.info("init SsBaseFileChangeHandler....................."+LocalDateTime.now().toString());
		sdf = new SimpleDateFormat("yyyyMMdd-HH:mm:ss.SSS");
		reclen=70;
		bytes = new byte[reclen];
	}
	@Override
	public void getLastModified(File targetFile) {
		// TODO Auto-generated method stub
		/**
		 * 具体实现
		 */
	}

}
