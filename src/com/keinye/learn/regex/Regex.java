package com.keinye.learn.regex;

/**
 * 正则表达式 Regex
 * @author keinYe
 *
 */
public class Regex {
	/**
	 * 正则表达式是用字符串表示的一个匹配规则，使用正则表达式可以快速判断给定的字符串是否符合匹配规则，
	 * java.util.regex 内建了正则表达式引擎。
	 * 正则表达式从左到右按规则匹配。
	 * 
	 * 正则表达式的匹配规则如下：
	 * A          匹配指定字符
	 * \u548c     匹配指定 Unicode 字符
	 * .          匹配任意字符
	 * \d         匹配数字 0~9
	 * \w         匹配大小写字母、数字、下划线
	 * \s         匹配空格、Tab 键
	 * \D         匹配非\d
	 * \W         匹配非\w
	 * \S         匹配非\s
	 * A*         匹配任意个字符串
	 * A+         匹配至少 1 个字符
	 * A?         匹配 0 个或 1 个字符
	 * A{m}       匹配指定个数的字符
	 * A{m,n}     匹配指定个数范围的字符
	 * A{m,}      匹配至少 m 个字符
	 * A{,n}      匹配之多 n 个字符。
	 * ^          匹配开头
	 * $          匹配结尾
	 * [ABCD]     匹配[...]内任意字符
	 * [A-F0-9xyz]匹配指定范围字符
	 * [^A-F]     匹配指定范围外的任意字符
	 * AB|CD|EF   匹配 AB 或 CD 或 EF
	 */
	
	public static void main(String[] args) {
		System.out.println(isValidPhoneNumber("010-12345678"));
		System.out.println(isValidPhoneNumber("0755-7654321"));
		System.out.println(isValidPhoneNumber("010 12345678"));
		System.out.println(isValidPhoneNumber("0755-7654.321"));
		
		System.out.println(isLearn("learn java"));
		System.out.println(isLearn("learn Java"));
		System.out.println(isLearn("learn php"));
		System.out.println(isLearn("learn Go"));
	}
	
	public static boolean isValidPhoneNumber(String phoneNumber) {
		String regex = "0\\d{2,3}-[1-9]\\d{6,7}";
		return phoneNumber.matches(regex);
	}
	
	public static boolean isLearn(String str) {
		String regex = "learn\\s([jJ]ava|[pP]hp|[gG]o)";
		return str.matches(regex);
	}
}
