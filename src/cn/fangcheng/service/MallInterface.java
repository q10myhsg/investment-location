package cn.fangcheng.service;

import cn.fangcheng.mybatis.po.Mall;

public interface MallInterface {
	
	public Mall selectByPrimaryKey(int mallId);
	
}
