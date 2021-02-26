package com.keinye.learn.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author keinYe
 *
 */
public class Execute {

	/**
	 * 线程池：
	 * 内部维护若干个线程，没有任务执行时，所有线程处于等待状态，有新任务时，就分配一个空闲线程，如果所有线程
	 * 都处于忙碌状态，要么将任务放入队列，要么创建一个新线程执行。
	 * 
	 * Java 标准库提供ExecutorService接口标识线程池，常用实现类如下：
	 * FixedThreadPool：线程数固定的线程池。
	 * CachedThreadPool：线程数根据任务动态调整的线程池。
	 * SingleThreadExecute：单线程执行的线程池。
	 * 
	 * ScheduledThreadPool 用来运行那些需要定期执行的任务。
	 */
	
	public static void main(String[] args) {
		testFixedThreadTask();
		testShceduledThreadPool();
	}
	
	public static void testFixedThreadTask() {
		ExecutorService es = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 6; i++) {
			es.submit(new FixedThreadTask("" + i));
		}
		es.shutdown();
	}
	
	public static void testShceduledThreadPool() {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
		
		ses.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("one time" + System.currentTimeMillis());
			}
		}, 1, TimeUnit.SECONDS);
		
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("fixed-rate" + System.currentTimeMillis());
			}
		}, 2, 3, TimeUnit.SECONDS);
		
		ses.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println("fixed-delay" + System.currentTimeMillis());
			}
		}, 2, 3, TimeUnit.SECONDS);
	}
}

class FixedThreadTask implements Runnable {
	private final String name;

	public FixedThreadTask(String name) {
		this.name = name;
	}
	@Override
	public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name);		
	}
	
}
