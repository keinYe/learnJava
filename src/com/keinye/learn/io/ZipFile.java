package com.keinye.learn.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 操作 Zip
 * @author keinYe
 *
 */
public class ZipFile {
	/**
	 * Java 提供的 ZipInputStream 是一种 FilterInputStream，它可以直接读取 Zip 包的内容。
	 * JarInputStream是从ZipInputStream派生，它增加的主要功能是直接读取jar文件里面的MANIFEST.MF文件。
	 * 因为本质上jar包就是zip包，只是额外附加了一些固定的描述文件。
	 * 
	 * ZipInputStream 可以读取 ZIP 格式的流，ZipOutputStream 可以将多个文件写入 ZIP 包，配合 FileInputStream 和
	 * FileOutputStream 就可以读写zip 文件。
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (ZipInputStream zip = new ZipInputStream(new FileInputStream("test.zip"))){
			ZipEntry entry;
			while ((entry = zip.getNextEntry()) != null) {
				System.out.println(entry.getName());
				if (!entry.isDirectory()) {
					int n;
					while ((n = zip.read()) != -1) {
						System.out.println((char)n);
					}
				}
			}
		}
		
		try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("test.zip"))) {
			File[] files = new File[] {
				new File("test1.txt"),
				new File("file2.txt"),
				new File("test3.txt")
			};
			
			for (File file : files) {
				zip.putNextEntry(new ZipEntry(file.getName()));
				zip.write("hello zip file".getBytes());
				zip.closeEntry();
			}
		}
	}
}
