package cn.fangcheng.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import cn.fangcheng.mybatis.po.Brand_category_name;
import cn.fangcheng.mybatis.po.Category;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.Tag;
import cn.fangcheng.mybatis.po.Taginfo;
import cn.fangcheng.service.CategoryInterface;
import cn.fangcheng.service.DemandInterface;
import cn.fangcheng.service.TagInterface;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
@Service
public class DemandMapperImpl implements DemandInterface {
	
	public Gson gson = new Gson();
	
	@Autowired
	public MongoTemplate admin;
	@Autowired
	TagInterface tag;
	@Autowired
	CategoryInterface category;
	
	public DemandMapperImpl(){
		
	}
	
	public static void main(String[] args) {
		DemandMapperImpl action = new DemandMapperImpl();
		//action.getDemandXZbyId("5596dd5025a4bc16b8ca289d");
		action.getDemandZSbyJson("559a05bcde833c6a098b4567");
		
	}
	@Override
	public DemandXZ getDemandXZbyId(String id) {
		DemandXZ demandXZ = null;
		String str = "";
		BasicDBObject dbo = new BasicDBObject();
		dbo.put("_id", new ObjectId(id));
		dbo.put("demand_type", 1);
		DB fangcheng_v2 = admin.getDb().getMongo().getDB("fangcheng_v2");
		DBObject dbc = fangcheng_v2.getCollection("demand").findOne(dbo);
		if(null != dbc){
			dbc.removeField("_id");
//			str = changeFileds(dbc.toString());
//			demandXZ = gson.fromJson(str, DemandXZ.class);
			if(!dbc.get("area_id").toString().contains("[")){
				dbc.put("area_id",new int[] {Integer.parseInt(dbc.get("area_id").toString())});
			}
			demandXZ = gson.fromJson(dbc.toString(), DemandXZ.class);
			demandXZ.set_id(id);
			demandXZ.setTag(transforTag(demandXZ.getTag()));
			demandXZ.setCategory_name(getMallCategory(demandXZ.getCategory_ids(),2));
			//demandXZ.setBrand_category_name(selectCategoryByid(demandXZ.getBrand_id(),1));
			//System.out.println(gson.toJson(demandXZ));
		}
		return demandXZ;
	}

	@Override
	public DemandZS getDemandZSbyId(String id) {
		DemandZS demandZS = null;
		String str = "";
		BasicDBObject dbo = new BasicDBObject();
		dbo.put("_id", new ObjectId(id));
		dbo.put("demand_type", 2);
		DB fangcheng_v2 = admin.getDb().getMongo().getDB("fangcheng_v2");
		DBObject dbc = fangcheng_v2.getCollection("demand").findOne(dbo);
		if(null != dbc){
			dbc.removeField("_id");
			//转换tag对应关系
//			str = changeFileds(dbc.toString());
//			demandZS = gson.fromJson(str, DemandZS.class);
			if(!dbc.get("area_id").toString().contains("[")){
				dbc.put("area_id",new int[] {Integer.parseInt(dbc.get("area_id").toString())});
			}
			demandZS = gson.fromJson(dbc.toString(), DemandZS.class);
			//设置招商店铺类型(主力店......)
			if(demandZS.getDemand_shop_type() != null && demandZS.getDemand_shop_type().length>0){
				demandZS.setDemand_shop_type_name(getDemand_shop_type(demandZS.getDemand_shop_type()));
			}
			demandZS.set_id(id);
			//设置tag值
			demandZS.setTag(transforTag(demandZS.getTag()));
			demandZS.setCategory_name(getMallCategory(demandZS.getCategory_ids(),2));
			//System.out.println(gson.toJson(demandZS));
		}
		return demandZS;
	}
	@Override
	public DemandXZ getDemandXZbyJson(String json) {
		DemandXZ demandXZ = null;
		//DBObject dbc =(DBObject)JSON.parse(json);
		if(null != json && json.length()>100){
			demandXZ = gson.fromJson(json, DemandXZ.class);
			//设置tag值
			demandXZ.setTag(transforTag(demandXZ.getTag()));
			demandXZ.setCategory_name(getMallCategory(demandXZ.getCategory_ids(),2));
			//System.out.println(gson.toJson(demandXZ));
		}
		return demandXZ;
	}

