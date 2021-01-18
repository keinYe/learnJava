package com.keinye.learn.quickly.basic;

/**
 * 字符和字符串
 * @author keinYe
 *
 */
public class CharAndString {

	public static void main(String[] args) {
		char A1 = 'A';
		int A2 = 'A';
		char c1 = '\u0041';
		// Java 中字符类型是基本类型
		System.out.println(A1); // A
		System.out.println(A2); // 65 0x41
		System.out.println(c1); // A
		
		String s = "中文 123";
		// Java 中字符串是引用类型，用双引号来表示一个字符串
		System.out.println(s);
		System.out.println(s + A1);
		
		System.out.println(unicodeToString(72, 105, 65281));
	}
	
	public static String unicodeToString(int a, int b, int c) {
		char s1 = (char) a;
		char s2 = (char) b;
		char s3 = (char) c;
		return "" + s1 + s2 + s3;
	}
	
	/**
	 * 字符 char 是基本类型
	 * 字符串 String 是引用类型，可以直接使用+来连接字符串，当连接的类型不是字符串时将自动转换为字符串。
	 * 使用“”“..."""来表示一个多行字符串。
	 * 字符串是不可变类型。
	 * 字符串可以看做是C 语言中的指针，改变字符串的值可以看做是将字符串指向其他的地址，当前字符串的内容实际并没有改变。
	 * 
	 */
}
