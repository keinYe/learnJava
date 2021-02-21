package com.keinye.learn.collection;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 队列 Queue
 * @author keinYe
 *
 */
public class QueueClass {
	/**
	 * Queue 实际是一个先进先出（FIFO) 的有序表，它和 List 的区别是，List 可以在任意位置插入和删除元素。
	 * 而 Queue 只能在队尾添加元素，只能带队首取出元素。
	 * 
	 * Queue 接口定义了一下方法：
	 * 1. int size(): 获取队列长度。
	 * 2. boolean add(E)/boolean offer(E): 添加元素到队尾。
	 * 3. E remove()/E poll(): 获取队首元素并从队首删除。
	 * 4. E element()/E peek(): 获取队首元素但不从队列中删除。
	 * 
	 * 避免将 null 添加至 Queue 中。
	 * LinkedList 即实现了 List 接口，又实现了 Queue 接口。可以依据实际的使用需求或去响应的接口引用。
	 * 
	 * PriorityQueue 按一定优先级获取队列元素。
	 * PriorityQUeue 它的出队顺序与元素的优先级有关，对 PriorityQueue 调用remove 或 poll 获取总是优先级最高的元素。
	 * 在使用 PriorityQueue 时需要给元素设定优先级。
	 * PriorityQueue默认按元素比较的顺序排序（必须实现Comparable接口），也可以通过Comparator自定义排序算法（元素就不必实现Comparable接口）
	 * 
	 * Deque 是双端队列，它允许两头进两头出。即可从队尾添加元素也可以从队首添加元素，既可以从队首获取也可以从队尾获取。
	 * Deque 实际上是对 Queue 接口的扩展，同样可以使用 Queue 的方法，但尽量不要使用 Queue 的方法。
	 * Deque 的方法如下：
	 * 1. 添加元素到队尾 addLast(E e)/offerLast(E e)
	 * 2. 添加元素到队首 addFirst(E e)/offerFirst(E e)
	 * 3. 获取队首元素并删除 E removeFirst()/E pollFirst()
	 * 4. 获取队尾元素并删除 E removeLast()/E pllLast()
	 * 5. 获取队首元素但不删除 E getFirst()/E peekFirst()
	 * 6. 获取队尾元素但不删除 E getLast()/E peekLast()
	 * 
	 * 栈（Stack）是一种后进先出（LIFO）的数据结构，操作栈的元素的方法有：
	 * 在Java中，我们用Deque可以实现Stack的功能，注意只调用push()/pop()/peek()方法，避免调用Deque的其他方法
	 * 不要使用遗留类Stack。
	 */
	
	static Queue<String> queue;
	public static void main(String[] args) {
		queue = new LinkedList<String>();
		addQueue();
		removeQueue();
		testPriorityQueue();
	}
	
	public static void addQueue() {
		if (queue == null) return;
		try {
			queue.add("Apple");
			System.out.println("add 添加成功");
		} catch (IllegalStateException e) {
			// TODO: handle exception
			System.out.println("add 添加失败");
		}
		
		if (queue.offer("Apple")) {
			System.out.println("offer 添加成功");
		} else {
			System.out.println("offer 添加失败");
		}
	}
	
	public static void removeQueue() {
		System.out.println(queue.size());
		try {
			System.out.println(queue.remove());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("remove 获取失败");
		}
		
		if (queue.poll() != null) {
			System.out.println("poll 获取成功");
		} else {
			System.out.println("poll 获取失败");
		}
	}
	
	public static void testPriorityQueue() {
		queue = new PriorityQueue<String>();
		
		queue.add("Banana");
		queue.add("Apple");
		System.out.println(queue.poll());//Apple
		System.out.println(queue.poll());//Banana
		System.out.println(queue.poll());//null
	}
}
