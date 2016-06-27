package cn.fangcheng.service;

import cn.fangcheng.mybatis.po.PassportBrowse;

public interface PassportBrowseInterface {
	
	/**
	 * 用户浏览日志统计数据入库
	 */
	void insertInto(PassportBrowse pb);
	/**
	 * 用户浏览日志统计数据入库
	 */
	void deleteByDate(String browsedate);
	/**
	 * 通过发送post请求到ES统计用户浏览模块的信息
	 */
	String postEs(String httpAddress,String query);
	/**
	 * 获取Es中数据统计query
	 */
	String getQuery(String scriptFile, String dealDate);
	/**
	 * 处理统计数据结果
	 */
	int dealdata(String data, String dealDate);
}
