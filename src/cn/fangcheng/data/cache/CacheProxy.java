package cn.fangcheng.data.cache;

public abstract class CacheProxy {
	IBinaryCache ic;	
	public void setCache(IBinaryCache ic){
		this.ic=ic;
		ic.init();
	}
	public abstract void saveItem(String key,Object o);	
	public abstract void saveItem(String key,Object o,int l);	
	public abstract Object getItem(String key);
	public void closeCache(){
		ic.close();
	}
	
}
