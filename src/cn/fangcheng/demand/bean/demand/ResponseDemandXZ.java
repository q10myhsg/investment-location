package cn.fangcheng.demand.bean.demand;


public class ResponseDemandXZ {
	/**
	 * 得分
	 */
	public double _score;
	public String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	// public DemandXZ _source;
	public double get_score() {
		return _score;
	}

	public void set_score(double _score) {
		this._score = _score;
	}
	// public DemandXZ get_source() {
	// return _source;
	// }
	// public void set_source(DemandXZ _source) {
	// this._source = _source;
	// }

}
