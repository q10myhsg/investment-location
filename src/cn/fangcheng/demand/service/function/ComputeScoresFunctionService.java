package cn.fangcheng.demand.service.function;

import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.Feature;
import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;
import cn.fangcheng.mybatis.po.PassportActivity;

public interface ComputeScoresFunctionService {
	/**
	 * 将原始的feature的得分计算成es中需要的新得分
	 * @return
	 */
	EsStoreZSBean computeFeature(Feature feature) throws Exception;
	
	/**
	 * 计算招商
	 * @param demand
	 * @param userFeature
	 * @param mallFeature
	 * @param feature
	 * @return
	 */
	EsStoreZSBean computeFeature(RequestDemand demand,PassportActivity userFeature,Mall mallFeature,DemandZS feature) throws Exception;
	/**
	 * 计算选址
	 * @param demand
	 * @param userFeature
	 * @param brandFeature
	 * @param feature
	 * @return
	 */
	EsStoreXZBean computeFeature(RequestDemand demand,PassportActivity userFeature,Brand brandFeature,DemandXZ feature) throws Exception;
//	/**
//	 * 更新数据
//	 * @param objectId
//	 * @param feature
//	 * @return
//	 */
//	boolean updateFeature(int objectId,Feature feature);
	/**
	 * 将相关内容copy到 bean中
	 * @param demand
	 * @param userFeature
	 * @param val
	 * @param val2
	 * @return
	 */
	 EsStoreZSBean copy(RequestDemand demand, PassportActivity userFeature,Mall brandFeature,DemandZS val2) throws Exception;
	 EsStoreXZBean copy(RequestDemand demand, PassportActivity userFeature,Brand mallFeature,DemandXZ val2) throws Exception;
	
}
