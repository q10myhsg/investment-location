package cn.fangcheng.mybatis.po;

public class PassportBrowse {
	
	private int passport_id;
	private String exec_date;
	private int browsetotalnum;
	private int demandshownum;
	private int shopsearchnum;
	private int brandnum;
	private int mallnum;
	private int searchnum;
	
	public int getPassport_id() {
		return passport_id;
	}
	public void setPassport_id(int passport_id) {
		this.passport_id = passport_id;
	}
	public String getExec_date() {
		return exec_date;
	}
	public void setExec_date(String exec_date) {
		this.exec_date = exec_date;
	}
	public int getBrowsetotalnum() {
		return browsetotalnum;
	}
	public void setBrowsetotalnum(int browsetotalnum) {
		this.browsetotalnum = browsetotalnum;
	}
	public int getDemandshownum() {
		return demandshownum;
	}
	public void setDemandshownum(int demandshownum) {
		this.demandshownum = demandshownum;
	}
	public int getShopsearchnum() {
		return shopsearchnum;
	}
	public void setShopsearchnum(int shopsearchnum) {
		this.shopsearchnum = shopsearchnum;
	}
	public int getBrandnum() {
		return brandnum;
	}
	public void setBrandnum(int brandnum) {
		this.brandnum = brandnum;
	}
	public int getMallnum() {
		return mallnum;
	}
	public void setMallnum(int mallnum) {
		this.mallnum = mallnum;
	}
	public int getSearchnum() {
		return searchnum;
	}
	public void setSearchnum(int searchnum) {
		this.searchnum = searchnum;
	}
}
