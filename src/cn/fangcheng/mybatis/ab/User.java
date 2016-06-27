package cn.fangcheng.mybatis.ab;

import java.io.Serializable;
import java.util.HashMap;

public abstract class User implements Serializable{
	
	protected int userId;
	protected HashMap<String,String> exHM;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public HashMap<String, String> getExHM() {
		return exHM;
	}
	public void setExHM(HashMap<String, String> exHM) {
		this.exHM = exHM;
	}
}
