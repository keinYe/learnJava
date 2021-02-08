package com.keinye.learn.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 输出流
 * @author keinYe
 *
 */
public class OutputStreamClass {
	/**
	 * OutputStream 是 Java 标准库提供的基础输出流，它同样是一个抽象类，是所有输出流的超类。
	 * write(int b) 方法，虽然参数是一个 int 但是真实只会写入一个字节，即 int 的低 8 位数据。
	 * OutputStream 还提供一个 flush 方法，它的作用是将缓冲区的内容写入到真实的磁盘中，通常情况下我们无需调用该方法，
	 * 在调用 close 方法时会自动调用 flush。
	 */
	
	public static void main(String[] args) {
		writeFile();
		readFile();
	}
	
	public static void writeFile() {
		try (OutputStream output = new FileOutputStream("test.txt")) {
			output.write("Hello".getBytes("UTF-8"));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void readFile() {
		try (InputStream intput = new FileInputStream("test.txt")) {
			System.out.println(readString(intput));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static String readString(InputStream input) throws IOException {
		int n;
		StringBuilder str = new StringBuilder();
		while ((n = input.read()) != -1) {
			str.append((char)n);
		}
		return str.toString();
	}
}
