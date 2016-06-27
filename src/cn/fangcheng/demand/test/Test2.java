package cn.fangcheng.demand.test;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.demand.tool.JavaNetURLRESTFullClient;
import cn.fangcheng.demand.tool.JsonUtil;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-*.xml" })
public class Test2 {
	@Autowired
	private MongoTemplate admin;

	/**
	 * 是否有效
	 * 
	 * @param zs
	 * @return
	 * @throws Exception
	 */
	public static boolean isAvailably(String name, String demand_desc,
			String passport_company, int passport_id) throws Exception {
		if ((name != null && name.contains("测试"))
				|| (demand_desc != null && demand_desc.contains("测试"))
				|| (passport_company != null && passport_company.contains("测试"))
				|| passport_id < 30) {
			return false;
		}
		return true;
	}

	/**
	 * 方法用来 验证所有数据是否都存在
	 * @throws ParseException
	 * @throws IOException
	 */
	@Test
	public void test() throws ParseException, IOException {
		System.out.println("启动");
		DB mongo = admin.getDb().getMongo().getDB("fangcheng_v2");
		DBCursor cursor = mongo.getCollection("demand").find();
		int from = 0;
		int size = 5;
		long start = System.currentTimeMillis();
		int count = 0;
		int clearnCount=0;
		while (cursor.hasNext()) {
			DBObject obj = (DBObject) cursor.next();
			// logger.info("进入:"+obj.toString());
			String id = obj.get("_id").toString();
			obj.removeField("_id");
			obj.put("_id", id);
			String str = obj.toString();
			ObjectNode node = JsonUtil.parse(str);
			ObjectNode node2 = JsonUtil.init();
			String area_id = obj.get("area_id").toString().replaceAll(" ", "");
			String demand_ctime = obj.get("demand_ctime").toString();
			long timeEnd = StaticBean.sdf.parse(demand_ctime).getTime();
			node2.set("demand", node);
			node2.put("timeEnd", timeEnd);
			// System.out.println("demand:"+obj.get("demand_status"));
			int demandType = Integer
					.parseInt(obj.get("demand_type").toString());
			String name = null;
			if (demandType == 2) {
				name = obj.get("mall_name").toString();
			} else {
				name = obj.get("brand_name").toString();
			}
			String demand_desc = obj.get("demand_desc").toString();
			String passport_company = obj.get("passport_company").toString();
			int passport_id = Integer.parseInt(obj.get("passport_id")
					.toString());
			try {
				if (obj.get("demand_status").toString().equals("0")) {
					clearnCount++;
					continue;
				}
				if (!isAvailably(name, demand_desc, passport_company,
						passport_id)) {
					clearnCount++;
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = node2.toString();
			// System.out.println("str:"+str);
			try {
				String temp = null;
				if (demandType == 2) {
					temp = JavaNetURLRESTFullClient.post2(
							"http://192.168.1.64:9200/search_demand_matching/mall_demand/"
									+ id, "GET", null, "utf-8");
				} else {
					temp = JavaNetURLRESTFullClient.post2(
							"http://192.168.1.64:9200/search_demand_matching/brand_demand/"
									+ id, "GET", null, "utf-8");
				}
				
				if (temp==null||temp.length() < 200) {
					System.out.println(demandType+"异常:" + id);
					System.out.println(temp);
				} else {
					//System.out.println(temp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			// try {
			// String temp = JavaNetURLRESTFullClient.post2(
			// "http://192.168.1.11/InvestmentLocation/rest/demand/sim",
			// "POST", str,"utf-8");
			// //System.out.println(temp);
			// } catch (Exception e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// count++;
			// if (count >= 100) {
			// break;
			// }
		}
		long end = System.currentTimeMillis();
		System.out.println("每一个处理:" + (end - start) / count + "毫秒");
		System.out.println("每秒处理:" + count / ((end - start) / 1000) + "个");
		System.out.println("有效数量:"+count);
		System.out.println("过滤数量:"+clearnCount);
	}
}
