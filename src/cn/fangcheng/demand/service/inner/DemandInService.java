package cn.fangcheng.demand.service.inner;

import java.util.List;

import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.Feature;
import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.bean.demand.DemandFeature;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.demand.bean.demand.ResponseDemand;
import cn.fangcheng.demand.service.function.FunctionFactoryService;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;

public interface DemandInService {


	/**
	 * 选址
	 * 从基础数据源获取原始的featurebin计算结束
	 * @param type 对应 StaticBean中的 mallType brandType
	 * @return
	 */
	DemandXZ getDemandXZFeatureSourceByDocId(int type,String docId) throws Exception;
	
	
	/**
	 * 选址
	 * 通过主键获取需求的feature
	 * 
	 * @param id
	 * @return
	 */
	EsStoreXZBean getDemandXZFeatureByDocId(int type,String docId) throws Exception;
	
	
	/**
	 * 招商
	 * 从基础数据源获取原始的featurebin计算结束
	 * @param userId
	 * @return
	 */
	DemandZS getDemandZSFeatureSourceByDocId(int type,String docId) throws Exception;
	
	
	/**
	 * 招商
	 * 通过主键获取需求的feature
	 * 
	 * @param id
	 * @return
	 */
	EsStoreZSBean getDemandZSFeatureByDocId(int type,String docId) throws Exception;

	/**
	 * 通过用户id获取数量
	 * 
	 * @param userId
	 * @return
	 */
	Object getDemandZSFeatureByBid(int bid) throws Exception;
	
	/**
	 * 通过用户id获取数量
	 * 
	 * @param userId
	 * @return
	 */
	Object getDemandXZFeatureByBid(int bid) throws Exception;

//	/**
//	 * 通过条件获取参数
//	 * 
//	 * @param paramsKey
//	 * @param paramsValue
//	 * @return
//	 */
//	Object getDemandFeatureByParams(int bid,Object paramsKey, Object paramsValue);

	/**
	 * 通过用户demand数量
	 * 
	 * @param userId
	 * @return
	 */
	int getDemandCountByBid(int bid) throws Exception;

	/**
	 * 通过条件参数获取数量
	 * 
	 * @param paramsKey
	 * @param paramsValue
	 * @return
	 */
	int getDemandCountByParams(int type,Object paramsKey, Object paramsValue) throws Exception;

	/**
	 * 更新需求的feature
	 * 
	 * @param feature
	 * @return
	 */
	boolean updateDemandFeature(int type,String docId,EsStoreZSBean feature,String alias) throws Exception;
	
	/**
	 * 更新需求的feature
	 * 
	 * @param feature
	 * @return
	 */
	boolean updateDemandFeature(int type,String docId,EsStoreXZBean feature,String alias) throws Exception;

	/**
	 * 删除需求
	 * 
	 * @param paramsKey
	 * @param paramsValue
	 * @return
	 */
	boolean deleteDemandByParam(int type,Object paramsKey, Object paramsValue) throws Exception;

	/**
	 * 删除主键对应的feature
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteDemandByDocId(int type,String docId,String alias) throws Exception;

	/**
	 * 删除用户对应的feature
	 * 
	 * @param userId
	 * @return
	 */
	boolean deleteDemandByBid(int bid) throws Exception;

	/**
	 * 获取匹配的需求
	 * 
	 * @param demand
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,DemandZS demandFeature,UserFeature userFeature,Mall mallFeature) throws Exception;
	
	/**
	 * 获取匹配的需求
	 * 
	 * @param demand
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,EsStoreZSBean zs) throws Exception;

	/**
	 * 获取匹配的需求
	 * 
	 * @param demand
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,DemandXZ demandFeature,UserFeature userFeature,Brand brandFeature) throws Exception;
	
	
	/**
	 * 获取匹配的需求
	 * 
	 * @param demand
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,EsStoreXZBean xz) throws Exception;
	/**
	 * 虎丘需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,DemandZS demandFeature,UserFeature userFeature,Mall mallFeature, int from,
			int size) throws Exception;

	Object searchMatchDemand(RequestDemand demand,DemandXZ demandFeature,
			UserFeature userFeature, Brand feature, int from, int size) throws Exception;
	/**
	 * 虎丘需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,EsStoreZSBean zs, int from,
			int size) throws Exception;

	Object searchMatchDemand(RequestDemand demand,EsStoreXZBean xz, int from,
			int size) throws Exception;
	/**
	 * 获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param function
	 *            使用的文本类型
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,DemandZS demandFeature,UserFeature userFeature,Mall mallFeature, int from,
			int size, FunctionFactoryService function) throws Exception;
	
	/**
	 * 获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param function
	 *            使用的文本类型
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,EsStoreZSBean zs, int from,
			int size, FunctionFactoryService function) throws Exception;
	/**
	 * 获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param function
	 *            使用的文本类型
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,DemandXZ demandFeature,UserFeature userFeature,Brand brandFeature, int from,
			int size, FunctionFactoryService function) throws Exception;

	/**
	 * 获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param function
	 *            使用的文本类型
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,EsStoreXZBean xz, int from,
			int size, FunctionFactoryService function) throws Exception;
	/**
	 * 通过groovyfile获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param groovyFile
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,DemandZS demandFeature,UserFeature userFeature,Mall mallFeature, int from,
			int size, String groovyFile) throws Exception;
	
	/**
	 * 通过groovyfile获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param groovyFile
	 * @return
	 */
	Object searchMatchDemand(RequestDemand demand,EsStoreZSBean zs, int from,
			int size, String groovyFile) throws Exception;
	
	/**
	 * 通过groovyfile获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param groovyFile
	 * @return
	 */
	
