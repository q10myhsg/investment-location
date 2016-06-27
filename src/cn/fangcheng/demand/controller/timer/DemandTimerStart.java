package cn.fangcheng.demand.controller.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.fangcheng.demand.servlet.InitServlet;
import cn.fangcheng.demand.tool.JavaNetURLRESTFullClient;

/**
 * 招商选址需求定时执行程序
 * 
 * @author Administrator
 *
 */
public class DemandTimerStart {
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(DemandTimerStart.class);
	
	
	
	public void initJob() throws Exception{
		// 需要先清除所有数据 并新建mapping
		//使用http调用请求
		logger.info("周期程序启动:"+this.getClass().getSimpleName());
		//logger.info("url:"+JavaNetURLRESTFullClient.thisURL);
		JavaNetURLRESTFullClient.post2(200000,200000,InitServlet.thisURL+"/rest/demand/init", "GET",null,JavaNetURLRESTFullClient.code);
	}

}
