package com.keinye.learn.exception;

import java.util.logging.Logger;


/**
 * 日志
 * @author keinYe
 *
 */
public class JDKLogging {
	/**
	 * 日志用来取代 System.out.print 进行调试信息的打印。
	 * 使用日期可以设定输出样式，设定输出级别，重定向至文件，仅输出制定包的日志信息等等。
	 * 
	 * java.util.logging 是Java 标准库内置的日志工具。
	 * 
	 * logging 默认的日期级别是 INFO，使用标准库内置的日志，只能通过启动参数传入日志级别，在 main 启动后即无法修改。
	 * 
	 * 以下代码 logging fine 不会打印出来。
	 */
	
	public static void main(String[] args) {
		Logger logger = Logger.getGlobal();
		logger.info("logging info");
		logger.warning("logging warning");
		logger.fine("logging fine");
		logger.severe("logging servere");
	}
}
