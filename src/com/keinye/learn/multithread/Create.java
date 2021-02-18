package com.keinye.learn.multithread;

/**
 * 创建新线程
 * @author keinYe
 *
 */
public class Create {
	/**
	 * 在计算机中一个任务我们成为进程，在进程内部执行的多个子任务，我们成为线程。
	 * 一个进程可以包含一个或多个线程，但至少有一个线程。
	 * 操作系统调度的最小任务单位是线程，而不是进程。
	 * 多线程和多进程相比，多进程的缺点如下：
	 * 1. 创建进程比创建线程开销大，特别是在 Window 系统上。
	 * 2. 进程间通信比线程间通信要慢，因为线程间通信就是读写同一个变量。
	 * 
	 * Java 内置了多线程支持，一个Java 程序实际上就是一个 JVM 进程，JVM 进程通过一个主线程来启动 mian 方法，在方法内部
	 * 我们可以创建多个线程，此外 JVM 还有负责垃圾回收的其他工作线程。
	 * 多线程编写经常需要读写共享变量，并且需要同步，因此多线程编程复杂度高，调试困难。
	 * 
	 * Java 使用 Thread 对象来表示一个线程，通过 start 方法来启动一个新的线程。
	 * 一个线程对象仅能调用一次 start 方法，线程的执行方法写在 run 方法内部。
	 * 线程的调度有操作系统决定，程序本身无法决定线程的调度顺序。Thread.sleep() 可以将当前线程暂停一段时间单位是毫秒。
	 * 
	 * 可以通过 Thread.setPriority(int n) 来设置线程的优先级，设置范围为 1-10 默认值为 5。优先级搞的线程操作系统调度的优先级高，
	 * 操作系统对高优先级的线程调度更频繁，但是并不能通过优先级来确保高优先级的线程一定先执行。
	 */
	
	public static Runnable threadRunnable = new Runnable() {
		@Override
		public void run() {
			System.out.println("start new Thread(Runnable)");
		}
	};
	
	public static void main(String[] args) {
		newThreadExtends();
		newThreadRunnable();
		newThreadLambda();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("new thread end");
	}
	
	public static void newThreadExtends() {
		Thread thread = new MyThread();
		thread.start();
	}
	
	public static void newThreadRunnable() {
		Thread thread = new Thread(threadRunnable);
		thread.start();
	}
	
	public static void newThreadLambda() {
		Thread thread = new Thread(() -> {
			System.out.println("start new Thread(lambda)");
		});
		thread.start();
	}
	
	
}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("start new Thread(extends)!");
	}
}
