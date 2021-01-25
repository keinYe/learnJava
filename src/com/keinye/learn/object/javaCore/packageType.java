package com.keinye.learn.object.javaCore;

/**
 * 包装类型
 * @author keinYe
 *
 */
public class packageType {
	/**
	 * 引用类型可以赋值为 null，而基本类型不能被赋值为 null
	 * 为了能够将基本类型看做对象，我们可以定义基本类型的包装类（wrapper class)
	 * 由于包装类非常有用，java 核心库为所有的基本类型都定义了包装类。
	 * 
	 * 基本类型和包装类型之间可以相互转换，而无需强制类型转换（因为 Java 编译器帮我做了这件事），基本类型和包装类型之间的转换成为装箱/拆箱。
	 * 自动装箱和自动拆箱只发生在编译阶段，在运行阶段是严格区分类型的，这样在运行期间会有一定的效率损失。
	 * 并且自动拆箱在执行过程中也会发生 NullPointerException。
	 * 
	 * 所有的包装类型都是不变类，一旦创建该类型就不可变。
	 * 对包装类型比较不能使用 == ，而必须使用 equals。
	 * 
	 * 创建包装类的实例，可以通过 new 或 valueOf 两种方式，valueOf 是静态工厂方法，它尽可能的返回缓存的实例以节省内存。
	 * 
	 * 所有的整数和浮点数的基本类型都继承自 Number，可以非常方便的通过包装类型获取基本类型。
	 * 
	 * Java 本身并不提供基本类型的无符号类型，但是可以借助于包装类型来进行转换。
	 */
	
	public static void main(String[] args) {
		createInteger();
		unsignedType();
	}
	
	public static void createInteger() {
		Integer n1 = new Integer(1000);
		Integer n2 = Integer.valueOf(1000);
		
		System.out.println(n1 == n2); // false
		System.out.println(n1.equals(n2)); // true
	}
	
	public static void unsignedType() {
		byte x = -1;
		byte y = 127;
		
		System.out.println(Byte.toUnsignedInt(x)); // 255
		System.out.println(Byte.toUnsignedInt(y)); // 127
		
	}
}
