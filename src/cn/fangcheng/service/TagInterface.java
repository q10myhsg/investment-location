package cn.fangcheng.service;

import java.util.List;

import cn.fangcheng.mybatis.po.Taginfo;

public interface TagInterface {
	
	public Taginfo selectByPrimaryKey(int tagId);
	public List<Taginfo> selectByGroupId(int groupId);
	
}
