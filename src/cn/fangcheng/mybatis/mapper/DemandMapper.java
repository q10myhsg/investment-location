package cn.fangcheng.mybatis.mapper;

import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.DemandXZ;


public interface DemandMapper {
	
	public DemandXZ getDemandXZbyId(String id);
	public DemandZS getDemandZSbyId(String id);
	
}
