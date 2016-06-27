package cn.fangcheng.demand.bean;

import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.PassportActivity;

public class EsStoreXZBean extends DemandXZ{
	
	//其他的属性
	public Brand info=null;
	//用户属性
	public PassportActivity user=null;
	
	/**
	 * brand的得分
	 */
	public CustomBrandScoresBean infoScore=null; 
	
	public void init(){
		if(this.getDemand_expiry_at()!=null)
		{
			this.setDemand_expiry_at(this.getDemand_expiry_at().replaceAll("/","-"));
		}
	}
	
	public Brand getInfo() {
		return info;
	}

	public void setInfo(Brand info) {
		this.info = info;
	}

	public CustomBrandScoresBean getInfoScore() {
		return infoScore;
	}

	public void setInfoScore(CustomBrandScoresBean infoScore) {
		this.infoScore = infoScore;
	}

}
