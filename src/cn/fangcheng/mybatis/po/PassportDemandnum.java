package cn.fangcheng.mybatis.po;

public class PassportDemandnum {
    private int id;

    private int passport_id;
    
    private String exec_date;

	private int demand_num;

    private int demand_type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getDemand_num() {
		return demand_num;
	}

	public void setDemand_num(int demand_num) {
		this.demand_num = demand_num;
	}

	public int getDemand_type() {
		return demand_type;
	}

	public void setDemand_type(int demand_type) {
		this.demand_type = demand_type;
	}
    
}