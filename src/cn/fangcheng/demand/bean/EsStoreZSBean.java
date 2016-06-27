package cn.fangcheng.demand.bean;

import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;
import cn.fangcheng.mybatis.po.PassportActivity;

public class EsStoreZSBean extends DemandZS{
	
	//其他的属性
	public Mall info=null;
	//用户属性
	public PassportActivity user=null;
	/**
	 * mall的得分
	 */
	public CustomMallScoresBean infoScore=null; 
	
	public void init(){
		if(this.getDemand_expiry_at()!=null)
		{
			this.setDemand_expiry_at(this.getDemand_expiry_at().replaceAll("/","-"));
		}
	}

	public PassportActivity getUser() {
		return user;
	}

	public void setUser(PassportActivity user) {
		this.user = user;
	}

	public Mall getInfo() {
		return info;
	}

	public void setInfo(Mall info) {
		this.info = info;
	}

	public CustomMallScoresBean getInfoScore() {
		return infoScore;
	}

	public void setInfoScore(CustomMallScoresBean infoScore) {
		this.infoScore = infoScore;
	}
	
}
