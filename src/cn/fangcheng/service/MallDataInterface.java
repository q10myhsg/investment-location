package cn.fangcheng.service;

import cn.fangcheng.mybatis.po.MallData;

public interface MallDataInterface {
	
	public MallData selectByPrimaryKey(int mallId);
	
}
