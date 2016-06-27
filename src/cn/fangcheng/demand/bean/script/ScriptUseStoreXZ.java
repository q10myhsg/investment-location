package cn.fangcheng.demand.bean.script;

import cn.fangcheng.demand.bean.EsStoreXZBean;

public class ScriptUseStoreXZ{

	public EsStoreXZBean _source=null; 
	
	public int from=0;
	
	public int size=10;
	public long time=0L;
	
	public long now=System.currentTimeMillis()/86400000;

	public long timeEnd=2441437877000L;
	
	public int repast=0;
	
	public long getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(long timeEnd) {
		this.timeEnd = timeEnd;
	}

	public long getNow() {
		return now;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public EsStoreXZBean get_source() {
		return _source;
	}

	public void set_source(EsStoreXZBean _source) {
		this._source = _source;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getRepast() {
		return repast;
	}

	public void setRepast(int repast) {
		this.repast = repast;
	}
	
	
}
