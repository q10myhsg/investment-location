package cn.fangcheng.demand.service.inner;

import cn.fangcheng.demand.bean.Feature;

/**
 * 商业体接口
 * @author Administrator
 *
 */
public interface BusinessInService {
	/**
	 * 通过主键获取feature
	 * @param id
	 * @return feature
	 */
	Object getFeatureByDocId(String docId) throws Exception;
	/**
	 * 通过用户id获取值
	 * @param userId
	 * @return
	 */
	Object getFeatureByBid(int bid) throws Exception;
//	/**
//	 * 通过主键id更新feature
//	 * @param id
//	 * @param feature
//	 * @return
//	 */
//	boolean updateFeatureByDocId(String docId,Feature feature);
//	/**
//	 * 更新用户的feature
//	 * @param userId
//	 * @param feature
//	 * @return
//	 */
//	boolean updateFeature(Feature feature);
//	/**
//	 * 通过主键id删除feature
//	 * @param id
//	 * @return
//	 */
//	boolean deleteFeatureByDocId(String docId);
//	/**
//	 * 通过用户id删除feature
//	 * @param userId
//	 * @return
//	 */
//	boolean deleteFeatureByBid(int bid);
}
