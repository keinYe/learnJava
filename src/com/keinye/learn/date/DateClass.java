package com.keinye.learn.date;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * Date and Calendar
 * @author keinYe
 *
 */
public class DateClass {
	/**
	 * 计算机通过 Locale 来针对当地用户习惯格式化日期、时间、数字、货币等。
	 * 时间在计算机上存储的是一个整数，成为 Epoch Time，各地时间依据这个整数进行计算展示。
	 * Epoch Time 是计算 1970 年 1 月 1 日零时（格林威治时间）到现在经过的秒数。
	 * Java使用long型来表示以毫秒为单位的时间戳，通过System.currentTimeMillis()获取当前时间戳
	 * 
	 * Calendar可以用于获取并设置年、月、日、时、分、秒，它和Date比，主要多了一个可以做简单的日期和时间运算的功能
	 * Calendar 通过字段来获取年月日，返回的年份无需转换, Calendar.getTime 可以将一个 Calendar 转换为 Date。
	 * Calendar只有一种方式获取，即Calendar.getInstance()，而且一获取到就是当前时间。
	 * 如果我们想给它设置成特定的一个日期和时间，就必须先清除所有字段
	 * 
	 * 使用 TimeZone 来表示时区。
	 * TimeZone.getAvailableIDs() 可以列出系统支持的所有时区。
	 * Calendar 可以进行时区转换，转换的步骤如下：
	 * 1. 清除所有字段
	 * 2. 设定指定时区
	 * 3. 设定日期和时间
	 * 4. 创建 SimpleDateFormat 并设定目标时区。
	 * 5. 格式化获取的 Date 对象。
	 * 
	 * Java有两套日期和时间的API：
	 * 旧的Date、Calendar和TimeZone；
	 * 新的LocalDateTime、ZonedDateTime、ZoneId
	 */
	public static void main(String[] args) {
		int n = 123400;
		System.out.println(n);
		System.out.println(Integer.toHexString(n));
		System.out.println(NumberFormat.getCurrencyInstance().format(n));
		
		printDate();
		formatDate();
		printCalendar();
		printTimeZone();
		changeCalendar();
		calcCalendar();
	}
	
	@SuppressWarnings("deprecation")
	public static void printDate() {
		Date date = new Date();
		System.out.println(date.getYear() + 1970);
		System.out.println(date.getMonth() + 1);
		System.out.println(date.getDay());
		System.out.println(date.toString());
		System.out.println(date.toGMTString());
		System.out.println(date.toLocaleString());
	}
	
	public static void formatDate() {
		Date date = new Date();
		var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
	}
	
	public static void printCalendar() {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH) + 1);
	}
	
	public static void printTimeZone() {
		System.out.println(TimeZone.getDefault().getID());
		System.out.println(TimeZone.getTimeZone("America/New_York").getID());
	}
	
	public static void changeCalendar() {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		c.set(2020, 1, 12, 21, 16, 22);
		var sdf = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
		sdf.setTimeZone(TimeZone.getDefault());
		System.out.println(sdf.format(c.getTime()));
	}
	
	public static void calcCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.HOUR_OF_DAY, 1);
		var sdf = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
		System.out.println(sdf.format(calendar.getTime()));		
	}
	
}
