package cn.fangcheng.demand.service.extra;

import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;

public interface DemandExService{
	
	/**
	 * 是否有效
	 * @param zs
	 * @return
	 * @throws Exception
	 */
	boolean isAvailably(DemandZS zs)throws Exception;
	/**
	 * 是否有效
	 * @param zs
	 * @return
	 * @throws Exception
	 */
	boolean isAvailably(DemandXZ zs)throws Exception;
	
	/**
	 * 获取es的原始数据
	 * @param type
	 * @param docId
	 * @return
	 */
	Object getDemand(int type,String docId) throws Exception;
	
	/**
	 * 获取转换后的原始数据
	 * @param type
	 * @param docId
	 * @return
	 */
	Object getDemandResponse(int type,String docId) throws Exception;
	
	/**
	 * 添加需求
	 * @param demand
	 * @param alias 如果是别名则入库到别名系统中
	 * @return
	 */
	boolean addDemand(RequestDemand demand,String alias) throws Exception;
	
	
	/**
	 * 添加需求 招商需求
	 * @param demand
	 * @return
	 */
	boolean addDemand(DemandZS demand) throws Exception;
	
	/**
	 * 添加需求 选址需求
	 * @param demand
	 * @return
	 */
	boolean addDemand(DemandXZ demand) throws Exception;
	/**
	 * 更新需求
	 * @param demand
	 * @return
	 */
	boolean updateDemand(RequestDemand demand) throws Exception;
	/**
	 * 删除需求
	 * @param demand
	 * @return
	 */
	boolean deleteDemand(RequestDemand demand) throws Exception;
	/**
	 * 获取处理的实际需求json
	 * @param demand
	 * @return
	 */
	String getRequestDemand(RequestDemand demand) throws Exception;
	/**
	 * 获取 匹配的需求
	 * @return
	 */
	Object getMatchDemand(RequestDemand demand) throws Exception;
	/**
	 * 获取相似的需求
	 * @return
	 */
	Object getSimDemand(RequestDemand demand) throws Exception;
	
	
	/**
	 * 获取 匹配的需求
	 * @return
	 */
	Object getMatchHardDemand(RequestDemand demand) throws Exception;
	/**
	 * 获取相似的需求
	 * @return
	 */
	Object getSimHardDemand(RequestDemand demand) throws Exception;
	/**
	 * 获取填补的需求
	 * @return
	 */
	Object getFillMatchDemand(RequestDemand demand) throws Exception;
	/**
	 * 获取相似的需求
	 * @return
	 */
	Object getFillSimDemand(RequestDemand demand) throws Exception;
	/**
	 * 填补方法
	 * @param deman1
	 * @param demand2
	 * @return
	 */
	Object fillDemand(Object[] demand1,Object[] demand2,int size) throws Exception;
}
