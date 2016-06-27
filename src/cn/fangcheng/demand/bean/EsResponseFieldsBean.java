package cn.fangcheng.demand.bean;

/**
 * 从es中返回的数据格式
 * @author Administrator
 *
 */
public class EsResponseFieldsBean {

	public String[] demandId=null;
	
	public String[] demand_desc=null;
	
	public int[] bid;
	
	public String[] bid_name;
	
	public String[] category_name;
	
	public int[] area_id;
	
	public int[] demand_show_mobile;
	
	public int[] demand_level;
	
	public int[] demand_status;
	/**
	 * 不允许出现复合结构获取es数据
	 */
	//public int[] size.min;
	
	public String[] tag_dot_preferredProperty;
	
	public String[] tag_dot_preferredPropertyAll;
	
	public String[] tag_dot_shopSpecifications;
	
	public String[] tag_dot_shopSpecificationsAll;
	
	public int[] tag_dot_termCooperation;
	
	public int[] tag_dot_areaDemand_dot_lower;
	
	public int[] tag_dot_areaDemand_dot_upper;
		
	public int[] tag_dot_shopArea_dot_lower;
	
	public int[] tag_dot_shopArea_dot_upper;
	
	
	
	public String[] getDemand_desc() {
		return demand_desc;
	}

	public void setDemand_desc(String[] demand_desc) {
		this.demand_desc = demand_desc;
	}

	public String[] getTag_dot_preferredProperty() {
		return tag_dot_preferredProperty;
	}

	public void setTag_dot_preferredProperty(String[] tag_dot_preferredProperty) {
		this.tag_dot_preferredProperty = tag_dot_preferredProperty;
	}

	public int[] getBid() {
		return bid;
	}

	public void setBid(int[] bid) {
		this.bid = bid;
	}

	public String[] getBid_name() {
		return bid_name;
	}

	public void setBid_name(String[] bid_name) {
		this.bid_name = bid_name;
	}

	public String[] getDemandId() {
		return demandId;
	}

	public void setDemandId(String[] demandId) {
		this.demandId = demandId;
	}
	

	public String[] getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String[] category_name) {
		this.category_name = category_name;
	}

	public int[] getArea_id() {
		return area_id;
	}

	public void setArea_id(int[] area_id) {
		this.area_id = area_id;
	}

	public int[] getDemand_show_mobile() {
		return demand_show_mobile;
	}

	public void setDemand_show_mobile(int[] demand_show_mobile) {
		this.demand_show_mobile = demand_show_mobile;
	}

	public int[] getDemand_level() {
		return demand_level;
	}

	public void setDemand_level(int[] demand_level) {
		this.demand_level = demand_level;
	}
	

	public String[] getTag_dot_preferredPropertyAll() {
		return tag_dot_preferredPropertyAll;
	}

	public void setTag_dot_preferredPropertyAll(
			String[] tag_dot_preferredPropertyAll) {
		this.tag_dot_preferredPropertyAll = tag_dot_preferredPropertyAll;
	}

	public String[] getTag_dot_shopSpecifications() {
		return tag_dot_shopSpecifications;
	}

	public void setTag_dot_shopSpecifications(String[] tag_dot_shopSpecifications) {
		this.tag_dot_shopSpecifications = tag_dot_shopSpecifications;
	}

	public int[] getTag_dot_termCooperation() {
		return tag_dot_termCooperation;
	}

	public void setTag_dot_termCooperation(int[] tag_dot_termCooperation) {
		this.tag_dot_termCooperation = tag_dot_termCooperation;
	}
	

	public int[] getTag_dot_areaDemand_dot_lower() {
		return tag_dot_areaDemand_dot_lower;
	}

	public void setTag_dot_areaDemand_dot_lower(int[] tag_dot_areaDemand_dot_lower) {
		this.tag_dot_areaDemand_dot_lower = tag_dot_areaDemand_dot_lower;
	}

	public int[] getTag_dot_areaDemand_dot_upper() {
		return tag_dot_areaDemand_dot_upper;
	}

	public void setTag_dot_areaDemand_dot_upper(int[] tag_dot_areaDemand_dot_upper) {
		this.tag_dot_areaDemand_dot_upper = tag_dot_areaDemand_dot_upper;
	}

	public int[] getTag_dot_shopArea_dot_lower() {
		return tag_dot_shopArea_dot_lower;
	}

	public void setTag_dot_shopArea_dot_lower(int[] tag_dot_shopArea_dot_lower) {
		this.tag_dot_shopArea_dot_lower = tag_dot_shopArea_dot_lower;
	}

	public int[] getTag_dot_shopArea_dot_upper() {
		return tag_dot_shopArea_dot_upper;
	}

	public void setTag_dot_shopArea_dot_upper(int[] tag_dot_shopArea_dot_upper) {
		this.tag_dot_shopArea_dot_upper = tag_dot_shopArea_dot_upper;
	}

	public int[] getDemand_status() {
		return demand_status;
	}

	public void setDemand_status(int[] demand_status) {
		this.demand_status = demand_status;
	}

	public String[] getTag_dot_shopSpecificationsAll() {
		return tag_dot_shopSpecificationsAll;
	}

	public void setTag_dot_shopSpecificationsAll(
			String[] tag_dot_shopSpecificationsAll) {
		this.tag_dot_shopSpecificationsAll = tag_dot_shopSpecificationsAll;
	}
	
}
