package com.keinye.learn.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 泛型
 * @author keinYe
 *
 */
public class Generic {
	/**
	 * 泛型就是一种模板，编写一次可以对所有的类型使用。
	 * 泛型的好处是不用对泛型就行强制转型，它通过编译器进行类型检查。
	 * 泛型的继承关系：可以将 ArrayList<Integer> 向上转型为 List<Integer> （T不能改变），而不能将 ArrayList<Integer> 转型为 ArrayList<Number>（T 发生改变）
	 * 
	 * 在使用泛型时，如果不定义泛型类型，那么泛型类型就是 Object，此时编译器会给出警告。
	 * 在使用泛型时，将 T 替换成需要的 class 类型。
	 * 可以省略编译器能够自动推断出的类型。
	 * 可以在接口类型中使用泛型，实现次接口的类必须正确实现该接口的类型。
	 */
	
	public static void main(String[] args) {
		useGeneric();
		
		Generic generic = new Generic();
		
		Person[] ps = new Person[] {
				generic.new Person("Lucy"),
				generic.new Person("Jack")
		};
		Arrays.sort(ps);
		System.out.println(Arrays.toString(ps));
	}
	
	public static void useGeneric() {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		
		// 通过 List<Number> 的类型，编译器能够自动推断 ArrayList 的泛型类型
		List<Number> num = new ArrayList<>();
		num.add(0);
		num.add(2.0);
		System.out.println(num.get(0));
		System.out.println(num.get(1));
	}
		
	class Person implements Comparable<Person> {
		String name;
		public Person(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			// TODO 自动生成的方法存根
			return this.name.compareTo(o.name);
		}
		
		@Override
		public String toString() {
			// TODO 自动生成的方法存根
			return this.name;
		}
		
	}
}
