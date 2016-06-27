package cn.fangcheng.demand.controller.rest;

import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.demand.bean.script.Script;
import cn.fangcheng.demand.servlet.InitServlet;
import cn.fangcheng.demand.tool.JavaNetURLRESTFullClient;

public class Test {
	public static void main(String[] args) {
		String alias = InitServlet.indexTarget + "_2015-03-123";
		System.out
				.println(alias.substring(InitServlet.indexTarget.length() + 11));
		
		System.out.println(Script.getEsMapping(StaticBean.BRAND_TYPE));
//		System.out.println(Script.getEsMapping(StaticBean.BRAND_TYPE));
//		// 创建索引
//		String message = JavaNetURLRESTFullClient.post2("http://192.168.1.64:9200/search_demand_matching_2015-11-04", "PUT", null, JavaNetURLRESTFullClient.code);
//		System.out.println("message:" + message);
//		if (message.contains("missing") || message.contains("already exists")) {
//			message = JavaNetURLRESTFullClient.post2("http://192.168.1.64:9200/search_demand_matching_2015-11-04", "DELETE", null, JavaNetURLRESTFullClient.code);
//			System.out.println("message:delete:" + message);
//			message = JavaNetURLRESTFullClient.post2("http://192.168.1.64:9200/search_demand_matching_2015-11-04", "PUT", null, JavaNetURLRESTFullClient.code);
//			System.out.println("message:put:" + message);
//		}
//		System.out.println("http://192.168.1.64:9200/search_demand_matching_2015-11-04/brand_demand/_mapping" +"\t"+Script.getEsMapping(StaticBean.BRAND_TYPE));
//		System.out.println(JavaNetURLRESTFullClient.post2(
//				"http://192.168.1.64:9200/search_demand_matching_2015-11-04/brand_demand/_mapping",
//				"PUT", Script.getEsMapping(StaticBean.BRAND_TYPE),JavaNetURLRESTFullClient.code));
	}
}
