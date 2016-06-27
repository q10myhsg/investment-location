package cn.fangcheng.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import cn.fangcheng.mybatis.mapper.PassportDemandnumMapper;
import cn.fangcheng.mybatis.po.PassportDemandnum;
import cn.fangcheng.service.PassportDemandnumInterface;
import cn.fangcheng.tool.GroupUtil;

@Service
public class PassportDemandnumMapperImpl implements PassportDemandnumInterface {
	
	public Gson gson = new Gson();
	@Autowired
	public MongoTemplate admin;
	@Autowired
	PassportDemandnumMapper pass;
	
	@Override
	public void insertInto(PassportDemandnum record) {
		// TODO Auto-generated method stub
		pass.insertInto(record);
	}

	@Override
	public BasicDBList selectFromMongo(String insertime) {
		DB fangcheng_v2 = admin.getDb().getMongo().getDB("fangcheng_v2");
		DBCollection coll = fangcheng_v2.getCollection("demand");
		
		//统计中group by的字段
		HashMap<String,String> dimMap = new HashMap<String,String>();
		dimMap.put("passport_id","passport_id");    //用户id
		dimMap.put("demand_type","demand_type");    //需求类型
		
		//统计公式中用到的字段:
		HashMap<String,String> indexMap = new HashMap<String,String>();
		indexMap.put("weixin_push","weixin_push");    //用户编码
		
		//统计的结果字段:
		HashMap<String,String> forIdxMap = new HashMap<String,String>();
		forIdxMap.put("num","count(weixin_push)");            //用户数
		
		//java调用：
		BasicDBList basicDBList = (BasicDBList)coll.group(
				GroupUtil.generateFormulaKeyObject(dimMap),
				GroupUtil.query(insertime),
				GroupUtil.generateFormulaInitObject(indexMap),
				GroupUtil.generateFormulaReduceObject(indexMap),
				GroupUtil.generateFormulaFinalizeObject(forIdxMap, indexMap));
		//System.out.println(basicDBList.toString());
		return basicDBList;
	}
	
	@Override
	public void dealData(BasicDBList data,String dealtime) {
		// TODO Auto-generated method stub
		PassportDemandnum record = null;
		JSONObject bj = null;
		try {
			for(int i=0;i<data.size();i++){
				bj = new JSONObject(data.get(i).toString());
				record = new PassportDemandnum();
				record.setPassport_id(bj.getInt("passport_id"));
				record.setExec_date(dealtime);
				record.setDemand_type(bj.getInt("demand_type"));
				record.setDemand_num(bj.getInt("num"));
				insertInto(record);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByctime(String demand_ctime) {
		// TODO Auto-generated method stub
		pass.deleteByctime(demand_ctime);
	}

}
