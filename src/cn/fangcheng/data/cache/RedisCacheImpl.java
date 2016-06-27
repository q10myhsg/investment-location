package cn.fangcheng.data.cache;

import redis.clients.jedis.Jedis;

public class RedisCacheImpl implements  IBinaryCache{
	private Jedis jedis;	
	@Override
	public void init() {
		jedis=new Jedis("192.168.1.4");		
	}	
	@Override
	public void close() {
		jedis.disconnect();
//		jedis.close();
	}
	@Override
	public void save(String key, byte[] value, int t) {
		jedis.set(key.getBytes(), value);
		jedis.expire(key.getBytes(), t);
	}
	
	@Override
	public void save(String key, byte[] value) {
		save(key,value,60*60*2);
	}
	
	@Override
	public byte[] getItem(String key) {
		return  jedis.get(key.getBytes());
	}
}
