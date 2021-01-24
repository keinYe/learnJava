package com.keinye.learn.object.basic;


/**
 * classpath 和 jar
 * @author keinYe
 *
 */
public class PathJar {
	/**
	 * classpath 是 JVM 用到的一个环境变量（一组目录的集合），JVM 根据 classpath 来搜索 class。
	 * 推荐在启动 JVM 时设置 classpth 而不是直接设置系统级的环境变量
	 *    java -classpath path
	 *    java -cp path
	 * JVM 默认的 classpath 是当前目录。
	 * 
	 * 不要把任何Java核心库添加到classpath中！JVM根本不依赖classpath加载核心库！
	 * 
	 * jar 将散落在各个目录中的 .class 文件按照目录进行打包，便于分发及备份。
	 * jar 包实际上就是一个 zip 压缩包，可以直接使用 zip 压缩然后将后缀改为 jar 即可。
	 * jar 包通过 java -cp ./hello.jar abc.xyz.Hello 进行调用，
	 * 如果 jar 包通过 MANIFEST.MF 配置了 classpath 那么调用见更加简单 java -jar hello.jar。
	 * MANIFEST.MF 文件提供了 jar 包信息，如 Main-Class.
	 * 无需手动创建MANIFEST.MF文件，可以通过各种打包工具来自动完成，比如 maven。
	 */
}
