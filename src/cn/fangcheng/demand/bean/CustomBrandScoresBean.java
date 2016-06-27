package cn.fangcheng.demand.bean;



/**
 * 自定义 brand demand 自定义得分
 * @author Administrator
 *
 */
public class CustomBrandScoresBean {

	
	/**
	 * 将更新时间转换为long
	 */
	public long demand_ctime_val =0L;
	/**
	 * 转换为天
	 */
	public long demand_ctime_day=0L;
	/**
	 * 是否显示电话
	 */
	public int demand_show_mobile=0;
	/**
	 * 需求级别
	 */
	public double demand_level=0;

	public int[] category_ids;
	
	
	public int business_cycle_count;
	
	
	public int getBusiness_cycle_count() {
		return business_cycle_count;
	}
	public void setBusiness_cycle_count(int business_cycle_count) {
		this.business_cycle_count = business_cycle_count;
	}
	//public Tag tag;

	public int getDemand_show_mobile() {
		return demand_show_mobile;
	}
	public void setDemand_show_mobile(int demand_show_mobile) {
		this.demand_show_mobile = demand_show_mobile;
	}
	public double getDemand_level() {
		return demand_level;
	}
	public void setDemand_level(double demand_level) {
		this.demand_level = demand_level;
	}
	public int[] getCategory_ids() {
		return category_ids;
	}
	public void setCategory_ids(int[] category_ids) {
		this.category_ids = category_ids;
	}
//	public Tag getTag() {
//		return tag;
//	}
//	public void setTag(Tag tag) {
//		this.tag = tag;
//	}
	public long getDemand_ctime_val() {
		return demand_ctime_val;
	}
	public void setDemand_ctime_val(long demand_ctime_val) {
		this.demand_ctime_val = demand_ctime_val;
	}
	public long getDemand_ctime_day() {
		return demand_ctime_day;
	}
	public void setDemand_ctime_day(long demand_ctime_day) {
		this.demand_ctime_day = demand_ctime_day;
	}
	
	
	
}
