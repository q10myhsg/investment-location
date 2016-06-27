package cn.fangcheng.tool;

import java.net.UnknownHostException;
import java.util.HashMap;

import com.mongodb.BasicDBList;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class Test {

	public static void main(String[] args) {
		Mongo mongo;
		try {
//			mongo = new Mongo("192.168.1.134",27017);
//			DB db = mongo.getDB("fangcheng_v2");
//			DBCollection page = db.getCollection("demand");
	        
			mongo = new Mongo("192.168.1.11",27017);
			DB db = mongo.getDB("xingp");
			DBCollection page = db.getCollection("college");
			
			HashMap<String,String> dimMap = new HashMap<String,String>();
			dimMap.put("city","city");
			dimMap.put("type","type");
//			dimMap.put("passport_id","passport_id");    //用户id
//			dimMap.put("demand_type","demand_type");    //需求类型
			
			//统计公式中用到的字段:
			HashMap<String,String> indexMap = new HashMap<String,String>();
			indexMap.put("page","page");    //用户编码
			
			//统计的结果字段:
			HashMap<String,String> forIdxMap = new HashMap<String,String>();
			forIdxMap.put("num","count(page)");            //用户数
			
			System.out.println("11111111");
			System.out.println(GroupUtil.generateFormulaKeyObject(dimMap).toString());
			System.out.println(GroupUtil.query("重庆市").toString());
			System.out.println(GroupUtil.generateFormulaInitObject(indexMap).toString());
			System.out.println(GroupUtil.generateFormulaReduceObject(indexMap).toString());
			System.out.println(GroupUtil.generateFormulaFinalizeObject(forIdxMap, indexMap));
			System.out.println("11111111");
			//java调用：
			BasicDBList basicDBList = (BasicDBList)page.group(
					GroupUtil.generateFormulaKeyObject(dimMap),
					null,
					GroupUtil.generateFormulaInitObject(indexMap),
					GroupUtil.generateFormulaReduceObject(indexMap),
					GroupUtil.generateFormulaFinalizeObject(forIdxMap, indexMap));
			System.out.println("aaaaaaaaa:"+basicDBList.size());
			System.out.println("bbbbbbbbb:"+basicDBList.toString());
			
//			BasicDBList basicDBList = (BasicDBList)db.getCollection("mongodb中集合编码或者编码").group(
//					DBObject key,   --分组字段，即group by的字段
//	                DBObject cond,        --查询中where条件
//	                DBObject initial,     --初始化各字段的值
//	                String reduce,        --每个分组都需要执行的Function
//	                String finial         --终结Funciton对结果进行最终的处理
//	                );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
