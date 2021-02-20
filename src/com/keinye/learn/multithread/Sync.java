package com.keinye.learn.multithread;

/**
 * 线程同步
 * @author keinYe
 *
 */
public class Sync {
	/**
	 * 多个线程同时读写一个变量是，未来保持数据的一致性，需要保证原子操作即同一时刻只能有一个线程读写变量。
	 * 
	 * 在 Java 中可以通过 synchronized 对一个对象加锁/解锁来保证院子操作。
	 * synchronized 保证代码块同一时刻只有一个线程能执行。
	 * 使用 synchronized 无需关系异常，因为无论是否发生异常，都会在 synchroized 结束处正常解锁。
	 * 
	 * 原子操作必须保证不同线程中使用 synchronized 加锁的必须是同一个对象。
	 * 
	 * 对 JVM 定义的原子操作无需使用 synchronized 进行加锁，JVM 定义的原子操作有以下几种：
	 * 1. 基本类型（long和double除外）赋值，例如：int n = m；
	 * 2. 引用类型赋值，例如：List<String> list = anotherList。
	 * 
	 * 在使用 synchronized 时尽量不要让线程选择锁住的对象，进行将 synchronized 封装在方法内部。
	 * 使用 synchronized 修饰整个方法可以将整个方法变成同步代码块，synchronized 方法加锁对象是 this，对于静态方法是 class。
	 * 通过合理的设计和封装可以使一个类变成“线程安全”，一个类没有特殊说明，默认不是线程安全的。
	 * 
	 * Java 的 synchronized 是可重入锁，死锁产生的条件是多线程各自持有不同的锁，并互相试图获取对方已持有的锁，导致无限等待；避免死锁的方法是多线程获取锁的顺序要一致。
	 */
	
	public static void main(String[] args) throws InterruptedException {
		var add = new AddThread();
		var dec = new DecThread();
		add.start();
		dec.start();
		add.join();
		dec.join();
		System.out.println(Counter.count);
	}
}

class Counter {
	public static final Object lock = new Object();
	public static int count = 0;
}

class AddThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			synchronized (Counter.lock) {
				Counter.count++;
			}
		}
	}
}

class DecThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			synchronized (Counter.lock) {
				Counter.count--;
			}
		}
	}
}
