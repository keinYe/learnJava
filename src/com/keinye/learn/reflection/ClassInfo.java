package com.keinye.learn.reflection;

/**
 * Class 类
 * @author keinYe
 *
 */
public class ClassInfo {
	/**
	 * 反射是指程序在运行过程中通过一组方法获取一个未知对象的所有信息。
	 * 在 Java 中除了基本类型以外其他全部类型都是 class。
	 * 
	 * 在程序运行过程中，JVM 动态的加载每一个 class 并在内存中创建该 class 的 Class 实例，用来存储该 class 的所有信息。
	 * 因此当我获取到 Class 的实例后，就可以获取到该实例对应的 class 的所有信息。
	 * 
	 * 获取一个 class 的 Class 实例的三种方法：
	 * 1. Class clz = String.class;
	 * 2. String str = "Hello"; Class clz = str.getClass();
	 * 3. Class cls = Class.forName("java.lang.String");
	 * 由于 Class 实例在 JVM 中是唯一的，通过任何方法获取到的 Class 实例都是同一个实例。
	 * 
	 * JVM 在运行过程中并不是一次性将所有的类加载到内存中，而是使用到类才加载，我们称为动态加载。
	 * 利用 JVM 的动态加载特性，我们才能在运行过程中根据条件动态不同的类。
	 */
	
	public static void main(String[] args) {
		Class clz1 = String.class;
		String str = "Reflection";
		Class clz2 = str.getClass();
		Class clz3 = null;
		try {
			clz3 = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
		
		System.out.println(clz1 == clz2 && clz2 == clz3); // true
		
		Integer n = Integer.valueOf(123);
		System.out.println(n instanceof Integer); // true
		System.out.println(n instanceof Number); // true
		System.out.println(n.getClass() == Integer.class); // true
		//System.out.println(n.getClass() == Number.class); //Error
		
		printClassInfo(int.class);
		printClassInfo(Runnable.class);
		printClassInfo("".getClass());
		printClassInfo(String[].class);
	}
	
	static void printClassInfo(Class clz) {
		System.out.println("Class Name: " + clz.getName());
		System.out.println("Simple Name: " + clz.getSimpleName());
		System.out.println("Is interface: " + clz.isInterface());
		System.out.println("Is array: " + clz.isArray());
		System.out.println("Is Enum: " + clz.isEnum());
	}
}
