package cn.fangcheng.mybatis.po;

public class Tag {
	/**
	 * 首选物业36
	 */
	private int[] group_36;
	//private String[] preferredProperty;
	private String[] preferredPropertyAll;
	/**
	 * 店铺类型116
	 */
	//private String[] shopType;
	/**
	 * 店铺规格46
	 */
	private int[] group_46;
	//private String[] shopSpecifications;
	private String[] shopSpecificationsAll;
	/**
	 * 合作期限40
	 */
	private int[] group_40;
	private int[] termCooperation;
	/**
	 * 面积需求41
	 */
	private AreaDemand group_41;
	private AreaDemand areaDemand;
	/**
	 * 租金预算42
	 */
	//private BudgetRent budgetRent;
	/**
	 * 店铺面积126
	 */
	private ShopArea group_126;
	private ShopArea shopArea;
	
	
	public int[] getGroup_36() {
		return group_36;
	}
	public void setGroup_36(int[] group_36) {
		this.group_36 = group_36;
	}
	public int[] getGroup_46() {
		return group_46;
	}
	public void setGroup_46(int[] group_46) {
		this.group_46 = group_46;
	}
	public int[] getGroup_40() {
		return group_40;
	}
	public void setGroup_40(int[] group_40) {
		this.group_40 = group_40;
	}
	public AreaDemand getGroup_41() {
		return group_41;
	}
	public void setGroup_41(AreaDemand group_41) {
		this.group_41 = group_41;
	}
	public ShopArea getGroup_126() {
		return group_126;
	}
	public void setGroup_126(ShopArea group_126) {
		this.group_126 = group_126;
	}
	public String[] getPreferredPropertyAll() {
		return preferredPropertyAll;
	}
	public void setPreferredPropertyAll(String[] preferredPropertyAll) {
		this.preferredPropertyAll = preferredPropertyAll;
	}
	public String[] getShopSpecificationsAll() {
		return shopSpecificationsAll;
	}
	public void setShopSpecificationsAll(String[] shopSpecificationsAll) {
		this.shopSpecificationsAll = shopSpecificationsAll;
	}
	public ShopArea getShopArea() {
		return shopArea;
	}
	public void setShopArea(ShopArea shopArea) {
		this.shopArea = shopArea;
	}
//	public String[] getPreferredProperty() {
//		return preferredProperty;
//	}
//	public void setPreferredProperty(String[] preferredProperty) {
//		this.preferredProperty = preferredProperty;
//	}
//	public String[] getShopType() {
//		return shopType;
//	}
//	public void setShopType(String[] shopType) {
//		this.shopType = shopType;
//	}
//	public String[] getShopSpecifications() {
//		return shopSpecifications;
//	}
//	public void setShopSpecifications(String[] shopSpecifications) {
//		this.shopSpecifications = shopSpecifications;
//	}
	public int[] getTermCooperation() {
		return termCooperation;
	}
	public void setTermCooperation(int[] termCooperation) {
		this.termCooperation = termCooperation;
	}
	public AreaDemand getAreaDemand() {
		return areaDemand;
	}
	public void setAreaDemand(AreaDemand areaDemand) {
		this.areaDemand = areaDemand;
	}
//	public BudgetRent getBudgetRent() {
//		return budgetRent;
//	}
//	public void setBudgetRent(BudgetRent budgetRent) {
//		this.budgetRent = budgetRent;
//	}
}
