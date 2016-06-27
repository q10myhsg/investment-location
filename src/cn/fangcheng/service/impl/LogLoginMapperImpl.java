package cn.fangcheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

import com.google.gson.Gson;

import cn.fangcheng.ip.IPSeeker;
import cn.fangcheng.mybatis.mapper.LogLoginMapper;
import cn.fangcheng.mybatis.mapper.PassportMapper;
import cn.fangcheng.mybatis.po.LogLogin;
import cn.fangcheng.mybatis.po.Passport;
import cn.fangcheng.service.LogLoginInterface;

@Service
public class LogLoginMapperImpl implements LogLoginInterface{
	
	public Gson gson = new Gson();
	@Autowired
	LogLoginMapper logLoginMapper;
	@Autowired
	PassportMapper passportMapper;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public LogLogin groupBypassportIdCtime(LogLogin record) {
		// TODO Auto-generated method stub
		LogLogin login = logLoginMapper.groupBypassportIdCtime(record);
		return login;
	}

	@Override
	public List<LogLogin> selectBypassportIdCtime(LogLogin record) {
		List<LogLogin> login = logLoginMapper.selectBypassportIdCtime(record);
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public void groupByCtime(String login_date) {
		logLoginMapper.groupByCtime(login_date);
	}

	@Override
	public void deleteByCtime(String login_date) {
		// TODO Auto-generated method stub
		logLoginMapper.deleteByCtime(login_date);
	}

	@Override
	public List<LogLogin> loginCityPercent(LogLogin record) {
		// TODO Auto-generated method stub
		List<LogLogin> list = logLoginMapper.loginCityPercent(record);
		return list;
	}

	@Override
	public List<Integer> distinctPassportid(String yyyymm) {
		// TODO Auto-generated method stub
		List<Integer> list = logLoginMapper.distinctPassportid(yyyymm);
		return list;
	}

	@Override
	public void dealdata(String yyyymm) {
		//获取当月所有登陆过系统的用户id
		List<Integer> listId = distinctPassportid(yyyymm);
		LogLogin login = null;
		List<LogLogin> list = null;
		JSONArray js = null;
		JSONObject jb = null;
		Passport pp = null;
		try {
			for(int i=0;i<listId.size();i++){
				login = new LogLogin();
				login.setPassport_id(listId.get(i));
				login.setExec_date(yyyymm);
				//按用户和时间来统计用户本月登陆系统地市的占比情况
				list = loginCityPercent(login);
				js = new JSONArray(gson.toJson(list));
				for(int j=0;j<js.length();j++){
					jb = js.getJSONObject(j);
					jb.remove("log_login_id");
					jb.remove("passport_id");
					jb.put("login_city", IPSeeker.getInstance().getCountry(jb.getString("log_login_ip")));
				}
				pp = new Passport();
				pp.setPassport_id(listId.get(i));
				pp.setLogin_city(js.toString());
				passportMapper.updateForLogincity(pp);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
