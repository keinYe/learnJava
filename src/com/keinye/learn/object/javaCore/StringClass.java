package com.keinye.learn.object.javaCore;

import java.util.Arrays;

/**
 * String
 * @author keinYe
 *
 */
public class StringClass {
	/**
	 * String 是引用类型，它本身也是 class，由于 String 使用太过频繁，Java 对其做了特殊处理，允许使用"..."的方式进行定义。
	 * Java 字符串是不可变是其重要特点，对字符串变量重新赋值实际上是将其指向另外一个字符串，而不是改变了字符串本身。
	 * 
	 * 比较两个字符串相等比较的是内容是否相同而不是是否同一个对象，因此使用 equals 而不是 ==。
	 * equalsIgnoreCase 忽略大小写比较两个字符串是否相等。
	 * contains 判断字符串是否包含子串。
	 * indexOf、lastIndexOf、startsWith、endsWith、substring
	 * 
	 * valueOf 可以将任意基本类型或引用类型转换为字符串。
	 * 将字符串转换为其他类型时需要注意类型以及可能产生的异常。
	 * 
	 * 可以通过 toCharArray 和 new String(char[]) 的方法在字符串和char[] 之间转换。
	 * 
	 * Java使用Unicode编码表示String和char；转换编码就是将String和byte[]转换，需要指定编码；转换为byte[]时，始终优先考虑UTF-8编码
	 */
	
	public static void main(String[] args) {
		String str = "Hello, World!";
		
		hello();
		stringEquals();
		stringReplace();
		stringDel();
		stringSplit();
		stringJoin();
	}
	
	public static void hello() {
		String hello = "hello!";
		// 打印字符串和地址
		System.out.println(hello);
		System.out.println(System.identityHashCode(hello));
		
		hello = hello.toUpperCase();
		// 打印字符串和地址
		System.out.println(hello);
		System.out.println(System.identityHashCode(hello));
		
		// hello 的地址发生改变，hello 已经不是原来的 hello 了。
	}
	
	public static void stringEquals() {
		String h1 = "hello";
		String h2 = "HELLO".toLowerCase();
		
		System.out.println(h1);
		System.out.println(h2);
		
		System.out.println(h1 == h2); // false
		System.out.println(h1.equals(h2)); // true
	}
	
	public static void stringReplace() {
		String s = "hello";
		
		s = s.replace("ll", "~~");
		System.out.println(s);
		s = "A,,B;C ,D";
		s = s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
		System.out.println(s);
	}
	
	public static void stringDel() {
		System.out.println("  \tHello\r\n ".trim()); // 移除字符串首尾空白字符
		System.out.println("\u3000Hello\u3000".strip()); // 移除字符串首尾空白字符，包括中文空白字符
		System.out.println(" Hello ".stripLeading()); // 移除字符串首空白字符
		System.out.println(" Hello ".stripTrailing());// 移除字符串尾空白字符
		
		System.out.println("".isEmpty()); // 判断字符串是否为空
		System.out.println(" ".isEmpty());
		System.out.println(" ".isBlank());// 判断字符串是否仅包含空白字符
		System.out.println(" hello".isBlank());
	}
	
	public static void stringSplit() {
		String s = "A,B,C,D";
		String[] ss = s.split("\\,");
		System.out.println(Arrays.toString(ss));
	}
	
	public static void stringJoin() {
		String[] s = {"A", "B", "c"};
		System.out.println(String.join("--", s));
	}
	
	public static void stringFormated() {
        String s = "Hi %s, your score is %d!";
        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
        /**
         * %s: 显示字符串
         * %d: 显示整数
         * %x: 十六进制显示
         * %f: 显示浮点数
         */
	}
}
