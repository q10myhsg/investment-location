package cn.fangcheng.service;

import java.util.List;

import cn.fangcheng.mybatis.po.Category;

public interface CategoryInterface {
	
	public List<Category> selectByBrandid(int brandid);
	public List<Category> selectByCategoryid(int brandid);
	public List<Category> selectCatOne(int brandid);
}
