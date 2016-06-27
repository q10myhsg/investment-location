package cn.fangcheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cn.fangcheng.mybatis.mapper.MallDataMapper;
import cn.fangcheng.mybatis.po.MallData;
import cn.fangcheng.service.MallDataInterface;

@Service
public class MallDataMapperImpl implements MallDataInterface{
	
	public Gson gson = new Gson();
	
	@Autowired
	MallDataMapper mallDataMapper;
	
	@Override
	public MallData selectByPrimaryKey(int mallId) {
		MallData mallData = mallDataMapper.selectByPrimaryKey(mallId);
//		if(null != mallData){
//			System.out.println(gson.toJson(mallData));
//		}else{
//			System.out.println(mallId);
//			System.out.println("无数据");
//		}
		return mallData;
	}
	
}
