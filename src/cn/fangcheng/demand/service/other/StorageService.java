package cn.fangcheng.demand.service.other;

import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;
import cn.fangcheng.mybatis.po.PassportActivity;

public interface StorageService {
	
	/**
	 * 获取查询结果
	 * 
	 * @param typeCategory
	 *            对应 使用的 域类型
	 * @param type
	 * @return
	 */
	public String search(int typeCategory, String type,String alias) throws Exception;

	/**
	 * 
	 * @param type
	 *            type
	 * @param json
	 *            query json
	 * @return
	 */
	public String search(int typeCategory, String type, String json,String alias) throws Exception;

	/**
	 * 
	 * @param paramsKey
	 * @param paramsValue
	 * @return
	 */
	public String search(int typeCategory, Object paramsKey, Object paramsValue) throws Exception;

	/**
	 * 通过脚本调用
	 * 
	 * @param type
	 * @param json
	 * @param groovyFile
	 * @return
	 */
	public String search(int typeCategory, String type, String json,
			String groovyFile,String alias) throws Exception;

	/**
	 * 更新
	 * 
	 * @param type
	 * @param json
	 * @return
	 */
	public boolean update(int typeCategory, String type, String json,String alias) throws Exception;

	/**
	 * 删除
	 * 
	 * @param type
	 * @return
	 */
	public boolean delete(int typeCategory, String type,String alias) throws Exception;

	/**
	 * 删除
	 * 
	 * @param type
	 * @param json
	 * @return
	 */
	public boolean delete(int typeCategory, String type, String json,String alias) throws Exception;

	public boolean post(int typeCategory, String type, String json,String alias) throws Exception;

	/**
	 * 获取选址 demand源数据
	 * 
	 * @param id
	 * @return
	 */
	public DemandXZ getDemandXZFeatureSourceByDocId(String docId) throws Exception;

	/**
	 * 获取招商demand源数据
	 * 
	 * @param docId
	 * @return
	 */
	public DemandZS getDemandZSFeatureSourceByDocId(String docId) throws Exception;

	/**
	 * 获取用户的源数据
	 * 
	 * @param userId
	 * @return
	 */
	public PassportActivity getUserFeatureSourceByUserId(int userId) throws Exception;

	/**
	 * 获取用户的源数据
	 * 
	 * @param userId
	 * @return
	 */
	public String getUserFeatureSourceByUserId(int userId, String jsonRef) throws Exception;

	/**
	 * 更新用户属性得分
	 * 
	 * @param userId
	 * @param json
	 * @return
	 */
	public boolean updateUserFeatureSourceByUserId(int userId, String json) throws Exception;

	/**
	 * 删除用户源
	 * 
	 * @param userId
	 * @return
	 */
	public boolean deleteUserFeatureByUserId(int userId) throws Exception;

	/**
	 * 获取featruesource源
	 * 
	 * @param userId
	 * @return
	 */
	public Mall getMallFeatureSourceByBid(int bid) throws Exception;

	/**
	 * 获取featruesource源
	 * 
	 * @param userId
	 * @return
	 */
	public Brand getBrandFeatureSourceByBid(int bid) throws Exception;

	/**
	 * 获取featruesource源
	 * 
	 * @param userId
	 * @return
	 */
	public Mall getMallFeatureSourceByBid(int bid, String featureRef) throws Exception;

	/**
	 * 获取featruesource源
	 * 
	 * @param userId
	 * @return
	 */
	public Brand getBrandFeatureSourceByBid(int bid, String featureRef) throws Exception;

	/**
	 * 获取需求
	 * 
	 * @param type
	 * @return
	 */
	public String getFillMatchDemand(int typeCategory) throws Exception;

	/**
	 * 获取相似
	 * 
	 * @param type
	 * @return
	 */
	public String getFillSimDemand(int typeCategory) throws Exception;
}
