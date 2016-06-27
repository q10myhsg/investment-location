package cn.fangcheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.mybatis.mapper.MallMapper;
import cn.fangcheng.mybatis.po.Mall;
import cn.fangcheng.mybatis.po.MallData;
import cn.fangcheng.service.MallDataInterface;
import cn.fangcheng.service.MallInterface;

import com.google.gson.Gson;
@Service
public class MallMapperImpl implements MallInterface {
	
	public Gson gson = new Gson();
	@Autowired
	MallMapper mallMapper;
	@Autowired
	MallDataInterface malldata;
	
	public MallMapperImpl(){
		
	}

	@Override
	public Mall selectByPrimaryKey(int mallId) {
		Mall mall = mallMapper.selectByPrimaryKey(mallId);
		MallData md = null;
		if(null != mall){
			md = malldata.selectByPrimaryKey(mallId);
			if(null != md)
				mall.setMalldata(md);
			//System.out.println(gson.toJson(mall));	
		}else{
			//System.out.println("无数据");
		}
		return mall;
	}
	//CASE WHEN DATE_FORMAT(mall_closed_date,'%Y-%m-%d') = "0000-00-00" THEN NULL ELSE mall_closed_date END
	
}
