package cn.fangcheng.demand.bean.script;

import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;

public class ScriptUseBeanZS{
	DemandZS demandZS=null;
	UserFeature userFeature=null;
	Mall mall=null;
	int from=0;
	int size=10;
	public ScriptUseBeanZS(DemandZS demandZS,UserFeature userFeature,Mall mall,int from,int size){
		this.demandZS=demandZS;
		this.userFeature=userFeature;
		this.mall=mall;
		this.from=from;
		this.size=size;
	}

	public DemandZS getDemandZS() {
		return demandZS;
	}

	public void setDemandZS(DemandZS demandZS) {
		this.demandZS = demandZS;
	}

	public UserFeature getUserFeature() {
		return userFeature;
	}

	public void setUserFeature(UserFeature userFeature) {
		this.userFeature = userFeature;
	}

	public Mall getMall() {
		return mall;
	}

	public void setMall(Mall mall) {
		this.mall = mall;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}