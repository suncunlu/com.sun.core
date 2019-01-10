package com.sun.core.synchronizedAndLock.notifyAndwait.handler;

import java.io.File;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public abstract class FileChangeHandler {
	protected String targetFileName;
	protected File targetFile;
	protected SimpleDateFormat sdf;
	int reclen = 0;
	byte[] bytes;
	public abstract void changed(long lastModified,ByteBuffer buffer);
	public abstract void getLastModified(File targetFile);
	private Logger logger = LoggerFactory.getLogger(getClass());
	public FileChangeHandler(){
		logger.info("init FileChangeHandler........"+LocalDateTime.now().toString());
	}
	public File getTargetFile(File folder){
		if(targetFile == null) {
			targetFile = new File(folder,targetFileName);
		}
		if(targetFile.exists()) {
			return targetFile;
		}
		return null;
	}
	public String getTargetFileName() {
		return this.targetFileName;
	}
}
