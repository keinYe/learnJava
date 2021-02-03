package com.keinye.learn.collection;

import java.time.DayOfWeek;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map
 * @author keinYe
 *
 */
public class MapClass {
	/**
	 * Map 是一种键值（key-value）映射的数据结构，作用就是能够通过 key 快速查找 value。
	 * 通过 put（k key，v value）将 key 和 value 做了映射并放入 map。
	 * 通过 get(k key) 获取相应的 key 存储的 value。如果 key 不存在将返回 null。
	 * Map 是一个接口，最常见的实现类是 HashMap。
	 * 如果要判断一个 key 是否存在，可以用 contains(k key) 方法。
	 * 
	 * 正确使用 Map必须保证：
	 * 1. 作为 key 的对象必须正确覆写 equals 方法，相等的两个 key 实例调用 equals 必须返回 true。
	 * 2. 作为 key 的对象必须正确覆写 hashCode 方法，且 hashCode 方法必须遵守：
	 *    如果两个对象相等，则 hashCode 必须相等。如果两个对象不等，则 hashCode 尽量不等。
	 * 编写 hashCode 可以借助于 Object.hashCode 来实现。
	 * 编写 equals 和 hashCode 的准则是：
	 * equals 用到的每一个字段，都必须放到 hashCode 中计算，equals 中没有用到的字段，决不可用在 hashCode 中计算。
	 * Map 内部默认数组大小为 16，每次扩容都是 16 的整数倍，由于扩容需要重新计算 key-value 映射，频繁扩容会影响计算性能，
	 * 如果确定需要使用很大的 Map，更好的方式是在创建 Map 时就指定容量。
	 * 
	 * 我们把不同的key具有相同的hashCode()的情况称之为哈希冲突。
	 * 
	 * 如果 map 的 key 是 enum 类推荐使用 EnumMap，既保证速度，又不浪费空间。
	 * 使用EnumMap的时候，根据面向抽象编程的原则，应持有Map接口。
	 * 
	 * Map 的实现原理决定了它内部的key 是无序，即遍历HashMap 的 key 时，其顺序是不可预测的。
	 * 
	 * SorteMap 是一个按 key 进行排序的 Map，SorteMap 是接口，它的实现类是 TreeMap。
	 * 使用 SorteMap 时，放入的 key 必须实现 Comparable 接口，String、Integer 等已经实现了 Comparable 可以直接使用。
	 * 如果key 没有实现 Comparable 则在创建TreeMap 的同时必须指定一个自定义排序算法。
	 * 使用 TreeMap 时无需实现 equals 和 hashCode，因为 TreeMap 依赖的是 Comparable。
	 */
	public static void main(String[] args) {
		var map = new MapClass();
		createMap();
		
        List<Student> list = List.of(
                map.new Student("Bob", 78),
                map.new Student("Alice", 85),
                map.new Student("Brush", 66),
                map.new Student("Newton", 99));
        var holder = map.new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");    
        
        enumMapClass();
        treeMapTest();
	}
	
	public static void createMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("1", 10);
		map.put("2", 20);
		map.put("3", 30);
		
		for (String key : map.keySet()) {
			System.out.println(key);
		}
		
		for (Map.Entry<String, Integer> entry: map.entrySet()) {
			System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
		}
	}
	
	public static void treeMapTest() {
		Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.score == o2.score) {
					return 0;
				}
				return o1.score > o2.score ? 1 : -1;
			}
		});
		MapClass mapClass = new MapClass();
		map.put(mapClass.new Student("Jack", 77), 1);
		map.put(mapClass.new Student("Tom", 65), 2);
		map.put(mapClass.new Student("Lily", 89), 3);
		System.out.println(map.get(mapClass.new Student("Tom", 65)));
		System.out.println(map.get(mapClass.new Student("Lily", 65)));
		/**
		 * TreeMap 仅检测 score 的值，因此以上两行的返回值相同。
		 */
		
	}
	
	public static void enumMapClass() {
		Map<DayOfWeek, String> map = new EnumMap<DayOfWeek, String>(DayOfWeek.class);
		map.put(DayOfWeek.MONDAY, "星期一");
		map.put(DayOfWeek.TUESDAY, "星期二");
		map.put(DayOfWeek.WEDNESDAY, "星期三");
		map.put(DayOfWeek.THURSDAY, "星期四");
		map.put(DayOfWeek.FRIDAY, "星期五");
		map.put(DayOfWeek.SATURDAY, "星期六");
		map.put(DayOfWeek.SUNDAY, "星球日");
		System.out.println(map);
		System.out.println(map.get(DayOfWeek.SUNDAY));
	}
	
	class Student {
		String name;
		int score;
		
		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}
	
	class Students {
		List<Student> list;
		Map<String, Integer> cache;
		
		public Students(List<Student> list) {
			// TODO 自动生成的构造函数存根
			this.list = list;
			this.cache = new HashMap<>();
		}
		
		public int getScore(String name) {
			Integer score = this.cache.get(name);
			if (score == null) {
				score = findInList(name);
				if (score != null) {
					this.cache.put(name, score);
				}
			}
			return score == null ? -1 : score.intValue();
		}
		
		public Integer findInList(String name) {
			for (var ss : list) {
				if (ss.name.equals(name)) {
					return ss.score;
				}
			}
			return null;
		}
	}
}
