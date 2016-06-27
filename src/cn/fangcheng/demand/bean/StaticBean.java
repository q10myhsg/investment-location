package cn.fangcheng.demand.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StaticBean {

	/**
	 * 删除
	 * 对应demand_status字段 0表示无效
	 */
	public final static int DELETE=0;
	
	
	public final static String DOT="_dot_";
	
	/**
	 * 为mall
	 */
	public final static int MALL_TYPE=2;
	/**
	 * 为brand
	 */
	public final static int BRAND_TYPE=1;
	
	
	/**
	 * es返回数据中需要移除的内容
	 */
	public static List<String> remove=new ArrayList<String>();
	/**
	 * es返回数据中需要移除_source的内容
	 */
	public static List<String> _sourceRemove=new ArrayList<String>();
	/**
	 * es返回数据中需要移除_source.tag的内容
	 */
	public static List<String> tagRemove=new ArrayList<String>();
	
	
	/**
	 * 日期格式化函数
	 */
	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	static{
		remove.add("_index");
		remove.add("_type");
		remove.add("sort");
		_sourceRemove.add("bid");
		_sourceRemove.add("bid_name");
		_sourceRemove.add("info");
		_sourceRemove.add("infoScore");
		tagRemove.add("preferredPropertyAll");
		tagRemove.add("shopSpecificationsAll");
		tagRemove.add("termCooperation");
		tagRemove.add("areaDemand");
		tagRemove.add("shopArea");
	}
	/**
	 * 翻转index
	 * @param bid
	 * @return
	 */
	public static int relIndex(int type){
		if(type==StaticBean.MALL_TYPE){
			return StaticBean.BRAND_TYPE;
		}else{
			return StaticBean.MALL_TYPE;
		}
	}
}
