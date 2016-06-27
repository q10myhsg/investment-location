package cn.fangcheng.demand.bean.demand;


import cn.fangcheng.demand.bean.EsResponseFieldsUsedBean;

/**
 * 返回页面的实体类
 * @author Administrator
 *
 */
public class ResponseDemand extends EsResponseFieldsUsedBean{

	public String _index=null;
	/**
	 * 得分
	 */
	public double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String get_index() {
		return _index;
	}
	public void set_index(String _index) {
		this._index = _index;
	}
	
	
	
}
