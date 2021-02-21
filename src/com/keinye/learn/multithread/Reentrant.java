package com.keinye.learn.multithread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 可冲入所
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
	 */
	
	public static void main(String[] args) throws InterruptedException {
		waitTest();
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
