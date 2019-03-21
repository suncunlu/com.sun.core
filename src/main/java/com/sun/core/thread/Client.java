package com.sun.core.thread;


import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Client {
	public static AtomicInteger c = new AtomicInteger(0);
	public static int []arra=new int[] {1,2,3,44,4423};
	public static void main(String[] args) {
		int corePoolSize=2;
		TimeUnit unit = TimeUnit.SECONDS;
		
		ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(corePoolSize);
		
		Runnable command = new Runnable() {
			@Override
			public void run() {
				try {
					// TODO Auto-generated method stub
					System.out.println("当前值："+c.getAndIncrement());
					//System.out.println(arra[6]);
					System.out.println("继续执行............");
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					TimeUnit.SECONDS.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		long initialDelay = 0;
		long period = 3;
			scheduledThreadPoolExecutor.scheduleAtFixedRate(command, initialDelay, period, unit);
		
		
		while(true) {
			int count = scheduledThreadPoolExecutor.getActiveCount();
			
			System.out.println("thread alive:>>"+count);
			System.out.println("TaskCount :>>"+scheduledThreadPoolExecutor.getTaskCount());
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
/*	@Test
	public void tsExecutores() {		int corePoolSize=3;
	TimeUnit unit = TimeUnit.SECONDS;
	
	ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(corePoolSize);
	
	Runnable command = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("当前值："+c.getAndIncrement());
			if(c.get()==5) {
				System.out.println("====5");
				return;
			}
			System.out.println("继续执行............");
		}
	};
	
	long initialDelay = 3;
	long period = 10;
	
	scheduledThreadPoolExecutor.scheduleAtFixedRate(command, initialDelay, period, unit);
	
	
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
