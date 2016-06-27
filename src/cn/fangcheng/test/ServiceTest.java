package cn.fangcheng.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.fangcheng.ip.IPSeeker;
import cn.fangcheng.mybatis.po.LogLogin;
import cn.fangcheng.mybatis.po.PassportActivity;
import cn.fangcheng.service.BrandInterface;
import cn.fangcheng.service.CategoryInterface;
import cn.fangcheng.service.DemandInterface;
import cn.fangcheng.service.LogLoginInterface;
import cn.fangcheng.service.MallDataInterface;
import cn.fangcheng.service.MallInterface;
import cn.fangcheng.service.PassportActivityInterface;
import cn.fangcheng.service.PassportBrowseInterface;
import cn.fangcheng.service.PassportDemandnumInterface;
import cn.fangcheng.service.PassportInterface;
import cn.fangcheng.service.ProcedureInterface;
import cn.fangcheng.service.TagInterface;



import com.google.gson.Gson;
import com.mongodb.BasicDBList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-*.xml" })
public class ServiceTest {

	public Gson gson = new Gson();

	@Autowired
	TagInterface tag;
	@Autowired
	MallInterface mall;
	@Autowired
	DemandInterface demand;
	@Autowired
	BrandInterface brand;
	@Autowired
	CategoryInterface category;
	@Autowired
	MallDataInterface malldata;
	@Autowired
	LogLoginInterface logLogin;
	@Autowired
	PassportInterface passport;
	@Autowired
	PassportBrowseInterface pbrowse;
	@Autowired
	PassportDemandnumInterface passportdemand;
	@Autowired
	PassportActivityInterface activity;
	@Autowired
	ProcedureInterface procedure;
	
	
	@Test
	public void getOne() {
		// DBObject dbo = new BasicDBObject();
		// dbo.put("location.lng", new BasicDBObject(QueryOperators.NE, -1));
		// dbo.put("location.lng", -1);

		// tag.selectByPrimaryKey(1);
		// mall.selectByPrimaryKey(1);

		// demand.getDemandXZbyId("56207d47de833cb3208b4573");
		Gson gson = new Gson();
		// System.out.println(gons.toJson(demand.getDemandZSbyId("5596dd5125a4bc16b8ca28be")));
		// brand.getBrandById(12590);
		// category.selectByBrandid(10014);
		// malldata.selectByPrimaryKey(1);
		
		//tag.selectByPrimaryKey(1);
		//Mall mallaa = mall.selectByPrimaryKey(136);
		//System.out.println(gson.toJson(mallaa));
		//demand.getDemandXZbyId("55add956de833ce56b8b4569");
//		DemandZS zs = demand.getDemandZSbyId("5636affbde833cae038b458c");
//		System.out.println(gson.toJson(zs));
		//brand.getBrandById(10074);
		//category.selectByBrandid(10014);
		//malldata.selectByPrimaryKey(1);
		
		//统计用户登录地的
//		logLogin.dealdata("2015-10");

//		Passport pass = new Passport();
//		pass.setPassport_id(1);
//		pass.setLogin_city("22222");
//		passport.updateForLogincity(pass);
//		System.out.println(gson.toJson(passport.selectByPassportId(1)));
//		System.out.println(gson.toJson(passport.selectAllPassportId().size()));
		
//		//------------------------------------------------------------------------------------
//		String dealdate = "2015-12-01";
//		//new TimePrint().getTime("yyyy-MM-dd", 1)
//		//统计用户登录次数
//		logLogin.deleteByCtime(dealdate);
//		logLogin.groupByCtime(dealdate);
//		//------------------------------------------------------------------------------------
//		//用户浏览模块次数统计
//		pbrowse.deleteByDate(dealdate);
//		//获取ES统计脚本
//		String query = pbrowse.getQuery("./config/script/passportBrowse", dealdate);
//		String result = pbrowse.postEs("http://123.56.113.168:19200/logstash/logs/_search", query);
//		//System.out.println(result);
//		int num = pbrowse.dealdata(result, dealdate);
//		System.out.println(num);
//		//------------------------------------------------------------------------------------
//		//用户发布需求数量
//		passportdemand.deleteByctime(dealdate);
//		BasicDBList data = passportdemand.selectFromMongo(dealdate);
//		passportdemand.dealData(data, dealdate);
		
//		PassportActivity pass = new PassportActivity();
//		pass.setPassport_id(1898);
//		pass.setStart_time("2015-12-21");
//		pass = activity.selectActivity(pass);
//		System.out.println(gson.toJson(pass));
		procedure.runProcedure("2015-12-28");
	}

	public static void main(String[] args) {
		
//		System.out.println(System.getProperty("user.dir"));
//		Field[] fields = Tag.class.getDeclaredFields();
//		for(int i=0;i<fields.length;i++) {
//			boolean bool = fields[i].isAccessible();
//			System.out.println(bool);
//		}
		System.out.println(Math.pow(10,2));
		System.out.println(Math.log10(400));
//		System.out.println(Math.sqrt(2000));
		
	}

}
