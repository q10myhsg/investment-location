package cn.fangcheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.service.BrandInterface;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
@Service
public class BrandMapperImpl implements BrandInterface {
	
	public Gson gson = new Gson();
	@Autowired
	public MongoTemplate admin;
	
	public BrandMapperImpl(){
		
	}
	@Override
	public Brand getBrandById(int id) {
		Brand brand = null;
		BasicDBObject dbo = new BasicDBObject();
		dbo.put("brand_id", id);
		DB fangcheng_global = admin.getDb().getMongo().getDB("fangcheng_global");
		DBObject dbc = fangcheng_global.getCollection("brand_info").findOne(dbo);
		if(null != dbc){
			dbc.removeField("_id");
			dbc.removeField("brand_search_option");
			brand = gson.fromJson(dbc.toString(), Brand.class);
			if(brand.getBusiness_circle() == null){
				brand.setBusiness_circle(new String[0]);
			}
			brand.setBrandId(id);
			//System.out.println(gson.toJson(brand));
		}
		return brand;
	}
	
}
