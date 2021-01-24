package com.keinye.learn.object.javaCore;

import java.io.File;
import java.util.StringJoiner;

/**
 * 拼接字符串 StringBuilder StringJoiner
 * @author keinYe
 *
 */
public class StringJoin {
	/**
	 * 使用+来循环拼接字符串，每次都会创建一个新的字符串，丢弃旧的字符串，这样会带来大量的内存浪费。
	 * StringBuilder 是一个可变对象，可以预分配缓冲区，往StringBuilder中新增字符时，不会创建新的临时对象
	 * StringBuilder 可以进行链式操作，链式操作的本质是返回实例本身（this）。
	 * 
	 * StringJoiner 使用分隔符类拼接数组，还可以加上开头和结尾。
	 * 在不需要开头和结尾时，可以使用 String.join 静态方法更加方便。
	 */
	
	public static void main(String[] args) {
		stringBuilderTest();
		buildInsertSQL("Student",new String[] {"name", "age", "grade", "school"});
		buildSelectSQL("Student",new String[] {"name", "age", "grade", "school"});
	}
	
	public static void stringBuilderTest() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(",");
			sb.append(i);
		}
		System.out.println(sb);
		
		sb = new StringBuilder(100);
		sb.append("String ")
			.append("Test")
			.append("!");
		System.out.println(sb);
	}
	
	public static void buildInsertSQL(String table, String[] fields) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INFO ")
			.append(table)
			.append(" (")
			.append(String.join(",", fields))
			.append(") ");
		sb.append("VALUE (");
		for (int i = 0; i <= fields.length - 1; i++) {
			sb.append("?");
			if (i != fields.length - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		System.out.println(sb);
	}
	
	public static void buildSelectSQL(String table, String[] fields) {
		StringJoiner sj = new StringJoiner(",", "SELECT ", " FROM ");
		for (String field : fields) {
			sj.add(field);
		}
		String selectSql = sj.toString() + table;
		System.out.println(selectSql);
	}

}
