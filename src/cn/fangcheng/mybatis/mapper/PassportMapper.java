package cn.fangcheng.mybatis.mapper;

import java.util.List;

import cn.fangcheng.mybatis.po.Passport;

public interface PassportMapper {
	/**
	 * 通过用户id查询用户信息
	 */
	Passport selectByPassportId(int passport_id);
	/**
	 * 查询所有用户id
	 */
	List<Passport> selectAllPassportId();
	/**
	 * 将新增的用户信息同步到passport_deal表
	 */
	void insertFromV2();
	/**
	 * 更新用户登录地信息
	 */
	void updateForLogincity(Passport passport);
}