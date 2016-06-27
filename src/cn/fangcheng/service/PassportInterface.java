package cn.fangcheng.service;

import java.util.List;

import cn.fangcheng.mybatis.po.Passport;

public interface PassportInterface {
	
	Passport selectByPassportId(int passport_id);
	List<Passport> selectAllPassportId();
	void insertFromV2();
	void updateForLogincity(Passport passport);
	
}
