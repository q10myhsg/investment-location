package cn.fangcheng.demand.service.other.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.service.other.StorageService;
import cn.fangcheng.demand.tool.JavaNetURLRESTFullClient;
import cn.fangcheng.demand.tool.TimePrint;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;
import cn.fangcheng.mybatis.po.PassportActivity;
import cn.fangcheng.service.BrandInterface;
import cn.fangcheng.service.DemandInterface;
import cn.fangcheng.service.MallInterface;
import cn.fangcheng.service.PassportActivityInterface;
@Service
public class Storage implements StorageService{
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(Storage.class);
	/**
	 * get方法
	 */
	public static final String GET="GET";
	/**
	 * put方法
	 */
	public static final String PUT="PUT";
	
	public static final String POST="POST";
	
	public static final String DELETE="DELETE";
	
	
	@Autowired
	MallInterface mm=null;//new MallMapperImpl();
	@Autowired
	DemandInterface dm=null;//new DemandMapperImpl();
	@Autowired
	BrandInterface bm=null;//new BrandMapperImpl();
	@Autowired
	PassportActivityInterface pass;
	
//	@Override
//	public String change(String esJson){
//		ObjectNode obj=JsonUtil.parse(esJson);
//		return obj.toString();
//	}
//	
//	public String changeArray(String esJson){
//		ArrayNode array=JsonUtil.parseArray(esJson);
//		return array.toString();
//	}

	
	@Override
	public String search(int typeCategory,String type,String alias) throws Exception {
		// TODO Auto-generated method stub
		String str= JavaNetURLRESTFullClient.runAndGetText(typeCategory,type,GET,null,alias);
		//logger.info("get:es:"+ str);
		return str;
	}

	@Override
	public String search(int typeCategory,String type, String json,String alias)  throws Exception{
		// TODO Auto-generated method stub
		String str=JavaNetURLRESTFullClient.runAndGetText(typeCategory,type,GET,json,alias);
		//logger.info("get:es:"+ str);
		return str;
	}

	@Override
	public String search(int typeCategory,Object paramsKey, Object paramsValue)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search(int typeCategory,String type, String json, String groovyFile,String alias)  throws Exception{
		// TODO Auto-generated method stub
		return JavaNetURLRESTFullClient.runAndGetText(typeCategory,type,GET,json.replaceAll("groovyFile",groovyFile),alias);
	}

	@Override
	public boolean update(int typeCategory,String type, String json,String alias) throws Exception {
		// TODO Auto-generated method stub
		return JavaNetURLRESTFullClient.runAndGetStatus(typeCategory,type,PUT,json,alias);
	}

	@Override
	public boolean delete(int typeCategory,String type,String alias)  throws Exception{
		// TODO Auto-generated method stub
		return JavaNetURLRESTFullClient.runAndGetStatus(typeCategory,type,DELETE,null,alias);
	}

	@Override
	public boolean delete(int typeCategory,String type, String json,String alias)  throws Exception{
		// TODO Auto-generated method stub
		return JavaNetURLRESTFullClient.runAndGetStatus(typeCategory,type,DELETE,json,alias);
	}

	@Override
	public PassportActivity getUserFeatureSourceByUserId(int userId)  throws Exception{
		// TODO Auto-generated method stub
		PassportActivity pa = new PassportActivity();
		pa.setPassport_id(userId);
		pa.setStart_time(new TimePrint().getTime("yyyy-MM-dd", 1));
		return pass.selectActivity(pa);
	}

	@Override
	public Mall getMallFeatureSourceByBid(int bid) throws Exception {
		// TODO Auto-generated method stub
		return mm.selectByPrimaryKey(bid);
	}

	@Override
	public Brand getBrandFeatureSourceByBid(int bid, String featureRef)  throws Exception{
		// TODO Auto-generated method stub
		return bm.getBrandById(bid);
	}
	

	@Override
	public boolean updateUserFeatureSourceByUserId(int userId,String json) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean deleteUserFeatureByUserId(int userId) throws Exception{
		return false;
	}

	@Override
	public String getUserFeatureSourceByUserId(int userId, String jsonRef)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFillMatchDemand(int typeCategory) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFillSimDemand(int typeCategory)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DemandXZ getDemandXZFeatureSourceByDocId(String docId) throws Exception {
		// TODO Auto-generated method stub
		return dm.getDemandXZbyId(docId);
	}

	@Override
	public DemandZS getDemandZSFeatureSourceByDocId(String docId)  throws Exception{
		// TODO Auto-generated method stub
		return dm.getDemandZSbyId(docId);
	}

	@Override
	public Brand getBrandFeatureSourceByBid(int bid)  throws Exception{
		// TODO Auto-generated method stub
		return bm.getBrandById(bid);
	}

	@Override
	public Mall getMallFeatureSourceByBid(int bid, String featureRef) throws Exception {
		// TODO Auto-generated method stub
		return mm.selectByPrimaryKey(bid);
	}

	@Override
	public boolean post(int typeCategory, String type, String json,String alias)  throws Exception{
		// TODO Auto-generated method stub
		return JavaNetURLRESTFullClient.runAndGetStatus(typeCategory,type,POST,json,alias);
	}

}
