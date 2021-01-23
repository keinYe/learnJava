package com.keinye.learn.object.basic;

/**
 * 静态字段和方法
 * @author keinYe
 *
 */
public class StaticFieldMethod {
	/**
	 * 在 class 中定义的字段，称为实例字段，每个实例都可以有不同的值互不干扰。
	 * 使用 static 修饰的字段，称为静态字段，所有的实例共享该字段，任意实例修改该字段其他实例都将被改变。
	 * 推荐使用类名来访问静态字段而不是使用实例来访问静态字段。
	 * 
	 * 用 static 修饰的方法就是静态方法，调用静态方法无需通过实例，通过类名即可直接调用。
	 * 静态方法不属于实例，内部无法方位 this，也无法访问实例字段和实例方法，静态方法常用于工具类。
	 * 
	 * 接口不能有实例字段，但是可以有静态字段（必须使用 final 修饰），接口中的字段可以省略public static final，编译器会自动加上以上修饰符。
	 */
	/**
	 * main
	 * @param args
	 */
	
	public static void main(String[] args) {
		StaticFM p1Fm = new StaticFM("A1");
		System.out.println(StaticFM.getCount());
		StaticFM p2Fm = new StaticFM("A2");
		System.out.println(StaticFM.getCount());
		
		p1Fm.number = 10;
		System.out.println(p2Fm.number);
		
		p2Fm.number = 20;
		System.out.println(p1Fm.number);
		System.out.println(StaticFM.number);
		StaticFM.setNumber(211);
		System.out.println(StaticFM.number);
	}
}

class StaticFM {
	public String name;
	public static int number;
	private static int count;
	
	public StaticFM(String name) {
		this.name = name;
		count++;
	}
	
	public static void setNumber(int value) {
		number = value;
	}
	
	public static int getCount() {
		return count;
	}
}
