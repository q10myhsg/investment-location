package cn.fangcheng.mybatis.mapper;

import cn.fangcheng.mybatis.po.PassportBrowse;

public interface PassportBrowseMapper {
	/**
	 * 用户浏览日志统计数据入库
	 */
	void insertInto(PassportBrowse pb);
	/**
	 * 用户浏览日志统计数据入库
	 */
	void deleteByDate(String browsedate);
}
