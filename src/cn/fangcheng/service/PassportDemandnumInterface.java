package cn.fangcheng.service;

import com.mongodb.BasicDBList;

import cn.fangcheng.mybatis.po.PassportDemandnum;

public interface PassportDemandnumInterface {
	
	void insertInto(PassportDemandnum record);
	BasicDBList selectFromMongo(String insertime);
	void dealData(BasicDBList data,String dealtime);
	void deleteByctime(String demand_ctime);
	
}
