package com.keinye.learn.multithread;

/**
 * 守护线程
 * @author keinYe
 *
 */
public class Deamon {
	/**
	 * 守护线程是指为其他线程服务的线程。
	 * 在 Java 中当所有非守护线程关闭后，无论有没有守护线程，虚拟机都会自动退出。
	 * 
	 * 在启动线程前，通过 setDeamon 方法来设置当前线程是否为守护线程。
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new DeamonThread();
		System.out.println("Start");
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(1);
		System.out.println("Stop");
	}
}

class DeamonThread extends Thread {
	@Override
	public void run() {
		int n = 0;
		while (true) {
			System.out.println("Deamon Thread: " + n++);
		}
	}
}
