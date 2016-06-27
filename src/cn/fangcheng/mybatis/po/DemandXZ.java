package cn.fangcheng.mybatis.po;


public class DemandXZ {
	private String _id;
    private String demand_ctime;
    private String demand_utime;
    private String demand_expiry_at;
    private int passport_id;
    private int brand_id;
	private String brand_name;
	private int[] category_ids;
	//private String[] category_name;
	private Brand_category_name category_name;
	private String category_ids_other;
	private long[] area_id;
	private String demand_desc;
	private int demand_show_mobile;
	private int demand_level;
	private int demand_status;
	private int demand_type;
	private int passport_type;
    private String passport_company;
	private Tag tag;
	private int weixin_push;
	
	public int getWeixin_push() {
		return weixin_push;
	}
	public void setWeixin_push(int weixin_push) {
		this.weixin_push = weixin_push;
	}
	public Brand_category_name getCategory_name() {
		return category_name;
	}
	public void setCategory_name(Brand_category_name category_name) {
		this.category_name = category_name;
	}
	public String getDemand_ctime() {
		return demand_ctime;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public void setDemand_ctime(String demand_ctime) {
		this.demand_ctime = demand_ctime;
	}
	public String getDemand_utime() {
		return demand_utime;
	}
	public void setDemand_utime(String demand_utime) {
		this.demand_utime = demand_utime;
	}
	public String getDemand_expiry_at() {
		return demand_expiry_at;
	}
	public void setDemand_expiry_at(String demand_expiry_at) {
		this.demand_expiry_at = demand_expiry_at;
	}
	public int getPassport_id() {
		return passport_id;
	}
	public void setPassport_id(int passport_id) {
		this.passport_id = passport_id;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public int[] getCategory_ids() {
		return category_ids;
	}
	public void setCategory_ids(int[] category_ids) {
		this.category_ids = category_ids;
	}
	public String getCategory_ids_other() {
		return category_ids_other;
	}
	public void setCategory_ids_other(String category_ids_other) {
		this.category_ids_other = category_ids_other;
	}
	public long[] getArea_id() {
		return area_id;
	}
	public void setArea_id(long[] area_id) {
		this.area_id = area_id;
	}
	public String getDemand_desc() {
		return demand_desc;
	}
	public void setDemand_desc(String demand_desc) {
		this.demand_desc = demand_desc;
	}
	public int getDemand_show_mobile() {
		return demand_show_mobile;
	}
	public void setDemand_show_mobile(int demand_show_mobile) {
		this.demand_show_mobile = demand_show_mobile;
	}
	public int getDemand_level() {
		return demand_level;
	}
	public void setDemand_level(int demand_level) {
		this.demand_level = demand_level;
	}
	public int getDemand_status() {
		return demand_status;
	}
	public void setDemand_status(int demand_status) {
		this.demand_status = demand_status;
	}
	public int getDemand_type() {
		return demand_type;
	}
	public void setDemand_type(int demand_type) {
		this.demand_type = demand_type;
	}
	public int getPassport_type() {
		return passport_type;
	}
	public void setPassport_type(int passport_type) {
		this.passport_type = passport_type;
	}
	public String getPassport_company() {
		return passport_company;
	}
	public void setPassport_company(String passport_company) {
		this.passport_company = passport_company;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
