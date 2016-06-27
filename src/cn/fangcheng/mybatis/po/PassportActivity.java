package cn.fangcheng.mybatis.po;

public class PassportActivity {
	
	private int passport_id;
	private String start_time;
	private float activity;
	private double activity_log10;
	
	public double getActivity_log10() {
		return activity_log10;
	}
	public void setActivity_log10(double activity_log10) {
		this.activity_log10 = activity_log10;
	}
	public int getPassport_id() {
		return passport_id;
	}
	public void setPassport_id(int passport_id) {
		this.passport_id = passport_id;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public float getActivity() {
		return activity;
	}
	public void setActivity(float activity) {
		this.activity = activity;
	}
}
