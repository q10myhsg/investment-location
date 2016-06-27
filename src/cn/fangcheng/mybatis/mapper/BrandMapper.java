package cn.fangcheng.mybatis.mapper;

import cn.fangcheng.mybatis.po.Brand;

public interface BrandMapper {
	
	public void insert(Brand bes);
	public void update(Brand bes);
	public Brand getBrandById(int id);
	public Brand getBrand( );
	
}
