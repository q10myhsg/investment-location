package cn.fangcheng.mybatis.ab;

import java.io.Serializable;
import java.util.HashMap;

public abstract class BrandCommon implements Serializable{
	
	protected int brandId;
	protected HashMap<String,String> exHM;
	
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public HashMap<String, String> getExHM() {
		return exHM;
	}
	public void setExHM(HashMap<String, String> exHM) {
		this.exHM = exHM;
	}
}
