package cn.fangcheng.mybatis.mapper;

import java.util.List;

import cn.fangcheng.mybatis.po.LogLogin;

public interface LogLoginMapper {
	/**
	 * 根据用户id和日期yyyymmdd来查询用户当天登录次数
	 */
    LogLogin groupBypassportIdCtime(LogLogin record);
    /**
	 * 根据用户id和日期yyyymmdd来查询用户登录信息
	 */
    List<LogLogin> selectBypassportIdCtime(LogLogin record);
    /**
	 * 统计用户登录地的百分比
	 */
    List<LogLogin> loginCityPercent(LogLogin record);
    /**
	 * 根据月份yyyymm查询登录过平台的用户id
	 */
    List<Integer> distinctPassportid(String yyyymm);
    /**
	 * 根据日期yyyymmdd统计当天所有用户登录平台的情况
	 */
    void groupByCtime(String login_date);
    /**
	 * 避免重复统计根据日期yyyymmdd删除当天的统计数据
	 */
    void deleteByCtime(String login_date);
}