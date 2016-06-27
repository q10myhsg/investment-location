package cn.fangcheng.data.cache.redis;

import cn.fangcheng.data.cache.CacheProxy;
import cn.fangcheng.data.cache.JedisProxy;
import cn.fangcheng.data.cache.RedisCacheImpl;

public class CacheUtil {	
	private static CacheProxy proxy;
	static {
		proxy = new  JedisProxy();
		RedisCacheImpl rci = new RedisCacheImpl();
		proxy.setCache(rci);
	}
	public static void save(String key,Object o){
		proxy.saveItem(key,o);
	}
	public static void save(String key,Object o,int time){
		proxy.saveItem(key,o,time);
	}	
	public static Object  getItem(String key){
		return proxy.getItem(key);
	}	
	public static void close(){
		proxy.closeCache();
	}	
}
