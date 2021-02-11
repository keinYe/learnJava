package com.keinye.learn.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Fiels and Paths
 * @author keinYe
 *
 */
public class FilesClass {
	/**
	 * Files 提供的读写方法，由于受内存的限制，智能读写小文件，比如配置文件等。
	 * 对于简单的小文件读写，使用 Files 可以大大的简化代码。
	 */
	
	public static void main(String[] args) {
		try {
			String strWrite = "Hello World!";
			Files.writeString(Paths.get("test.txt"), strWrite, StandardCharsets.UTF_8);
			
			String str = Files.readString(Paths.get("test.txt"));
			System.out.println(str);
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
