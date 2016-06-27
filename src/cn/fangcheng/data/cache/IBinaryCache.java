package cn.fangcheng.data.cache;

public interface IBinaryCache  extends ICache {	
	void save(String key,byte[] value,int t);
	void save(String key,byte[] value);
	byte[] getItem(String key);
}
