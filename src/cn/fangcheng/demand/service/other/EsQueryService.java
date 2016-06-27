package cn.fangcheng.demand.service.other;

import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.Feature;
import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.bean.demand.DemandFeature;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;
/**
 * 需求匹配方法
 * @author Administrator
 *
 */
public interface EsQueryService {

	/**
	 * 将 需求用户 信息 及 商业体信息整合成对应的 feature信息
	 * @param demand
	 * @param userFeature
	 * @param feature
	 * @param from
	 * @param size
	 * @return
	 */
	public String getString(RequestDemand demand,DemandFeature demandFeature,UserFeature userFeature,Feature feature,int from,int size) throws Exception;
	
	/**
	 * 获取 匹配的string
	 * @param demand
	 * @param userFeature
	 * @param feature
	 * @param from
	 * @param size
	 * @return
	 */
	public String getMatchString(RequestDemand demand,DemandZS demandFeature,UserFeature userFeature,Mall feature,int from,int size) throws Exception;
	
	public String getMatchString(RequestDemand demand,DemandXZ demandFeature,UserFeature userFeature,Brand feature,int from,int size) throws Exception;
	
	
	/**
	 * 获取 匹配的string
	 * @param demand
	 * @param userFeature
	 * @param feature
	 * @param from
	 * @param size
	 * @return
	 */
	public String getMatchString(RequestDemand demand,EsStoreZSBean zs,int from,int size) throws Exception;
	
	public String getMatchString(RequestDemand demand,EsStoreXZBean xz,int from,int size) throws Exception;
	/**
	 * 获取 匹配的string
	 * @param demand
	 * @param userFeature
	 * @param feature
	 * @param from
	 * @param size
	 * @return
	 */
	public String getMatchHardString(RequestDemand demand,EsStoreZSBean zs,int from,int size) throws Exception;
	
	public String getMatchHardString(RequestDemand demand,EsStoreXZBean xz,int from,int size) throws Exception;
	/**
	 * 获取相似的string
	 * @param demand
	 * @param userFeature
	 * @param feature
	 * @param from
	 * @param size
	 * @return
	 */
	public String getSimString(RequestDemand demand,DemandZS demandFeature,UserFeature userFeature,Mall feature,int from,int size) throws Exception;
	
	public String getSimString(RequestDemand demand,DemandXZ demandFeature,UserFeature userFeature,Brand feature,int from,int size) throws Exception;
	
	
	/**
	 * 获取相似的string
	 * @param demand
	 * @param userFeature
	 * @param feature
	 * @param from
	 * @param size
	 * @return
	 */
	public String getSimString(RequestDemand demand,EsStoreZSBean zs,int from,int size) throws Exception;
	
	public String getSimString(RequestDemand demand,EsStoreXZBean xz,int from,int size) throws Exception;
	
	
	/**
	 * 获取相似的string
	 * @param demand
	 * @param userFeature
	 * @param feature
	 * @param from
	 * @param size
	 * @return
	 */
	public String getSimHardString(RequestDemand demand,EsStoreZSBean zs,int from,int size) throws Exception;
	
	public String getSimHardString(RequestDemand demand,EsStoreXZBean xz,int from,int size) throws Exception;
}


