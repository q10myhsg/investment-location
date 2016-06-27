package cn.fangcheng.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBList;

import cn.fangcheng.service.LogLoginInterface;
import cn.fangcheng.service.PassportBrowseInterface;
import cn.fangcheng.service.PassportDemandnumInterface;
import cn.fangcheng.service.PassportInterface;
import cn.fangcheng.service.ProcedureInterface;
import cn.fangcheng.tool.TimePrint;

public class SingleRunTest {

	private static ApplicationContext context;
	@Autowired
	LogLoginInterface logLogin;
	@Autowired
	PassportInterface passport;
	@Autowired
	PassportBrowseInterface pbrowse;
	@Autowired
	PassportDemandnumInterface passportdemand;
	@Autowired
	ProcedureInterface procedure;
	
	public static String address = "http://123.56.113.168:19200/logstash/logs/_search";
	public static String dealdate = null;
	
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext(new String[] { "classpath:spring/applicationContext-dao.xml",
				"classpath:spring/applicationContext-mongodb.xml", "classpath:spring/applicationContext-service.xml",
				"classpath:spring/applicationContext-transaction.xml", "classpath:spring/springmvc.xml","classpath:spring/applicationContext.xml",
				"classpath:mybatis/sqlMapConfig.xml","classpath:spring/springmvc.xml"});
		System.out.println("程序开始执行..................");
		if(args.length>0){
			dealdate = args[0];
			System.out.println("手动执行程序，时间为................." + args[0]);
			context.getBean(SingleRunTest.class).dealdata();
		}
		//context.getBean(SingleRunTest.class).dealdata();
		//System.out.println("结束。。。。。。。。。。。。。。。。。。。。");
	}
	
	public void dealdata(){
		if(dealdate == null){
			dealdate = new TimePrint().getTime("yyyy-MM-dd", 1);
			System.out.println("周期性统计数据时间-------------------------------"+dealdate);
		}else{
			System.out.println("周期性统计数据时间..............................."+dealdate);
		}
		
		//统计用户登录地的
		if(dealdate.endsWith("-01")){
			logLogin.dealdata(dealdate.substring(0, 7));
		}
		//------------------------------------------------------------------------------------
		//统计用户登录次数
		logLogin.deleteByCtime(dealdate);
		logLogin.groupByCtime(dealdate);
		//------------------------------------------------------------------------------------
		//用户浏览模块次数统计
		pbrowse.deleteByDate(dealdate);
		//获取ES统计脚本
		String query = pbrowse.getQuery("./config/script/passportBrowse", dealdate);
		String result = pbrowse.postEs(address, query);
		//System.out.println(result);
		int num = pbrowse.dealdata(result, dealdate);
		//------------------------------------------------------------------------------------
		//用户发布需求数量
		passportdemand.deleteByctime(dealdate);
		BasicDBList data = passportdemand.selectFromMongo(dealdate);
		passportdemand.dealData(data, dealdate);
		//开始调用存储过程
		procedure.runProcedure(dealdate);
		dealdate = null;
	}
}
