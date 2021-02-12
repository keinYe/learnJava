package com.keinye.learn.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Java8 以后的时间表示法
 * @author keinYe
 *
 */
public class TimeClass {
	/**
	 * 从 Java8 开始，java.time 提供了新的时间和日期 API，主要包括：
	 * 本地日期和时间：LocalDateTime, LocalDate, LocalTime
	 * 带时区的日期和时间：ZoneDateTime
	 * 时刻：Instant
	 * 时区：ZoneId，ZoneOffset
	 * 时间间隔：Duration
	 * 
	 * 
	 */
	public static void main(String[] args) {
		printDateAndTime();
		setDateAndTime();
		formatDate();
	}
	
	public static void printDateAndTime() {
		LocalDate d = LocalDate.now();
		LocalTime t = LocalTime.now();
		LocalDateTime dt = LocalDateTime.now();
		
		System.out.println(d);
		System.out.println(t);
		System.out.println(dt);
	}
	
	public static void setDateAndTime() {
		LocalDateTime dt = LocalDateTime.parse("2021-02-12T21:39:30");
		System.out.println(dt.toLocalDate());
		System.out.println(dt.toLocalTime());
		
		dt = LocalDateTime.of(2021, 2, 12, 21, 40, 42);
		System.out.println(dt.toLocalDate());
		System.out.println(dt.toLocalTime());		
	}
	
	public static void formatDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println(dtf.format(LocalDateTime.now()));
		
		LocalDateTime time = LocalDateTime.parse("2021/02/12 21:43:44", dtf);
		System.out.println(time);
	}
}
