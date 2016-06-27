package cn.fangcheng.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;
import cn.fangcheng.mybatis.mapper.PassportBrowseMapper;
import cn.fangcheng.mybatis.po.PassportBrowse;
import cn.fangcheng.service.PassportBrowseInterface;
import cn.fangcheng.tool.PostRest;
import cn.fangcheng.tool.Project_Tool;

@Service
public class PassportBrowseMapperImpl implements PassportBrowseInterface{
	
	@Autowired
	PassportBrowseMapper pbm;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertInto(PassportBrowse pb) {
		// TODO Auto-generated method stub
		pbm.insertInto(pb);
	}

	@Override
	public void deleteByDate(String browsedate) {
		// TODO Auto-generated method stub
		pbm.deleteByDate(browsedate);
	}
	
	@Override
	public String postEs(String httpAddress,String query) {
		// TODO Auto-generated method stub
		//"http://123.56.113.168:19200/logstash/logs/_search"
		PostRest pr = new PostRest(httpAddress);
		String result = pr.postRest(query);
		
		return result;
	}
	
	@Override
	public String getQuery(String scriptFile,String dealDate){
		//"./config/script/passportBrowse"
		String query = Project_Tool.readFileByLines(scriptFile);
		query = query.replaceAll("#timestamp", dealDate);
		return query;
	}
	
	@Override
	public int dealdata(String data,String dealDate){
		JSONObject jo = null;
		JSONArray ja = null;
		PassportBrowse pb = null;
		JSONObject jb = null;
		int lenth = 0;
		try {
			if(null != data){
				jo = new JSONObject(data);
				ja = jo.getJSONObject("aggregations").getJSONObject("user_id").getJSONArray("buckets");
				lenth = ja.length();
				for(int i=0;i<ja.length();i++){
					jb = ja.getJSONObject(i);
					pb = new PassportBrowse();
					//System.out.println("--------------"+jb.getString("key").replaceAll("\"", ""));
					if(isNumeric(jb.getString("key").replaceAll("\"", ""))){
						pb.setPassport_id(Integer.parseInt(jb.getString("key").replaceAll("\"", "")));
						pb.setExec_date(dealDate);
						pb.setBrowsetotalnum(jb.getInt("doc_count"));
						JSONArray ja_1 = jb.getJSONObject("request_module").getJSONArray("buckets");
						for(int j=0;j<ja_1.length();j++){
							JSONObject temp = ja_1.getJSONObject(j);
							if(temp.getString("key").equals("/ucenter/demandshow")){
								pb.setDemandshownum(temp.getInt("doc_count"));
							}else if(temp.getString("key").equals("/mallshop/search")){
								pb.setShopsearchnum(temp.getInt("doc_count"));
							}else if(temp.getString("key").equals("/details/brand")){
								pb.setBrandnum(temp.getInt("doc_count"));
							}else if(temp.getString("key").equals("/details/mall")){
								pb.setMallnum(temp.getInt("doc_count"));
							}else if(temp.getString("key").equals("/search/index")){
								pb.setSearchnum(temp.getInt("doc_count"));
							}
						}
						insertInto(pb);
					}
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lenth;
	}
	/**
	 * 判断key是否为纯数字,是为true,否为false
	 */
	public boolean isNumeric(String str){ 
		Pattern pattern = Pattern.compile("[0-9]*"); 
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
}
