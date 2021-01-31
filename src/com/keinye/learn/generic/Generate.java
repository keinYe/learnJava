package com.keinye.learn.generic;


/**
 * 生成一个泛型
 * @author keinYe
 *
 */
public class Generate {
	/**
	 * 生成一个泛型时，需要定义泛型类型 T。
	 * 静态方法不能使用泛型类型 T，必须定义其他类型来实现静态泛型方法。
	 * 泛型可以定义多种类型，比如 Map<K, T>。
	 * 
	 * Java 的泛型实现方法是擦拭法，即虚拟机对泛型一无所知，所有的工作都是编译器来完成。
	 * Java 的泛型是有编译器在编译器实现的，编译器永远将泛型类型看做是 Object 类型，但是在需要转型的时候编译器会根据需要求的类型进行安全的强制转型。
	 * Java 泛型的局限：
	 * 1. T 不能是基本类型，因为 Object 类型不能持有基本类型。
	 * 2. 无法取得带泛型的 Class，对Pair<String>和Pair<Integer>类型获取Class时，获取到的是同一个Class，也就是Pair类的Class。
	 * 3. 无法判断带泛型的类型。并不存在Pair<String>.class，而是只有唯一的Pair.class。
	 * 4. 不能实例化 T 类型。要实例化T类型，我们必须借助额外的Class<T>参数：
	 * 泛型发放要防止重复定义的方法（覆写）。
	 * 
	 * 使用<? extends Number>通配符作为方法参数时表示：
	 * 1. 方法内部可以调用获取Number引用的方法。
	 * 2. 方内部无法调用传入 Number 引用的方法（null 除外）。
	 * 泛型使用 extends 表示可读，不可写。
	 * 使用<T extends Number>定义泛型时，泛型限定为 Number 及其子类。
	 * 
	 * 使用<? super Integer>通配符作为方法参数时表示：
	 * 1. 允许调用 set(? super Integer) 方法传入 Integer 的引用。
	 * 2. 不允许调用 get 方法获得 Integer 的引用。
	 * 唯一例外是可以获取Object的引用：Object o = p.getFirst()。
	 * 使用<? super Integer>通配符作为方法参数，表示方法内部只能写不能读。
	 * 
	 * <? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）
	 * <? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）
	 * 如果需要返回T，它是生产者（Producer），要使用extends通配符；如果需要写入T，它是消费者（Consumer），要使用super通配符
	 * 
	 * 无限定通配符<?>既没有 extends，也没有 super 因此：
	 * 1. 不允许调用 set 方法传入引用 null 除外。
	 * 2. 不允许调用 get 方法传出引用 Object 除外。
	 * 既不能读，也不能写，那只能做一些null判断
	 * <?>通配符有一个独特的特点，就是：Pair<?>是所有Pair<T>的超类
	 * 无限定通配符<?>很少使用，可以用<T>替换，同时它是所有<T>类型的超类
	 */
	
	public static void main(String[] args) {
		Pair<String> pair = new Pair("Xiao", "Hong");
		
		System.out.println(pair.getFirst());
		
		Pair<Integer> pair2 = new Pair(1, 20);
		System.out.println(pair2.getLast());
	}

}

class Pair<T> {
	private T first;
	private T last;
	
	public Pair(T first, T last) {
		this.first = first;
		this.last = last;
	}
	
	public T getFirst() {
		return first;
	}
	
	public T getLast() {
		return last;
	}
	
	public static <K> Pair<K> create(K first, K last) {
		return new Pair<K>(first, last);
	}
}