	Object searchMatchDemand(RequestDemand demand,DemandXZ demandFeature,UserFeature userFeature,Brand brandFeature, int from,
			int size, String groovyFile) throws Exception;

	/**
	 * 通过groovyfile获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param groovyFile
	 * @return
	 */
	
	Object searchMatchDemand(RequestDemand demand,EsStoreXZBean xz, int from,
			int size, String groovyFile) throws Exception;
	/**
	 * 获取填补的需求匹配信息
	 * 
	 * @param type
	 *            0 为mall 1为brand xxxx
	 * @return
	 */
	Object getFillMatchDemand(int type) throws Exception;

	/**
	 * 获取匹配的需求
	 * 
	 * @param demand
	 * @return
	 */
	Object searchSimDemand(RequestDemand demand,DemandZS demandFeature,UserFeature userFeature,Mall feature) throws Exception;

	Object searchSimDemand(RequestDemand demand,DemandXZ demandFeature,UserFeature userFeature,Brand feature) throws Exception;
	
	/**
	 * 获取匹配的需求
	 * 
	 * @param demand
	 * @return
	 */
	Object searchSimDemand(RequestDemand demand,EsStoreZSBean zs) throws Exception;

	Object searchSimDemand(RequestDemand demand,EsStoreXZBean xz) throws Exception;

	/**
	 * 虎丘需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @return
	 */
	Object searchSimDemand(RequestDemand demand,DemandZS demandFeature,UserFeature userFeature,Mall feature, int from,
			int size) throws Exception;
	
	Object searchSimDemand(RequestDemand demand,DemandXZ demandFeature,UserFeature userFeature,Brand feature, int from,
			int size) throws Exception;
	/**
	 * 虎丘需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @return
	 */
	Object searchSimDemand(RequestDemand demand,EsStoreZSBean zs, int from,
			int size) throws Exception;
	
	Object searchSimDemand(RequestDemand demand,EsStoreXZBean xz, int from,
			int size) throws Exception;

	/**
	 * 获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param function
	 *            使用的文本类型
	 * @return
	 */
	Object searchSimDemand(RequestDemand demand,DemandZS demandFeature,UserFeature userFeature,Mall feature, int from,
			int size, FunctionFactoryService function) throws Exception;
	
	Object searchSimDemand(RequestDemand demand,DemandXZ demandFeature,UserFeature userFeature,Brand feature, int from,
			int size, FunctionFactoryService function) throws Exception;
	
	/**
	 * 获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param function
	 *            使用的文本类型
	 * @return
	 */
	Object searchSimDemand(RequestDemand demand,EsStoreZSBean zs, int from,
			int size, FunctionFactoryService function) throws Exception;
	
	Object searchSimDemand(RequestDemand demand,EsStoreXZBean xz, int from,
			int size, FunctionFactoryService function) throws Exception;

	/**
	 * 通过groovyfile获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param groovyFile
	 * @return
	 */
	Object searchSimDemand(RequestDemand demand,DemandZS demandFeature,UserFeature userFeature,Mall feature, int from,
			int size, String groovyFile) throws Exception;
	
	Object searchSimDemand(RequestDemand demand,DemandXZ demandFeature,UserFeature userFeature,Brand feature, int from,
			int size, String groovyFile) throws Exception;

	/**
	 * 通过groovyfile获取需求匹配
	 * 
	 * @param demand
	 * @param from
	 * @param size
	 * @param groovyFile
	 * @return
	 */
	Object searchSimDemand(RequestDemand demand,EsStoreZSBean zs, int from,
			int size, String groovyFile) throws Exception;
	
	Object searchSimDemand(RequestDemand demand,EsStoreXZBean xz, int from,
			int size, String groovyFile) throws Exception;
	
	/**
	 * 获取填补的需求相似信息
	 * 
	 * @param type
	 *            0 为mall 1为brand xxxx
	 * @return
	 */
	Object getFillSimDemand(int type) throws Exception;

	/**
	 * 将字符串转换为返回的demand实体
	 * 
	 * @param json
	 * @return
	 */
	Object changeStringToResponseDemand(String json) throws Exception;

	/**
	 * 将字符串转换为返回的demand实体
	 * 
	 * @param json
	 * @return
	 */
	Object changeSourceStringToResponseDemand(int type,String esJson) throws Exception;
	/**
	 * 混合方法
	 * 
	 * @param response1
	 * @param response2
	 * @return
	 */
	Object[] mixtrueMethod(List<ResponseDemand> response1,
			List<ResponseDemand> response2) throws Exception;

	/**
	 * 混合方法
	 * 
	 * @param response1
	 * @param response2
	 * @param func
	 *            对应聚合的方法类
	 * @return
	 */
	Object[] mixtrueMethod(List<ResponseDemand> response1,
			List<ResponseDemand> response2, FunctionFactoryService func) throws Exception;

	
	/**
	 * 获取匹配的需求
	 * 
	 * @param demand
	 * @return
	 */
	Object searchMatchHardDemand(RequestDemand demand,EsStoreZSBean zs) throws Exception;
	
	/**
	 * 获取相似的需求
	 * 
	 * @param demand
	 * @return
	 */
	Object searchSimHardDemand(RequestDemand demand,EsStoreZSBean zs) throws Exception;
	
	/**
	 * 获取匹配的需求
	 * 
	 * @param demand
	 * @return
	 */
	Object searchMatchHardDemand(RequestDemand demand,EsStoreXZBean xz) throws Exception;
	
	/**
	 * 获取相似的需求
	 * 
	 * @param demand
	 * @return
	 */
	Object searchSimHardDemand(RequestDemand demand,EsStoreXZBean xz) throws Exception;
}
