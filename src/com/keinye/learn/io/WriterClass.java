package com.keinye.learn.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Write 字符输出流
 * @author keinYe
 *
 */
public class WriterClass {
	/**
	 * Reader是带编码转换器的InputStream，它把byte转换为char，而Writer就是带编码转换器的OutputStream
	 * Writer是所有字符输出流的超类
	 * FileWriter就是向文件中写入字符流的Writer
	 * CharArrayWriter可以在内存中创建一个Writer，它的作用实际上是构造一个缓冲区，可以写入char，
	 * 最后得到写入的char[]数组，这和ByteArrayOutputStream非常类似.
	 * StringWriter也是一个基于内存的Writer，它和CharArrayWriter类似
	 * 除了CharArrayWriter和StringWriter外，普通的Writer实际上是基于OutputStream构造的，
	 * 它接收char，然后在内部自动转换成一个或多个byte，并写入OutputStream。
	 * 因此，OutputStreamWriter就是一个将任意的OutputStream转换为Writer的转换器
	 */
	
	public static void main(String[] args) {
		try (Writer writer = new FileWriter("test.txt")) {
		    writer.write('H'); // 写入单个字符
		    writer.write("Hello".toCharArray()); // 写入char[]
		    writer.write("Hello"); // 写入String			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
