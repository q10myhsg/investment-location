package cn.fangcheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.mybatis.mapper.PassportMapper;
import cn.fangcheng.mybatis.po.Passport;
import cn.fangcheng.service.PassportInterface;

@Service
public class PassportMapperImpl implements PassportInterface{
	
	@Autowired
	PassportMapper passportMapper;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Passport selectByPassportId(int passport_id) {
		// TODO Auto-generated method stub
		Passport pass = passportMapper.selectByPassportId(passport_id);
		return pass;
	}

	@Override
	public List<Passport> selectAllPassportId() {
		// TODO Auto-generated method stub
		List<Passport> pass = passportMapper.selectAllPassportId();
		return pass;
	}

	@Override
	public void insertFromV2() {
		// TODO Auto-generated method stub
		passportMapper.insertFromV2();
	}

	@Override
	public void updateForLogincity(Passport passport) {
		// TODO Auto-generated method stub
		passportMapper.updateForLogincity(passport);
	}

}
