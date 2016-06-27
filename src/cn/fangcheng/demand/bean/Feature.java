package cn.fangcheng.demand.bean;

/**
 * feature 通用类
 * @author Administrator
 *
 */
public class Feature implements BeanFactor{

	public String _id;
	
	public int bid;

	

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
}
