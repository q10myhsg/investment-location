package cn.fangcheng.demand.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.demand.service.extra.DemandExService;
import cn.fangcheng.demand.service.extra.UserExService;
import cn.fangcheng.demand.service.other.StorageService;
import cn.fangcheng.demand.servlet.InitServlet;
import cn.fangcheng.demand.tool.JavaNetURLRESTFullClient;
import cn.fangcheng.demand.tool.JsonUtil;
import cn.fangcheng.service.DemandInterface;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-*.xml" })
public class Xinguopeng_Test {
	
	public Gson gson = new Gson();
	
	@Autowired
	public DemandExService des;
	@Autowired
	public UserExService ues;
	@Autowired
	public MongoTemplate admin;
	@Autowired
	public StorageService ss;
	@Autowired
	public DemandInterface dis;
	
	public static void main(String[] args){
		try {
			String json = "{\"passport\":{\"passport_id\":\"31\",\"passport_first_name\":\"徐\",\"passport_last_name\":\"盈\",\"passport_name\":\"徐盈\",\"passport_sex\":\"1\",\"passport_utime\":\"2015-04-10 09:48:22\",\"passport_ctime\":\"2015-01-03 21:59:30\",\"passport_vtime\":null,\"passport_email\":\"fengshengqi1@fangcheng.cn\",\"passport_mobile\":\"18600690920\",\"passport_password\":\"3a383164e61a692829e5ad8e31ed04b91f7ee91bce5fbb384476a9d6268d5c22\",\"passport_type\":\"4\",\"passport_picture\":\"\",\"passport_job_title\":\"开发渠道高级经理\",\"passport_job_area\":\"全国\",\"area_id\":\"86999030\",\"passport_business_card\":\"0927d4dba05beb3461.jpg\",\"passport_idcard\":\"\",\"passport_idcard_photo\":\"\",\"passport_weixin\":\"\",\"passport_weixin_open_id\":\"\",\"passport_weixin_push\":\"1\",\"passport_ip\":\"\",\"passport_id_recommend\":\"0\",\"passport_flag\":\"1\",\"passport_status_desc\":\"无名片\",\"passport_company\":\"test\",\"category_ids_other\":\"\",\"category_ids\":[\"30000\"],\"passport_in_blacklist\":\"0\",\"passport_status\":\"1\",\"passport_status_before\":\"2\",\"passport_send_sms\":\"0\",\"passport_edit_option\":\"\",\"passport_private_mode\":\"0\",\"passport_msg_push_private\":\"1\",\"passport_msg_push_dynamic\":\"1\",\"passport_msg_push_demand\":\"1\"},\"demand\":{\"demand_ctime\":\"2015-12-24 14:48:26\",\"demand_utime\":\"2015-12-24 14:48:26\",\"passport_id\":31,\"mall_id\":102,\"mall_name\":\"ccccccccccccccccc北京SKP\",\"area_id\":[86999030],\"demand_desc\":\"123\",\"demand_show_mobile\":1,\"demand_level\":1,\"demand_status\":1,\"category_ids\":[30200,30301,40000],\"category_ids_other\":\"\",\"demand_shop_type\":[3,2,1],\"demand_type\":2,\"passport_type\":4,\"passport_company\":\"test\",\"allow_moible\":1,\"weixin_push\":1,\"tag\":{\"group_126\":{\"lower\":100,\"upper\":3300}},\"_id\":\"567b953ae08a1f6c14000029\"},\"type\":\"add\"}";
			//System.out.println(json);
			String temp = JavaNetURLRESTFullClient.post2(3000, 5000, "http://192.168.1.19:80/InvestmentLocation/rest/demand/add", "POST", json, JavaNetURLRESTFullClient.code);
			//String temp = JavaNetURLRESTFullClient.post2(3000, 5000, "http://192.168.1.11/InvestmentLocation/rest/demand/add", "POST", json, JavaNetURLRESTFullClient.code);
			System.out.println("aaaaaaaaaaaaaaaaaaa:"+temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
