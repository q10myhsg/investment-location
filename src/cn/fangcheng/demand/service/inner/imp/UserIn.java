package cn.fangcheng.demand.service.inner.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.service.inner.UserInService;
import cn.fangcheng.demand.service.other.StorageService;
import cn.fangcheng.demand.tool.JsonUtil;
import cn.fangcheng.mybatis.po.PassportActivity;
@Service
public class UserIn implements UserInService{
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(UserIn.class);
	@Autowired
	StorageService ss;
	
	@Override
	public PassportActivity getUserFeature(int userId)  throws Exception{
		// TODO Auto-generated method stub
		PassportActivity userFeature=ss.getUserFeatureSourceByUserId(userId);
		if(userFeature==null){
			return null;
		}
		return userFeature;
	}

	@Override
	public UserFeature getUserFeature(int userId, String featureRef)  throws Exception{
		// TODO Auto-generated method stub
		String user=ss.getUserFeatureSourceByUserId(userId, featureRef);
		if(user==null){
			return null;
		}
		return (UserFeature)JsonUtil.getDtoFromJsonObjStr(user,UserFeature.class);
	}

	@Override
	public boolean updateUserFeature(UserFeature userFeature) throws Exception {
		// TODO Auto-generated method stub
		if(userFeature==null){
			return true;
		}
		return ss.updateUserFeatureSourceByUserId(userFeature.getUid(), JsonUtil.getJsonStr(userFeature));
	}

	@Override
	public boolean deleteUserFeature(int userId)  throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

}
