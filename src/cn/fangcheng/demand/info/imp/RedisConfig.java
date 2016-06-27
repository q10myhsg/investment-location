package cn.fangcheng.demand.info.imp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

import cn.fangcheng.demand.servlet.InitServlet;

/**
 * redis配置文件
 * 
 * @author Administrator
 *
 */
public class RedisConfig {

	/**
	 * ip和port
	 */
	public String ipPort = "192.168.1.134:6379";
	/**
	 * 使用的队列
	 */
	public String key = "queue_demand";
	/**
	 * 最大活动数
	 */
	public int maxActive = 20;
	/**
	 * 最小活动数
	 */
	public int minIdle = 1;
	/**
	 * 超时时间
	 */
	public int timeout = 1000;
	/**
	 * 获取池超时时间
	 */
	public int poolTimeOut = 100000;

	public RedisConfig() {
		InputStream inputStream = null;
		String path = null;
		try {
			path = RedisConfig.class.getClassLoader().getResource("").toURI()
					.getPath();
		} catch (URISyntaxException e2) {
			e2.printStackTrace();
		}
		try {
			inputStream = new FileInputStream(path + "/redis.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(InitServlet.isLocal){
		this.ipPort = p.getProperty("ipPort");
		}else{
			this.ipPort=p.getProperty("ipPortOnline");
		}
		this.key = p.getProperty("key");
		this.maxActive = Integer.parseInt(p.getProperty("maxActive"));
		this.minIdle = Integer.parseInt(p.getProperty("minIdle"));
		this.timeout = Integer.parseInt(p.getProperty("timeout"));
		this.poolTimeOut = Integer.parseInt(p.getProperty("poolTimeOut"));
	}
}
