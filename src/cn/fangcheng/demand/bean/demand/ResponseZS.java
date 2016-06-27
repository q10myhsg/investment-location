package cn.fangcheng.demand.bean.demand;

public class ResponseZS {

	public int total=0;
	
	public ResponseDemandZS[] hits=null;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ResponseDemandZS[] getHits() {
		return hits;
	}

	public void setHits(ResponseDemandZS[] hits) {
		this.hits = hits;
	}
	
	
	
}
