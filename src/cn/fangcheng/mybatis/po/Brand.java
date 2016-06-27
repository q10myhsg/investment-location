package cn.fangcheng.mybatis.po;

import java.util.Map;

/**
 * 
 * 品牌的统计信息
 * 
 * */
public class Brand {
	
	private String _id;
	private int brandId;
	private String country_code;
	private String brand_name;
	private String brand_name_en;
	private String brand_desc;
	private String brand_charact;
	private String brand_product_desc;
	private String brand_alias;
	private String brand_ceo;
	private String brand_ctime;
	private String brand_created_year;
	private String brand_created_year_cn;
	private String brand_closed_date;
	private String brand_founder;
	private String brand_group;
	private String brand_handbook;
	private String brand_hq;
	private String brand_hq_cn;
	private String brand_is_listed;
	private String brand_logo;
	private String brand_stock;
	private String brand_tel;
	private String brand_website;
	private String brand_website_cn;
	private String brand_weibo;
	private String brand_weixin;
	private int spider_channel_id;
	private long spider_channel_web_id;
	private int brand_black_list;
	private int brand_status;
	private String brand_search_name;
	private Brand_search_option brand_search_option;
	private String brand_search_keywords;
	private int brand_has_contact;
	private int brand_in_web;
	private String brand_status_desc;
	private String brand_combine_status;
	private int brand_passportNumTol;
	private int[] brand_categorys;
	private Brand_category_name brand_category_name;
	private int brand_demandCount;
	private int brand_inChengTV;
	private int brand_inRecommend;
	private double avg_dp_index;
	private double avg_price;
	private Size size;
	private String[] business_circle;
	private String[] mall;
	private int follow;
	private Map<String,Integer> ShopCount;
	private Map<String,Integer> MallShopCount;
	
