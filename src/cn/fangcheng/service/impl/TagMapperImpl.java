package cn.fangcheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cn.fangcheng.mybatis.mapper.TagMapper;
import cn.fangcheng.mybatis.po.Taginfo;
import cn.fangcheng.service.TagInterface;
@Service
public class TagMapperImpl implements TagInterface{
	
	public Gson gson = new Gson();
	
	@Autowired
	TagMapper tagMapper;
	
	public TagMapperImpl(){
		
	}
	
	@Override
	public Taginfo selectByPrimaryKey(int tagId) {
		Taginfo tag = tagMapper.selectByPrimaryKey(tagId);
//		if(null != tag){
//			System.out.println(gson.toJson(tag));
//		}else{
//			System.out.println(tagId);
//			System.out.println("无数据");
//		}
		return tag;
	}

	@Override
	public List<Taginfo> selectByGroupId(int groupId) {
		List<Taginfo> tag = tagMapper.selectByGroupId(groupId);
//		if(null != tag){
//			System.out.println(gson.toJson(tag));
//		}else{
//			System.out.println(groupId);
//			System.out.println("无数据");
//		}
		return tag;
	}
	
}
