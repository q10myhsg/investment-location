package cn.fangcheng.service;

import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;

public interface DemandInterface {
	
	public DemandXZ getDemandXZbyId(String id);
	public DemandZS getDemandZSbyId(String id);
	public DemandXZ getDemandXZbyJson(String json);
	public DemandZS getDemandZSbyJson(String json);
	
}
