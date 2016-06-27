package cn.fangcheng.mybatis.mapper;

import cn.fangcheng.mybatis.po.PassportActivity;

public interface PassportActivityMapper {
	
	/**
	 * 获取用户的活跃度
	 */
	PassportActivity selectActivity(PassportActivity pass);
	
	
}
