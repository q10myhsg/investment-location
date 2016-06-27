package cn.fangcheng.demand.service.extra.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.service.extra.UserExService;
import cn.fangcheng.demand.service.inner.UserInService;
import cn.fangcheng.mybatis.po.PassportActivity;
@Service
public class UserEx implements UserExService{
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(UserEx.class);
	@Autowired
	UserInService uis;
	@Override
	public PassportActivity getUserFeature(int userId)  throws Exception{
		// TODO Auto-generated method stub
		return uis.getUserFeature(userId);
	}

	@Override
	public UserFeature getUserFeature(int userId, String featureQuery)  throws Exception{
		// TODO Auto-generated method stub
		return uis.getUserFeature(userId, featureQuery);
	}

	@Override
	public boolean updateUserFeature(UserFeature userFeature)  throws Exception{
		// TODO Auto-generated method stub
		return uis.updateUserFeature(userFeature);
	}

	@Override
	public boolean deleteUserFeature(int userId) throws Exception{
		// TODO Auto-generated method stub
		return uis.deleteUserFeature(userId);
	}
}
