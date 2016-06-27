package cn.fangcheng.mybatis.po;

public class DemandZS {
	private String _id;
	private String demand_ctime;
    private String demand_utime;
    private String demand_expiry_at;
    private int passport_id;
    private int passport_type;
    private String passport_company;
    private int mall_id;
    private String mall_name;
    private long[] area_id;
	private String demand_desc;
	private int demand_show_mobile;
	private int demand_level;
	private int demand_status;
	private int[] category_ids;
	//private String[] category_name;
	private Brand_category_name category_name;
	private String category_ids_other;
	private int[] demand_shop_type;
	private String[] demand_shop_type_name;
	private int demand_type;
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
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getDemand_ctime() {
		return demand_ctime;
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
	public int getMall_id() {
		return mall_id;
	}
	public void setMall_id(int mall_id) {
		this.mall_id = mall_id;
	}
	public String getMall_name() {
		return mall_name;
	}
	public void setMall_name(String mall_name) {
		this.mall_name = mall_name;
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
	public int[] getDemand_shop_type() {
		return demand_shop_type;
	}
	public void setDemand_shop_type(int[] demand_shop_type) {
		this.demand_shop_type = demand_shop_type;
	}
	public String[] getDemand_shop_type_name() {
		return demand_shop_type_name;
	}
	public void setDemand_shop_type_name(String[] demand_shop_type_name) {
		this.demand_shop_type_name = demand_shop_type_name;
	}
	public int getDemand_type() {
		return demand_type;
	}
	public void setDemand_type(int demand_type) {
		this.demand_type = demand_type;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
