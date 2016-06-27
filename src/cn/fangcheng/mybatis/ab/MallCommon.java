package cn.fangcheng.mybatis.ab;

import java.io.Serializable;
import java.util.HashMap;

public abstract class MallCommon implements Serializable{
	
	protected int mallId;
	protected HashMap<String,String> exHM;
	
	public int getMallId() {
		return mallId;
	}
	public void setMallId(int mallId) {
		this.mallId = mallId;
	}
	public HashMap<String, String> getExHM() {
		return exHM;
	}
	public void setExHM(HashMap<String, String> exHM) {
		this.exHM = exHM;
	}
}
