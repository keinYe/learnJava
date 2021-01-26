package com.keinye.learn.exception;


/**
 * Java 异常
 * @author keinYe
 *
 */
public class JavaException {
	/**
	 * 异常是程序运行过程中出现的一组不可预测的事件，这些事件是随机出现的，且不可避免。
	 * Java 的异常时 class，均继承自 Throwable。
	 * 
	 * Java 中的异常包括 error 和 exception 两类。
	 *     error：通常是一种严重的错误，程序通常无法处理。
	 *     exception：是指运行时的错误，它们可以被捕获处理。
	 * Java 规定：
	 *     必须捕获的异常，包括 Exception 及其子类，但不包括 RuntimeException 及其子类。
	 *     无需处理的异常，Error 及其子类，以及 RuntimeException 及其子类。
	 *     
	 * 捕获异常通常使用 try ... catch ，将可能产生异常的代码放在 try {} 语句块中，然后使用 catch 捕获 exception 及其子类。
	 * 
	 * 
	 */
}
