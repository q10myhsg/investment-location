package cn.fangcheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.mybatis.mapper.PassportActivityMapper;
import cn.fangcheng.mybatis.po.PassportActivity;
import cn.fangcheng.service.PassportActivityInterface;

@Service
public class PassportActivityImpl implements PassportActivityInterface{
	
	@Autowired
	PassportActivityMapper mapper;
	
	public static void main(String[] args) {
		System.out.println(Math.log10(1));

	}

	@Override
	public PassportActivity selectActivity(PassportActivity pass) {
		PassportActivity passport = mapper.selectActivity(pass);
		passport.setActivity_log10(Math.log10(passport.getActivity()+1));
		return passport;
	}

}
