package cn.fangcheng.data.cache;

import cn.fangcheng.data.cache.redis.SerializeUtil;

public class JedisProxy extends  CacheProxy{
	IBinaryCache ic;	
	public void setCache(IBinaryCache ic){
		this.ic=ic;
		ic.init();
	}
	public void saveItem(String key,Object o){		
		ic.save(key,SerializeUtil.serialize(o));
	}

	public Object getItem(String key){
		byte[] b = ic.getItem(key);
		if(b==null) return null; 
		else return  SerializeUtil.unserialize(b);		
	}
	@Override
	public void saveItem(String key, Object o, int l) {
		// TODO Auto-generated method stub
		ic.save(key,SerializeUtil.serialize(o),l);
	}

	
	
	/**
	 * fill cache data there
	 * 
	 * */
	public void fillData(){
		
	}

}
