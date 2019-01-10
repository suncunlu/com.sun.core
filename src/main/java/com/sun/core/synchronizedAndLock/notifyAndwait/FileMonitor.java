package com.sun.core.synchronizedAndLock.notifyAndwait;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.core.synchronizedAndLock.notifyAndwait.handler.FileChangeHandler;

public class FileMonitor extends Thread {
	private File targetFile = null;
	private String targetFilePath = null;
	private FileChangeHandler changeHandler = null;
	private Logger logger = LoggerFactory.getLogger(getClass());
	public FileMonitor(String targetFilePath) {
		this.targetFilePath = targetFilePath;
	}
	@Override
	public void run() {
		long lastModified = 0;
		ByteBuffer buffer = ByteBuffer.allocate(4*1024*1024);
		while(!isInterrupted()) {
			logger.info("本次开始");
			changeHandler.changed(lastModified, buffer);
			logger.info("本次完成");
			//initCount();
			if(!isInterrupted())
				try {
					TimeUnit.SECONDS.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	/**
	 * @return the targetFile
	 */
	public File getTargetFile() {
		return targetFile;
	}
	/**
	 * @param targetFile the targetFile to set
	 */
	public void setTargetFile(File targetFile) {
		this.targetFile = targetFile;
	}
	/**
	 * @return the targetFilePath
	 */
	public String getTargetFilePath() {
		return targetFilePath;
	}
	/**
	 * @param targetFilePath the targetFilePath to set
	 */
	public void setTargetFilePath(String targetFilePath) {
		this.targetFilePath = targetFilePath;
	}
	/**
	 * @return the changeHandler
	 */
	public FileChangeHandler getChangeHandler() {
		return changeHandler;
	}
	/**
	 * @param changeHandler the changeHandler to set
	 */
	public void setChangeHandler(FileChangeHandler changeHandler) {
		this.changeHandler = changeHandler;
		setName(getName()+"---"+changeHandler.getClass().getName());
	}
}
