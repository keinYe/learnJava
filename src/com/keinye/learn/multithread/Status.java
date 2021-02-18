package com.keinye.learn.multithread;

/**
 * 线程状态
 * @author keinYe
 *
 */
public class Status {
	/**
	 * Java 中线程分为以下 6 个状态：
	 * 1. New：新创建的线程，还未执行。
	 * 2. Runnable：运行中的线程，正在执行 run 方法中的代码。
	 * 3. Blocked：运行中的线程，因为某些操作被挂起。
	 * 4. Waiting：运行中的线程，因为某些操作处于等待状态。
	 * 5. Timed Waiting：运行中的线程，因为调用 sleep 方法处于等待状态。
	 * 6. Terminated：线程已终止
	 * 
	 * 线程终止的原因：
	 * 1. 正常终止，run 方法中的代码执行完毕。
	 * 2. 异常终止，在运行过程中发生异常终止。
	 * 3. 通过调用 stop 方法终止线程。
	 * 
	 * 通多对线程调用 join 方法，可以等待该线程执行完毕，对已经终止的线程调用 join 方法将立刻返回。
	 * join 方法可以设置等待时间。如果等待时间结束，无论线程是否仍在运行将立刻返回。
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		joinFunc();
	}
	
	public static void joinFunc() throws InterruptedException {
		Thread thread = new Thread(()->{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println("new thread run!");
		});
		System.out.println("thread start!");
		thread.start();
		thread.join();
		System.out.println("thread stop");
	}
}
