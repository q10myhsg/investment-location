package cn.fangcheng.mybatis.ab;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Demand implements Serializable{
	
	protected String demandId;
	
	
	public String getDemandId() {
		return demandId;
	}
	public void setDemandId(String demandId) {
		this.demandId = demandId;
	}
}