	public int getFollow() {
		return follow;
	}
	public void setFollow(int follow) {
		this.follow = follow;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public String[] getMall() {
		return mall;
	}
	public void setMall(String[] mall) {
		this.mall = mall;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getBrand_name_en() {
		return brand_name_en;
	}
	public void setBrand_name_en(String brand_name_en) {
		this.brand_name_en = brand_name_en;
	}
	public String getBrand_desc() {
		return brand_desc;
	}
	public void setBrand_desc(String brand_desc) {
		this.brand_desc = brand_desc;
	}
	public String getBrand_charact() {
		return brand_charact;
	}
	public void setBrand_charact(String brand_charact) {
		this.brand_charact = brand_charact;
	}
	public String getBrand_product_desc() {
		return brand_product_desc;
	}
	public void setBrand_product_desc(String brand_product_desc) {
		this.brand_product_desc = brand_product_desc;
	}
	public String getBrand_alias() {
		return brand_alias;
	}
	public void setBrand_alias(String brand_alias) {
		this.brand_alias = brand_alias;
	}
	public String getBrand_ceo() {
		return brand_ceo;
	}
	public void setBrand_ceo(String brand_ceo) {
		this.brand_ceo = brand_ceo;
	}
	public String getBrand_ctime() {
		return brand_ctime;
	}
	public void setBrand_ctime(String brand_ctime) {
		this.brand_ctime = brand_ctime;
	}
	public String getBrand_created_year() {
		return brand_created_year;
	}
	public void setBrand_created_year(String brand_created_year) {
		this.brand_created_year = brand_created_year;
	}
	public String getBrand_created_year_cn() {
		return brand_created_year_cn;
	}
	public void setBrand_created_year_cn(String brand_created_year_cn) {
		this.brand_created_year_cn = brand_created_year_cn;
	}
	public String getBrand_closed_date() {
		return brand_closed_date;
	}
	public void setBrand_closed_date(String brand_closed_date) {
		this.brand_closed_date = brand_closed_date;
	}
	public String getBrand_founder() {
		return brand_founder;
	}
	public void setBrand_founder(String brand_founder) {
		this.brand_founder = brand_founder;
	}
	public String getBrand_group() {
		return brand_group;
	}
	public void setBrand_group(String brand_group) {
		this.brand_group = brand_group;
	}
	public String getBrand_handbook() {
		return brand_handbook;
	}
	public void setBrand_handbook(String brand_handbook) {
		this.brand_handbook = brand_handbook;
	}
	public String getBrand_hq() {
		return brand_hq;
	}
	public void setBrand_hq(String brand_hq) {
		this.brand_hq = brand_hq;
	}
	public String getBrand_hq_cn() {
		return brand_hq_cn;
	}
	public void setBrand_hq_cn(String brand_hq_cn) {
		this.brand_hq_cn = brand_hq_cn;
	}
	public String getBrand_is_listed() {
		return brand_is_listed;
	}
	public void setBrand_is_listed(String brand_is_listed) {
		this.brand_is_listed = brand_is_listed;
	}
	public String getBrand_logo() {
		return brand_logo;
	}
	public void setBrand_logo(String brand_logo) {
		this.brand_logo = brand_logo;
	}
	public String getBrand_stock() {
		return brand_stock;
	}
	public void setBrand_stock(String brand_stock) {
		this.brand_stock = brand_stock;
	}
	public String getBrand_tel() {
		return brand_tel;
	}
	public void setBrand_tel(String brand_tel) {
		this.brand_tel = brand_tel;
	}
	public String getBrand_website() {
		return brand_website;
	}
	public void setBrand_website(String brand_website) {
		this.brand_website = brand_website;
	}
	public String getBrand_website_cn() {
		return brand_website_cn;
	}
	public void setBrand_website_cn(String brand_website_cn) {
		this.brand_website_cn = brand_website_cn;
	}
	public String getBrand_weibo() {
		return brand_weibo;
	}
	public void setBrand_weibo(String brand_weibo) {
		this.brand_weibo = brand_weibo;
	}
	public String getBrand_weixin() {
		return brand_weixin;
	}
	public void setBrand_weixin(String brand_weixin) {
		this.brand_weixin = brand_weixin;
	}
	public int getSpider_channel_id() {
		return spider_channel_id;
	}
	public void setSpider_channel_id(int spider_channel_id) {
		this.spider_channel_id = spider_channel_id;
	}
	public long getSpider_channel_web_id() {
		return spider_channel_web_id;
	}
	public void setSpider_channel_web_id(long spider_channel_web_id) {
		this.spider_channel_web_id = spider_channel_web_id;
	}
	public int getBrand_black_list() {
		return brand_black_list;
	}
	public void setBrand_black_list(int brand_black_list) {
		this.brand_black_list = brand_black_list;
	}
	public int getBrand_status() {
		return brand_status;
	}
	public void setBrand_status(int brand_status) {
		this.brand_status = brand_status;
	}
	public String getBrand_search_name() {
		return brand_search_name;
	}
	public void setBrand_search_name(String brand_search_name) {
		this.brand_search_name = brand_search_name;
	}
	public Brand_search_option getBrand_search_option() {
		return brand_search_option;
	}
	public void setBrand_search_option(Brand_search_option brand_search_option) {
		this.brand_search_option = brand_search_option;
	}
	public String getBrand_search_keywords() {
		return brand_search_keywords;
	}
	public void setBrand_search_keywords(String brand_search_keywords) {
		this.brand_search_keywords = brand_search_keywords;
	}
	public int getBrand_has_contact() {
		return brand_has_contact;
	}
	public void setBrand_has_contact(int brand_has_contact) {
		this.brand_has_contact = brand_has_contact;
	}
	public int getBrand_in_web() {
		return brand_in_web;
	}
	public void setBrand_in_web(int brand_in_web) {
		this.brand_in_web = brand_in_web;
	}
	public String getBrand_status_desc() {
		return brand_status_desc;
	}
	public void setBrand_status_desc(String brand_status_desc) {
		this.brand_status_desc = brand_status_desc;
	}
	public String getBrand_combine_status() {
		return brand_combine_status;
	}
	public void setBrand_combine_status(String brand_combine_status) {
		this.brand_combine_status = brand_combine_status;
	}
	public int getBrand_passportNumTol() {
		return brand_passportNumTol;
	}
	public void setBrand_passportNumTol(int brand_passportNumTol) {
		this.brand_passportNumTol = brand_passportNumTol;
	}
	public int[] getBrand_categorys() {
		return brand_categorys;
	}
	public void setBrand_categorys(int[] brand_categorys) {
		this.brand_categorys = brand_categorys;
	}
	public Brand_category_name getBrand_category_name() {
		return brand_category_name;
	}
	public void setBrand_category_name(Brand_category_name brand_category_name) {
		this.brand_category_name = brand_category_name;
	}
	public int getBrand_demandCount() {
		return brand_demandCount;
	}
	public void setBrand_demandCount(int brand_demandCount) {
		this.brand_demandCount = brand_demandCount;
	}
	public int getBrand_inChengTV() {
		return brand_inChengTV;
	}
	public void setBrand_inChengTV(int brand_inChengTV) {
		this.brand_inChengTV = brand_inChengTV;
	}
	public int getBrand_inRecommend() {
		return brand_inRecommend;
	}
	public void setBrand_inRecommend(int brand_inRecommend) {
		this.brand_inRecommend = brand_inRecommend;
	}
	public double getAvg_dp_index() {
		return avg_dp_index;
	}
	public void setAvg_dp_index(double avg_dp_index) {
		this.avg_dp_index = avg_dp_index;
	}
	public double getAvg_price() {
		return avg_price;
	}
	public void setAvg_price(double avg_price) {
		this.avg_price = avg_price;
	}
	public String[] getBusiness_circle() {
		return business_circle;
	}
	public void setBusiness_circle(String[] business_circle) {
		this.business_circle = business_circle;
	}
	public Map<String, Integer> getShopCount() {
		return ShopCount;
	}
	public void setShopCount(Map<String, Integer> shopCount) {
		ShopCount = shopCount;
	}
	public Map<String, Integer> getMallShopCount() {
		return MallShopCount;
	}
	public void setMallShopCount(Map<String, Integer> mallShopCount) {
		MallShopCount = mallShopCount;
	}

}
