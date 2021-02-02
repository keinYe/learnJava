package com.keinye.learn.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
