package com.keinye.learn.collection;

import java.util.Arrays;
import java.util.List;

/**
 * 有序列表 List
 * @author keinYe
 *
 */
public class ListClass {

	/**
	 * 集合是有若干个确定的元素构成的整体。引入集合便于处理一组相同的元素。
	 * java.util 包所提供的三种集合类：
	 * 1. List: 一种有序列表的集合。
	 * 2. Set: 一种保证没有重复元素的集合。
	 * 3. Map: 通过键值对查找的键值对集合。
	 * Java 集合的两个主要特点是接口和实现类相分离，支持泛型。
	 * Java 集合统一使用迭代器（Iterator）进行遍历。
	 * 
	 * List 是最基础的一种集合。List 像数组一样按照元素的放入顺序进行存放，每个元素都可以通过索引确定位置与读写。
	 * List 不想数组一旦定义大小就确定，List 可动态改变元素的数量。
	 * ArrayList 是最常用的一种 List。
	 * List 接口主要实现以下接口方法：
	 * 1. boolean add(E e): 在末尾添加一个元素。
	 * 2. boolean add(int index, E e): 在指定索引添加一个元素。
	 * 3. int remove(int index): 删除指定位置的元素。
	 * 4. int remove(Object e): 删除指定元素。
	 * 5. E get(int index): 获取指定位置的元素。
	 * 6. int size(): 获取列表的大小（长度）。
	 * 
	 * ArrayList 内部通过数组来实现，LinkList 内部通过链表来实现。通常情况下优先使用 ArrayList。
	 * List 允许添加重复的元素，即 List 内部的元素可以重复。
	 * 
	 * List.of 返回的是一个只读 List，对其调用 add、remove 会返回 UnsupportedOperationException。
	 * 
	 * 在 List 中查找元素时（contains、indexOf 等方法），List 实现类通过元素的 equals 方法比较两个元素是否相等，因此放入的元素必须正确覆写equals 方法。
	 * 编写 equals 方法时可以借助于 Object.equals 方法。如果不在 list 中查找元素就不洗实现 equals 方法。
	 */
	
	public static void main(String[] args) {
		createList();
		listToArray();
		arrayToList();
	}
	
	public static void createList() {
		// List.of 不允许传入 null，否则会引起 NullPointException。
		List<Integer> list = List.of(1, 2, 3);
		
		for (Integer n : list) {
			System.out.println(n);
		}
	}
	
	public static void listToArray() {
		List<Integer> list = List.of(1, 2, 3);
		
		Object[] array1 = list.toArray();
		for (Object n : array1) {
			System.out.println(n);
		}
		
		Integer[] array2 = list.toArray(new Integer[list.size()]);
		for (Integer n : array2) {
			System.out.println(n);
		}
		
		Integer[] array3 = list.toArray(Integer[]::new);
		for (Integer n : array2) {
			System.out.println(n);
		}
	}
	
	public static void arrayToList() {
		Integer[] array = {4, 5, 6};
		List<Integer> list = List.of(array);
		for (Integer n : list) {
			System.out.println(n);
		}
		
		List<Integer> list2 = Arrays.asList(array);
		for (Integer n : list2) {
			System.out.println(n);
		}
	}
}
