package cn.fangcheng.demand.service.extra;

import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.mybatis.po.PassportActivity;

public interface UserExService {
	/**
	 * 获取用户feature
	 * @param userId
	 * @return
	 */
	public PassportActivity getUserFeature(int userId) throws Exception;
	/**
	 * 获取用户的某一些属性
	 * @param userId
	 * @param featureIndex
	 * @return
	 */
	public UserFeature getUserFeature(int userId,String featureQuery) throws Exception;
	/**
	 * 更新用户属性
	 * @param userFeature
	 */
	public boolean updateUserFeature(UserFeature userFeature) throws Exception;
	/**
	 * 删除用户属性
	 * @param userId
	 * @return
	 */
	public boolean deleteUserFeature(int userId) throws Exception;
}
