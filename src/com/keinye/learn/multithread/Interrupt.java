package com.keinye.learn.multithread;


/**
 * 中断线程
 * @author keinYe
 *
 */
public class Interrupt {
	/**
	 * 中断线程是指该线程接收到其他线程的信号从而结束 run 方法的执行，使线程自身结束运行。
	 * 
	 * 通过 interrupt 方法来中断一个线程，但是是否执行中断有改线程自己决定，发送中断请求的线程无法真正决定。
	 * 
	 * 如果调用 join 方法处于等待状态，调用 interrupt 方法中断线程，join 方法将立刻返回 InterruptException 异常，并且线程立刻终止运行。
	 * 
	 * 对目标线程调用 interrupt 方法可以中断一个线程，目标线程通过 isInterrupt 方法检测自身是否中断，如果目标线程处于等待状态，将会
	 * 检测到 InterruptException 异常。
	 * 
	 * 目标线程检测到 isInterrupt 为 true 或 InterruptException 异常都应该立刻结束自身线程。
	 * 
	 * 通过标志位判断是否中断线程要使用关键字 volatile。volatile 关键字解决了共享变量在线程间的可见性问题。
	 */
	
	
	public static void main(String[] args) {
		interruptThread();
		flagThread();
	}
	
	public static void interruptThread() {
		Thread thread = new InterruptThread();
		System.out.println("Interrupt Thread start");
		thread.start();
		try {
			Thread.sleep(1000);
			thread.interrupt();
			thread.join();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		System.out.println("Interrupt Thread end");		
	}
	
	public static void flagThread() {
		FlagThread thread = new FlagThread();
		System.out.println("Flag Thread start");
		thread.start();
		try {
			Thread.sleep(1);
			thread.isRunning = false;
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}

class InterruptThread extends Thread {
	@Override
	public void run() {
		int n = 0;
		while (!isInterrupted()) {
			System.out.println("Interrupt: " + n++);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				break;
			}
		}
	}
}

class FlagThread extends Thread {
	public volatile boolean isRunning = true;
	@Override
	public void run() {
		int n = 0;
		while (isRunning) {
			System.out.println("Flag: " + n++);
		}
		System.out.println("Flag stop");
	}
}
