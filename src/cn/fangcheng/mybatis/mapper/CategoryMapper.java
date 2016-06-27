package cn.fangcheng.mybatis.mapper;

import java.util.List;

import cn.fangcheng.mybatis.po.Category;

public interface CategoryMapper {
	
	public List<Category> selectByBrandid(int brandid);
	public List<Category> selectByCategoryid(int categoryid);
	public List<Category> selectCatOne(int categoryid);
	
}
