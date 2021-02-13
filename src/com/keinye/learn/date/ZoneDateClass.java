package com.keinye.learn.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 带时区的日期和时间
 * @author keinYe
 *
 */
public class ZoneDateClass {
	/**
	 * LocalDateTime 表示本地日期和时间，ZonedDateTime 表示带时区的日期和时间。
	 * ZoneId 是java.time 引入的新的时区类。
	 * 可以将 ZonedDateTime 看做是 LocalDateTime 加 ZoneId。
	 * 
	 * 使用 DateTimeFormatter 对时间和日期进行格式化，DateTimeFormatter 不仅是不可变对象，同时也是线程安全的。
	 * DateTimeFormatter 可以通过格式化字符串和 Locale 对日期和时间进行定制化输出。
	 */
	
	public static void main(String[] args) {
		printZoneDate();
		changeZoneId();
		printDateTimeFormatter();
	}
	
	public static void printZoneDate() {
		ZonedDateTime date = ZonedDateTime.now();
		System.out.println(date);
		System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));
		
		LocalDateTime ldt = LocalDateTime.now();
		ZonedDateTime t1 = ldt.atZone(ZoneId.systemDefault());
		System.out.println(t1);
		System.out.println(ldt.atZone(ZoneId.of("America/New_York")));
	}
	
	public static void changeZoneId() {
		ZonedDateTime t1 = ZonedDateTime.now();
		ZonedDateTime t2 = t1.withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println(t1);
		System.out.println(t2);
	}
	
	public static void printDateTimeFormatter() {
		ZonedDateTime t1 = ZonedDateTime.now();
		var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ZZZZ", Locale.CHINA);
		System.out.println(formatter.format(t1));
		
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd EE HH:mm:ss", Locale.US);
		System.out.println(formatter.format(t1));
	}
	
	
	
}
