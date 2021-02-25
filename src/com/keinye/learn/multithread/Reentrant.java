package com.keinye.learn.multithread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author keinYe
 *
 */
public class Reentrant {
	/**
	 * 多线程运行的原则：当条件不满足时，线程进入等待状态，当条件满足时，线程被唤醒继续执行任务。
	 * 在 Java 中使用 wait 方法是线程进入等待状态，wait 方法必须在当前调用的锁对象上调用。
	 * 线程进入等待状态后，将一直处于等待状态直到其他线程调用 notify 方法唤醒线程。
	 * 
	 * wait 和 notify 用于多线程协调运行：
	 * 1. 在 synchronized 内部可以调用 wait是线程进入等待状态。
	 * 2. 必须在已获得的所对象上调用 wait 方法。
	 * 3. 在 synchronized 内部可以调用 notify 和 notifyAll 方法唤醒其他等待线程。
	 * 4. 必须在已获得的锁对象上调用 notify 和 notifyAll 方法。
	 * 5. 以唤醒的线程还需要重新获取锁才能够运行。
	 * 
	 * Java 提供了 ReentrantLock 锁来替代synchronized。
	 * ReentrantLock 可以设置获取锁的超时时间，避免长时间无法获取锁。
	 * 必须先获取到锁，再进入try {...}代码块，最后使用finally保证释放锁。
	 * 使用 ReentrantLock 时可以配合 Condition 来实现 wait 和 notify 的功能。
	 * Condition 提供的 await、signal、signalAll 和synchronized 的 wait、notify、notifyAll 功能相同。
	 * Condition 必须从 lock 对象获取(locl.newCondition())。
	 */
	
	public static void main(String[] args) throws InterruptedException {
		waitTest();
		reententLockTest();
	}
	public static void waitTest() throws InterruptedException {
		var q = new TaskQueue();
		var ts = new ArrayList<Thread>();
		for (int i = 0; i < 5; i++) {
			var t = new Thread(()->{
				while (true) {
					try {
						System.out.println("execute task:" + q.getTask());
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}
			});
			t.start();
			ts.add(t);
		}
		
		var add = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
			}
		});
		add.start();
		add.join();
        Thread.sleep(100);
        for (var t : ts) {
            t.interrupt();
        }
 	}
	
	public static void reententLockTest() throws InterruptedException {
		ReentrantLockTest test = new ReentrantLockTest();
		
		var add1 = new Thread(()->{
			try {
				test.add(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		});
		
		var add2 = new Thread(()->{
			try {
				test.add(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}			
		});
		
		var add3 = new Thread(()->{
			try {
				test.add(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}			
		});
		
		add1.start();
		add2.start();
		add1.join();
		add2.join();
		add3.start();
	}
	
}

class TaskQueue {
	Queue<String> queue = new LinkedList<>();
	
	public synchronized void addTask(String s) {
		queue.add(s);
		notifyAll();
	}
	
	public synchronized String getTask() throws InterruptedException {
		while (queue.isEmpty()) {
			wait();
		}
		return queue.remove();
	}
}

class ReentrantLockTest {
	private final Lock lock = new ReentrantLock();
	public void add(int n) throws InterruptedException {
		if (lock.tryLock(1, TimeUnit.SECONDS)) {
			try {
				Thread.sleep(1000);
			} finally {
				lock.unlock();
			}
			System.out.println(Thread.currentThread() + "获取到 lock");
		} else {
			System.out.println(Thread.currentThread() + "超时未获取到 lock");
		}
	}
}
