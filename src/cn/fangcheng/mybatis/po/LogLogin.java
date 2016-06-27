package cn.fangcheng.mybatis.po;

import java.util.Date;

public class LogLogin {
	
    private int log_login_id;

    private Date log_login_ctime;
    
    private int passport_id;

    private String log_login_ip;
    
    private int login_num;
    
    private String exec_date;
    
    private double login_Percent;
    
    private String login_city;
    
	public String getExec_date() {
		return exec_date;
	}

	public void setExec_date(String exec_date) {
		this.exec_date = exec_date;
	}

	public double getLogin_Percent() {
		return login_Percent;
	}

	public void setLogin_Percent(double login_Percent) {
		this.login_Percent = login_Percent;
	}

	public String getLogin_city() {
		return login_city;
	}

	public void setLogin_city(String login_city) {
		this.login_city = login_city;
	}

	public int getLogin_num() {
		return login_num;
	}

	public void setLogin_num(int login_num) {
		this.login_num = login_num;
	}

	public int getLog_login_id() {
		return log_login_id;
	}

	public void setLog_login_id(int log_login_id) {
		this.log_login_id = log_login_id;
	}

	public Date getLog_login_ctime() {
		return log_login_ctime;
	}

	public void setLog_login_ctime(Date log_login_ctime) {
		this.log_login_ctime = log_login_ctime;
	}

	public int getPassport_id() {
		return passport_id;
	}

	public void setPassport_id(int passport_id) {
		this.passport_id = passport_id;
	}

	public String getLog_login_ip() {
		return log_login_ip;
	}

	public void setLog_login_ip(String log_login_ip) {
		this.log_login_ip = log_login_ip;
	}
}