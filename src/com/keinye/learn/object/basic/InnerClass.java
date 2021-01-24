package com.keinye.learn.object.basic;

/**
 * 内部类
 * @author keinYe
 *
 * 内部类被定义在一个类内部
 */
public class InnerClass {
	/**
	 * 内部类不能单独存在，必须依附于其所定义类的实例，内部类需要外部实例的 new 来进行实例化。
	 * 内部类不仅含有一个 this 变量指向自己，还有一个外部.this 来指向外部类的实例。
	 * 
	 * 匿名类是另外一种定义内部类的方法，常常在方法内部使用匿名类。
	 * 
	 * 静态内部类，使用 static 修饰的内部类。静态内部类是独立类无需依附外部类，但是可以访问外部类的静态私有字段和静态私有方法。
	 */
	private static String INFO = "InnerClass";
	private String name;
	
	
	public static void main(String[] args) {
		InnerClass out = new InnerClass("Outer Class");
		
		Inner inner = out.new Inner();
		inner.print();
		inner.syncPrint();
		
		InnerClass.StaticInner si = new InnerClass.StaticInner();
		si.print();
	}
	
	
	public InnerClass(String name) {
		this.name = name;
	}
	
	class Inner {
		void print() {
			System.out.println("Hello, " + InnerClass.this.name);
		}
		
		void syncPrint() {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					// TODO 自动生成的方法存根
					System.out.println("Anonymous class");
				}
			};
		}
	}
	
	static class StaticInner {
		void print() {
			System.out.println("StaticInner " + InnerClass.INFO);
		}
	}
}
