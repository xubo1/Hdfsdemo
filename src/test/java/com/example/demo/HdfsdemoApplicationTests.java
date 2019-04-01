package com.example.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HdfsdemoApplicationTests {

	// HDFS文件系统服务器的地址以及端口
	public static final String HDFS_PATH = "hdfs://172.31.36.52:8020";
	// HDFS文件系统的操作对象
	FileSystem fileSystem = null;
	// 配置对象
	Configuration configuration = null;

	/**
	 * 创建HDFS目录+
	 *
	 */
	@Test
	public void mkdir()throws Exception{
		// 需要传递一个Path对象
		fileSystem.mkdirs(new Path("/hdfsapi/xb"));
	}

	// 准备资源
	@Before
	public void setUp() throws Exception {

		configuration = new Configuration();
		// 第一参数是服务器的URI，第二个参数是配置对象，第三个参数是文件系统的用户名
		fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration, "root");
		System.out.println("HDFSAPP.setUp");
	}
	@Test
	public void create() throws Exception {
		// 创建文件
		FSDataOutputStream outputStream = fileSystem.create(new Path("/hdfsapi/test/a.txt"));
		// 写入一些内容到文件中
		outputStream.write("hello hadoop".getBytes());
		outputStream.flush();
		outputStream.close();
	}

	@Test
	public void cat() throws Exception {
		// 读取文件
		FSDataInputStream in = fileSystem.open(new Path("/hdfsapi/test/a.txt"));
		// 将文件内容输出到控制台上，第三个参数表示输出多少字节的内容
		IOUtils.copyBytes(in, System.out, 1024);
		in.close();
	}

	/**
	 * 重命名文件
	 */
	@Test
	public void rename() throws Exception {
		Path oldPath = new Path("/hdfsapi/test/a.txt");
		Path newPath = new Path("/hdfsapi/test/b.txt");
		// 第一个参数是原文件的名称，第二个则是新的名称
		fileSystem.rename(oldPath, newPath);
	}
	/**
	 * 删除文件
	 * @throws Exception
	 */
	@Test
	public void delete()throws Exception{
		// 第二个参数指定是否要递归删除，false=否，true=是
		fileSystem.delete(new Path("/hdfsapi"), true);
	}

	@Test
	public void copyFromLocalFile() throws Exception {
		Path localPath = new Path("D:\\test\\a.txt");
		Path hdfsPath = new Path("/hdfsapi/test/");
		// 第一个参数是本地文件的路径，第二个则是HDFS的路径
		fileSystem.copyFromLocalFile(localPath, hdfsPath);
	}

	@Test
	public void copyToLocalFile1() throws Exception {
		Path localPath = new Path("C:\\b.txt");
		Path hdfsPath = new Path("/hdfsapi/test/b.txt");
		fileSystem.copyToLocalFile(hdfsPath, localPath);
	}

	// 释放资源
	@After
	public void tearDown() throws Exception {
		configuration = null;
		fileSystem = null;

		System.out.println("HDFSAPP.tearDown");
	}

	@Test
	public void maptest(){
		Map<String,String> map = new HashMap<>();
		map.put("xubo","123");
		map.put("liyuan","123");
		System.out.println(map);
	}
}

