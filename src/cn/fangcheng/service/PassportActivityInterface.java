package cn.fangcheng.service;

import cn.fangcheng.mybatis.po.PassportActivity;

public interface PassportActivityInterface {
	/**
	 * 获取用户的活跃度
	 */
	PassportActivity selectActivity(PassportActivity pass);
	
	
}
