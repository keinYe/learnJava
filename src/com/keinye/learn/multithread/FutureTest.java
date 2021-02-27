package com.keinye.learn.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author keinYe
 *
 */
public class FutureTest {
	
	/**
	 * 对线程池提交一个 Callable 对象，可以获得一个 Future 对象，可以通过 Future 对象来获取 Callable 对象的运行结果。
	 * 
	 * Future 对象提供的方法如下：
	 * 1. get(): 获取结果（可能会等待）。
	 * 2. get(long timeout, TimeUnit unit): 获取结果，但只等待指定的时间。
	 * 3. cancel(boolean mayInterruptIfRunning)：取消当前任务；
	 * 4. isDone()：判断任务是否已完成。
	 * 
	 * CompletableFuture 可以指定异步处理流程：
	 * 1. thenAccept()处理正常结果
	 * 2. exceptional()处理异常结果
	 * 3. thenApplyAsync()用于串行化另一个CompletableFuture
	 * 4. anyOf()和allOf()用于并行化多个CompletableFuture
	 */
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		testFuture();
		testCompletableFuture();
	}
	
	public static void testFuture() throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<String> future = es.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "future test";
			}
		});
		es.shutdown();
		System.out.println(future.get());
	}
	
	public static void testCompletableFuture() throws InterruptedException {
		CompletableFuture<Double> cFuture = CompletableFuture.supplyAsync(FutureTest::fetchPrice);
		cFuture.thenAccept((result)->{
			System.out.println("price: " + result);
		});
		cFuture.exceptionally((e)->{
			e.printStackTrace();
			return null;
		});
		Thread.sleep(2000);
	}
    public static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
