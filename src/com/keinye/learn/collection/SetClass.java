package com.keinye.learn.collection;

/**
 * Set 不重复元素的集合
 * @author keinYe
 *
 */
public class SetClass {
	/**
	 * Set 用来存储不重复元素，可以看作是 Map 去掉了 value。
	 * 通常使用 Set 来去除重复元素。
	 * 和 Map 相同，放入 Set 的元素同样需要实现 equals 和 hashCode，否则会出错。
	 * Set 是接口，常用的实现类似 HashSet。
	 * Set 是无序的，SortedSet 是有序的。实现 SortedSet 接口的是 TreeSet 类。
	 * TreeSet 和 TreeMap 一样添加的元素要么实现 Comparable，要么在创建 set 时传入 Comparable 对象。
	 */
}
