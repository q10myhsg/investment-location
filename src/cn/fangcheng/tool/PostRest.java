package cn.fangcheng.tool;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import com.google.gson.Gson;

import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

public class PostRest {
	
	private HttpClient httpClient = null;
	private PostMethod post = null;
	private Gson gson = new Gson();
	/**
	 * 初始化httpclient
	 */
	public PostRest(String httpAddress){
		httpClient = new HttpClient();
		//"http://123.56.113.168:19200/logstash/logs/_search"
		post = new PostMethod(httpAddress);
	    post.setRequestHeader("Content-Type","application/json;charset=UTF-8");
	}
	
	public static void main(String[] args) {
		PostRest pr = new PostRest(null);
		String str = pr.getRest("http://192.168.1.64:9200/search_demand_matching/_alias");
		System.out.println(str);
	}
	
	public String postRest(String query){
		String responseBody = null;
		int statusCode = 0;
	    post.setRequestBody(query);
	    try {
			statusCode = httpClient.executeMethod(post);
//			if(statusCode != 200){
//				System.out.println(query);
//			}
			responseBody = post.getResponseBodyAsString();
			//System.out.println(responseBody);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(statusCode);
			try {
				System.out.println(post.getURI());
			} catch (URIException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			//关闭流
		    post.releaseConnection();
		    //关闭链接
//		    ((SimpleHttpConnectionManager)httpClient.getHttpConnectionManager()).shutdown();
		}
		return responseBody;
	}
	
	public String getRest(String url){
		HttpClient client = new HttpClient();
		GetMethod get = null;
		String str = null;
		try {
			get = new GetMethod(url);
			get.setRequestHeader("User-Agent","XT800");
			get.setRequestHeader("Cookie", "JSESSIONID=evlMmXfZaPwTQZN4ED76vDjs.www");
			String responseBody = null;
			int statusCode = client.executeMethod(get);
			responseBody = get.getResponseBodyAsString();
			str = new String (responseBody.getBytes("utf-8"), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(get != null){
				get.releaseConnection();
//				((SimpleHttpConnectionManager)client.getHttpConnectionManager()).shutdown();
			}
		}
		return str;
	}
	/**
	 * 用JSONObject拼接入参Query
	 */
	public String getQuery(){
		JSONObject js = new JSONObject();
        try {
			js.put("from", 0);
			js.put("size", 1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return js.toString();
	}
	
}
