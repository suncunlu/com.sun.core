package com.sun.core.synchronizedAndLock.notifyAndwait;

import java.util.List;

import com.google.common.collect.Lists;
import com.sun.core.synchronizedAndLock.notifyAndwait.handler.HtgFileChangeHandler;
import com.sun.core.synchronizedAndLock.notifyAndwait.handler.SbFileChangeHandler;
import com.sun.core.synchronizedAndLock.notifyAndwait.handler.SsFileChangeHandler;

public class Client {
	public static void main(String[] args) {
		
		List<FileMonitor> list = Lists.newArrayList();
		
		FileMonitor htgMonitor = new FileMonitor("");
		htgMonitor.setChangeHandler(new HtgFileChangeHandler());
		
		FileMonitor sbMonitor = new FileMonitor("");
		sbMonitor.setChangeHandler(new SbFileChangeHandler());
		
		FileMonitor ssMonitor = new FileMonitor("");
		ssMonitor.setChangeHandler(new SsFileChangeHandler());
		
		list.add(sbMonitor);
		list.add(ssMonitor);
		list.add(htgMonitor);
		
		for (FileMonitor f : list) {
			f.start();
		}
		
		
	}
}
