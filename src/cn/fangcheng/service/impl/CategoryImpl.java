package cn.fangcheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cn.fangcheng.mybatis.mapper.CategoryMapper;
import cn.fangcheng.mybatis.po.Category;
import cn.fangcheng.service.CategoryInterface;

@Service
public class CategoryImpl implements CategoryInterface{
	
public Gson gson = new Gson();
	
	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public List<Category> selectByBrandid(int brandid) {
		// TODO Auto-generated method stub
		List<Category> list = categoryMapper.selectByBrandid(brandid);
//		if(null != list){
//			System.out.println(gson.toJson(list));
//		}else{
//			System.out.println(brandid);
//			System.out.println("无数据");
//		}
		return list;
	}

	@Override
	public List<Category> selectByCategoryid(int category) {
		// TODO Auto-generated method stub
		List<Category> list = categoryMapper.selectByCategoryid(category);
//		if(null != list){
//			System.out.println(gson.toJson(list));
//		}else{
//			System.out.println(category);
//			System.out.println("无数据");
//		}
		return list;
	}

	@Override
	public List<Category> selectCatOne(int category) {
		List<Category> list = categoryMapper.selectCatOne(category);
		return list;
	}
	
	
	
}
