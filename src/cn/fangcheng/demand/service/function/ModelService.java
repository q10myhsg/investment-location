package cn.fangcheng.demand.service.function;

import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;
import cn.fangcheng.mybatis.po.PassportActivity;

public interface ModelService {
	/**
	 * 
	 * @param esStoreBean 已经赋值基础数据的数据
	 * @param demand 请求的需求
	 * @param userFeature 用户feature
	 * @param feature 商业体feature
	 * @return
	 */
	EsStoreXZBean computeFeature(EsStoreXZBean esStoreBean,RequestDemand demand,PassportActivity userFeature,Brand brandFeature,DemandXZ feature) throws Exception;
	
	EsStoreZSBean computeFeature(EsStoreZSBean esStoreBean,RequestDemand demand,PassportActivity userFeature,Mall brandFeature,DemandZS feature) throws Exception;
}