	@Override
	public DemandZS getDemandZSbyJson(String json) {
		DemandZS demandZS = null;
		//DBObject dbc = dbc =(DBObject)JSON.parse(json);
		if(null != json && json.length()>100){
			demandZS = gson.fromJson(json, DemandZS.class);
			//设置招商店铺类型(主力店......)
			if(demandZS.getDemand_shop_type() != null && demandZS.getDemand_shop_type().length>0){
				demandZS.setDemand_shop_type_name(getDemand_shop_type(demandZS.getDemand_shop_type()));
			}
			//设置tag值
			demandZS.setTag(transforTag(demandZS.getTag()));
			demandZS.setCategory_name(getMallCategory(demandZS.getCategory_ids(),2));
			//System.out.println(gson.toJson(demandZS));
		}
		return demandZS;
	}
	/**
	 * 获取mall的招商业态
	 */
	 public Brand_category_name getMallCategory(int[] category_ids,int a){
		 Brand_category_name category_name = new Brand_category_name();
		 Set<String> cat1 = new HashSet<String>();
		 Set<String> cat2 = new HashSet<String>();
		 Set<String> cat3 = new HashSet<String>();
		 Brand_category_name category = null;
		 if(category_ids != null && category_ids.length>0){
			 for(int i=0;i<category_ids.length;i++){
				 category = selectCategoryByid(category_ids[i],a);
				 setSet(cat1,category.cat1);
				 setSet(cat2,category.cat2);
				 setSet(cat3,category.cat3);
			 }
			 cat1.remove(null);
			 cat1.remove("全业态");
			 cat1.remove("");
			 cat2.remove("");
			 cat3.remove("");
		 }
		 category_name.setCat1(cat1);
		 category_name.setCat2(cat2);
		 category_name.setCat3(cat3);
		 return category_name;
	 }
	 public void setSet(Set<String> set,Set<String> cat){
		 if(null != cat && cat.size()>0){
			 for(String str:cat){
				 set.add(str);
			 }
		 }
	 }
	/**
	 * 获取品牌的业态信息
	 */
	public Brand_category_name selectCategoryByid(int id,int a) {
		Brand_category_name brand_category_name = new Brand_category_name();
		Set<String> cat1 = new HashSet<String>();
		Set<String> cat2 = new HashSet<String>();
		Set<String> cat3 = new HashSet<String>();
		List<Category> list = null;
		if(a == 1)
			list = category.selectByBrandid(id);
		if(a == 2){
			if(id != 1000000){
				list = category.selectByCategoryid(id);
			}else{
				list = category.selectCatOne(id);
				//System.out.println(gson.toJson(list));
			}
		}
		if(null != list && list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getCat1() == null){
					cat1.add(list.get(i).getCat3());
				} else if(list.get(i).getCat1().equals("全业态")){
					cat1.add(list.get(i).getCat2());
					cat2.add(list.get(i).getCat3());
				}else{
					cat1.add(list.get(i).getCat1());
					cat2.add(list.get(i).getCat2());
					cat3.add(list.get(i).getCat3());
				}
			}
		}else{
//			System.out.println(id);
//			System.out.println("无数据");
		}
		brand_category_name.setCat1(cat1);
		brand_category_name.setCat2(cat2);
		brand_category_name.setCat3(cat3);
		return brand_category_name;
	}
	/**
	 * 插入招商表
	 */
	public String[] getDemand_shop_type(int[] demand_shop_type){
		String[] demand_shop_type_name = new String[demand_shop_type.length];
		//1主力店|2次主力店|3普通店铺
		for(int i=0;i<demand_shop_type.length;i++){
			if(demand_shop_type[i] == 1){
				demand_shop_type_name[i] = "主力店";
			}else if(demand_shop_type[i] == 2){
				demand_shop_type_name[i] = "次主力店";
			}else if(demand_shop_type[i] == 3){
				demand_shop_type_name[i] = "普通店铺";
			}else{
				demand_shop_type_name[i] = "";
			}
		}
		return demand_shop_type_name;
	}
	/**
	 * 设置tag字段
	 */
	public Tag transforTag(Tag ma){
		ma.setAreaDemand(ma.getGroup_41());
		ma.setShopArea(ma.getGroup_126());
		ma.setTermCooperation(ma.getGroup_40());
		ma.setPreferredPropertyAll(getTag(ma.getGroup_36(),36));
		//ma.setPreferredProperty(getTag(tag.getPreferredProperty(),0));
		//ma.setPreferredPropertyAll(getTag(tag.getPreferredProperty(),36));
		ma.setShopSpecificationsAll(getTag(ma.getGroup_46(),46));
		//ma.setShopSpecifications(getTag(tag.getShopSpecifications(),0));
		//ma.setShopSpecificationsAll(getTag(tag.getShopSpecifications(),46));
		return ma;
	}
	/**
	 * 设置tag字段
	 */
	public String[] getTag(int[] tags,int group){
		String[] str = null;
		Taginfo taginfo = null;
		List<Taginfo> list = null;
		if(null != tags){
			if(group > 0 && tags.length == 1){
				taginfo = tag.selectByPrimaryKey(tags[0]);
				if(null != taginfo && taginfo.getTagName().equals("不限")){
					list = tag.selectByGroupId(group);
					str = new String[list.size()];
					for(int a=0;a<list.size();a++){
						str[a] = list.get(a).getTagName();
					}
				}else{
					str = new String[tags.length];
					for(int i=0;i<tags.length;i++){
						taginfo = tag.selectByPrimaryKey(tags[i]);
						if(null != taginfo)
							str[i] = taginfo.getTagName();
					}
				}
			}else{
				str = new String[tags.length];
				for(int i=0;i<tags.length;i++){
					taginfo = tag.selectByPrimaryKey(tags[i]);
					if(null != taginfo)
						str[i] = taginfo.getTagName();
				}
			}
		}
		return str;
	}
	/**
	 * 设置字段对应关系
	 */
	public String changeFileds(String str){
		//首选物业
		str = str.replace("group_36", "preferredProperty");
		//店铺类型
		//str = str.replace("group_116", "shopType");
		//店铺规格
		str = str.replace("group_46", "shopSpecifications");
		//合作期限
		str = str.replace("group_40", "termCooperation");
		//面积需求
		str = str.replace("group_41", "areaDemand");
		//租金预算
		//str = str.replace("group_42", "budgetRent");
		//店铺面积
		str = str.replace("group_126", "shopArea");
		
		return str;
	}

}
