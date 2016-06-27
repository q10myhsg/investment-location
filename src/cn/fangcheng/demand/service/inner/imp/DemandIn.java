package cn.fangcheng.demand.service.inner.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.bean.EsResponseBean;
import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.demand.bean.demand.ResponseDemand;
import cn.fangcheng.demand.bean.demand.ResponseDemandXZ;
import cn.fangcheng.demand.bean.demand.ResponseDemandZS;
import cn.fangcheng.demand.bean.demand.ResponseXZ;
import cn.fangcheng.demand.bean.demand.ResponseZS;
import cn.fangcheng.demand.bean.script.Script;
import cn.fangcheng.demand.service.function.FunctionFactoryService;
import cn.fangcheng.demand.service.inner.DemandInService;
import cn.fangcheng.demand.service.other.EsQueryService;
import cn.fangcheng.demand.service.other.StorageService;
import cn.fangcheng.demand.tool.JsonUtil;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class DemandIn implements DemandInService {

	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(DemandIn.class);
	@Autowired
	StorageService ss;
	@Autowired
	EsQueryService eqs;

	

	@Override
	public int getDemandCountByBid(int bid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDemandCountByParams(int type,Object paramsKey, Object paramsValue)  throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateDemandFeature(int type,String docId,EsStoreZSBean feature,String alias)  throws Exception{
		// TODO Auto-generated method stub
		if (feature == null) {
			logger.info("feature is null");
			return false;
		} else {
		}
		return ss.update(type,docId, JsonUtil.getJsonStr(feature),alias);
	}
	
	@Override
	public boolean updateDemandFeature(int type,String docId,EsStoreXZBean feature,String alias)  throws Exception{
		// TODO Auto-generated method stub
		if (feature == null) {
			logger.info("feature is null");
			return false;
		} else {
		}
		return ss.update(type,docId, JsonUtil.getJsonStr(feature),alias);
	}

	@Override
	public boolean deleteDemandByParam(int type,Object paramsKey, Object paramsValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDemandByDocId(int type,String docId,String alias)  throws Exception{
		// TODO Auto-generated method stub
		return ss.delete(type,docId,null,alias);
	}

	@Override
	public boolean deleteDemandByBid(int bid) throws Exception {
		// TODO Auto-generated method stub
		String method = Thread.currentThread().getStackTrace()[1]
				.getMethodName();
		return ss.delete(bid,null, Script.getScript(method,bid),null);
	}

	@Override
	public Object searchMatchDemand(RequestDemand demand,DemandZS demandFeature,
			UserFeature userFeature, Mall feature)  throws Exception{
		// TODO Auto-generated method stub
		return searchMatchDemand(demand,demandFeature, userFeature, feature, demand.from,
				demand.size);
	}
	
	@Override
	public Object searchMatchDemand(RequestDemand demand,DemandXZ demandFeature,
			UserFeature userFeature, Brand feature) throws Exception {
		// TODO Auto-generated method stub
		return searchMatchDemand(demand,demandFeature, userFeature, feature, demand.from,
				demand.size);
	}

	@Override
	public Object searchMatchDemand(RequestDemand demand,DemandZS demandFeature,
			UserFeature userFeature, Mall feature, int from, int size)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(StaticBean.relIndex(demand.type),null,
				eqs.getMatchString(demand,demandFeature, userFeature, feature, from, size),null);
		return changeSourceStringToResponseDemand(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,esJson);
	}
	@Override
	public Object searchMatchDemand(RequestDemand demand,DemandXZ demandFeature,
			UserFeature userFeature, Brand feature, int from, int size) throws Exception {
		// TODO Auto-generated method stub
		String esJson = ss.search(StaticBean.relIndex(demand.type),null,
				eqs.getMatchString(demand,demandFeature, userFeature, feature, from, size),null);
		return changeSourceStringToResponseDemand(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,esJson);
	}

	@Override
	public Object searchMatchDemand(RequestDemand demand,DemandZS demandFeature,
			UserFeature userFeature, Mall feature, int from, int size,
			FunctionFactoryService function)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null,
				eqs.getMatchString(demand,demandFeature, userFeature, feature, from, size),
				function.getDefaultString(),null);
		return changeSourceStringToResponseDemand(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,esJson);
	}
	@Override
	public Object searchMatchDemand(RequestDemand demand,DemandXZ demandFeature,
			UserFeature userFeature, Brand feature, int from, int size,
			FunctionFactoryService function)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null,
				eqs.getMatchString(demand,demandFeature, userFeature, feature, from, size),
				function.getDefaultString(),null);
		return changeSourceStringToResponseDemand(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,esJson);
	}

	@Override
	public Object searchMatchDemand(RequestDemand demand,DemandZS demandFeature,
			UserFeature userFeature, Mall feature, int from, int size,
			String groovyFile)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null,
				eqs.getMatchString(demand,demandFeature, userFeature, feature, from, size),
				groovyFile,null);
		return changeSourceStringToResponseDemand(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,esJson);
	}
	
	@Override
	public Object searchMatchDemand(RequestDemand demand,DemandXZ demandFeature,
			UserFeature userFeature, Brand feature, int from, int size,
			String groovyFile) throws Exception {
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null,
				eqs.getMatchString(demand,demandFeature, userFeature, feature, from, size),
				groovyFile,null);
		return changeSourceStringToResponseDemand(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,esJson);
	}

	@Override
	public Object getFillMatchDemand(int type)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.getFillMatchDemand(type);
		if (esJson == null) {
			return null;
		}
		Object[] list=null;
		if(type==StaticBean.MALL_TYPE){
			list = JsonUtil.getArrFromJsonArrStr(
					esJson, ResponseDemandXZ.class);
		}else{
			list = JsonUtil.getArrFromJsonArrStr(
				esJson, ResponseDemandZS.class);
		}
		return list;
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,DemandZS demandFeature,
			UserFeature userFeature, Mall feature) throws Exception {
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null, eqs.getSimString(demand,demandFeature, userFeature,
				feature, demand.from, demand.size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}
	
	@Override
	public Object searchSimDemand(RequestDemand demand,DemandXZ demandFeature,
			UserFeature userFeature, Brand feature)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null, eqs.getSimString(demand,demandFeature, userFeature,
				feature, demand.from, demand.size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,DemandZS demandFeature,
			UserFeature userFeature, Mall feature, int from, int size)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null,
				eqs.getSimString(demand,demandFeature, userFeature, feature, from, size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}
	@Override
	public Object searchSimDemand(RequestDemand demand,DemandXZ demandFeature,
			UserFeature userFeature, Brand feature, int from, int size)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null,
				eqs.getSimString(demand,demandFeature, userFeature, feature, from, size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,DemandZS demandFeature,
			UserFeature userFeature, Mall feature, int from, int size,
			FunctionFactoryService function)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null, eqs.getSimString(demand,demandFeature, userFeature,
				feature, demand.from, demand.size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}
	
	@Override
	public Object searchSimDemand(RequestDemand demand,DemandXZ demandFeature,
			UserFeature userFeature, Brand feature, int from, int size,
			FunctionFactoryService function)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null, eqs.getSimString(demand,demandFeature, userFeature,
				feature, demand.from, demand.size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,DemandZS demandFeature,
			UserFeature userFeature, Mall feature, int from, int size,
			String groovyFile)  throws Exception{
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null, eqs.getSimString(demand,demandFeature, userFeature,
				feature, demand.from, demand.size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}
	@Override
	public Object searchSimDemand(RequestDemand demand,DemandXZ demandFeature,
			UserFeature userFeature, Brand feature, int from, int size,
			String groovyFile)  throws Exception{
		String esJson = ss.search(demand.type==StaticBean.MALL_TYPE?StaticBean.BRAND_TYPE:StaticBean.MALL_TYPE,null, eqs.getSimString(demand,demandFeature, userFeature,
				feature, demand.from, demand.size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}

	@Override
	public Object getFillSimDemand(int type)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.getFillSimDemand(type);
		if (esJson == null) {
			return null;
		}
		Object[] list=null;
		if(type==StaticBean.MALL_TYPE){
			list = JsonUtil.getArrFromJsonArrStr(
					esJson, ResponseDemandZS.class);
		}else{
			list = JsonUtil.getArrFromJsonArrStr(
				esJson, ResponseDemandXZ.class);
		}
		return list;
	}

	@Override
	public Object changeStringToResponseDemand(String json) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object changeSourceStringToResponseDemand(int type,String esJson)  throws Exception{
		// TODO Auto-generated method stub
		//logger.info("esJson:"+ esJson);
		ObjectNode node = JsonUtil.parse(esJson);
		//logger.info("obj:" + node);
		//logger.info("val:" + node.get("hits").toString());
		//logger.info("hits:" + node.get("hits").get("hits").toString());
		//logger.info("hitsTrans:"+ InitServlet.getTransportRel(node.get("hits").get("hits").toString()));
//		Gson gson=new Gson();
//		
//		List<EsResponseBean> list=(List<EsResponseBean>)gson.fromJson(node.get("hits").get("hits")
//						.toString(), EsResponseBean.class);
		

//		List<EsResponseBean> list = JsonUtil.getDtoArrFromJsonArrListStr(
//				InitServlet.getTransportRel(node.get("hits").get("hits")
//						.toString()), EsResponseBean.class);
//		List<ResponseDemand> listRe = new ArrayList<ResponseDemand>();
		
//		for (EsResponseBean bean : list) {
//			ResponseDemand de = bean.transportToResponseDemand();
//			listRe.add(de);
//		}
		String temp=node.get("hits").get("hits")
				.toString();
		int count=Integer.parseInt(node.get("hits").get("total").toString());
		ArrayNode arraynode=JsonUtil.parseArray(temp);
		
		for(int i=0;i<arraynode.size();i++)
		{
			((ObjectNode)arraynode.get(i)).remove(StaticBean.remove);
//			ObjectNode source=((ObjectNode)((ObjectNode)arraynode.get(i)).get("_source"));
//			source.remove(StaticBean._sourceRemove);
//			((ObjectNode)source.get("tag")).remove(StaticBean.tagRemove);
		}		
//		logger.info("Treans:"+arraynode.toString());
		Object re=null;
		if(type==StaticBean.MALL_TYPE){
			ResponseZS te=new ResponseZS();
			te.hits=(ResponseDemandZS[])JsonUtil.getDtoFromJsonObjStr(arraynode.toString(), ResponseDemandZS[].class);
			te.total=count;
			re=te;
		}else{
			ResponseXZ te=new ResponseXZ();
			te.hits=(ResponseDemandXZ[])JsonUtil.getDtoFromJsonObjStr(arraynode.toString(), ResponseDemandXZ[].class);
			te.total=count;
			re=te;
		}
		return re;
	}

	@Override
	public Object[] mixtrueMethod(List<ResponseDemand> response1,
			List<ResponseDemand> response2)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] mixtrueMethod(List<ResponseDemand> response1,
			List<ResponseDemand> response2, FunctionFactoryService func)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DemandXZ getDemandXZFeatureSourceByDocId(int type, String docId)  throws Exception{
		// TODO Auto-generated method stub
		return ss.getDemandXZFeatureSourceByDocId(docId);
	}

	@Override
	public EsStoreXZBean getDemandXZFeatureByDocId(int type, String docId)  throws Exception{
		// TODO Auto-generated method stub
		String json=ss.search(type, docId,null);
		if(json==null){
			return null;
		}
		ObjectNode obj=JsonUtil.parse(json);
		//logger.info("one:"+obj.get("_source").toString());
		EsStoreXZBean xz=(EsStoreXZBean)JsonUtil.getDtoFromJsonObjStr(obj.get("_source").toString(),EsStoreXZBean.class);
		return xz;
	}

	@Override
	public DemandZS getDemandZSFeatureSourceByDocId(int type, String docId) throws Exception {
		// TODO Auto-generated method stub
		return ss.getDemandZSFeatureSourceByDocId(docId);
	}
	
	//StorageService ss;
	@Override
	public EsStoreZSBean getDemandZSFeatureByDocId(int type, String docId)  throws Exception{
		// TODO Auto-generated method stub
		String json=ss.search(type, docId,null);
		if(json==null){
			return null;
		}
		ObjectNode obj=JsonUtil.parse(json);
		EsStoreZSBean zs=(EsStoreZSBean)JsonUtil.getDtoFromJsonObjStr(obj.get("_source").toString(),EsStoreZSBean.class);
		return zs;
	}

	@Override
	public Object getDemandZSFeatureByBid(int bid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDemandXZFeatureByBid(int bid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object searchMatchDemand(RequestDemand demand,
			EsStoreZSBean zs)  throws Exception{
		// TODO Auto-generated method stub
		return searchMatchDemand(demand,zs,demand.from,demand.size);
	}

	@Override
	public Object searchMatchDemand(RequestDemand demand,
			EsStoreXZBean xz)  throws Exception{
		// TODO Auto-generated method stub
		return searchMatchDemand(demand,xz, demand.from, demand.size);
	}

	@Override
	public Object searchMatchDemand(RequestDemand demand,
			EsStoreZSBean zs, int from, int size)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(StaticBean.relIndex(demand.type),null,
				eqs.getMatchString(demand,zs,from, size),null);
		return changeSourceStringToResponseDemand(StaticBean.relIndex(demand.type),esJson);
	}

	@Override
	public Object searchMatchDemand(RequestDemand demand,
			EsStoreXZBean xz, int from, int size)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(StaticBean.relIndex(demand.type),null,
				eqs.getMatchString(demand,xz,from, size),null);
		return changeSourceStringToResponseDemand(StaticBean.relIndex(demand.type),esJson);
	}




	@Override
	public Object searchMatchDemand(RequestDemand demand,
			EsStoreZSBean zs, int from, int size,
			FunctionFactoryService function)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object searchMatchDemand(RequestDemand demand,
			EsStoreXZBean xz, int from, int size,
			FunctionFactoryService function)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Object searchMatchDemand(RequestDemand demand,
			EsStoreZSBean zs, int from, int size, String groovyFile)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(StaticBean.relIndex(demand.type),null,
				eqs.getMatchString(demand,zs, from, size),
				groovyFile,null);
		return changeSourceStringToResponseDemand(StaticBean.relIndex(demand.type),esJson);
	}

	@Override
	public Object searchMatchDemand(RequestDemand demand,
			EsStoreXZBean xz, int from, int size, String groovyFile)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(StaticBean.relIndex(demand.type),null,
				eqs.getMatchString(demand,xz, from, size),
				groovyFile);
		return changeSourceStringToResponseDemand(StaticBean.relIndex(demand.type),esJson);
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,
			EsStoreZSBean zs) throws Exception {
		// TODO Auto-generated method stub
		return searchSimDemand(demand,
				zs,demand.from,demand.size);
	}
	@Override
	public Object searchSimDemand(RequestDemand demand,
			EsStoreZSBean zs, int from, int size) throws Exception {
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type,null,
				eqs.getSimString(demand,zs,from,size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,
			EsStoreXZBean xz)  throws Exception{
		// TODO Auto-generated method stub
		return searchSimDemand(demand,
				xz,demand.from,demand.size);
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,
			EsStoreXZBean xz, int from, int size)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type,null,
				eqs.getSimString(demand,xz, from, size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,
			EsStoreZSBean zs, int from, int size,
			FunctionFactoryService function) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,
			EsStoreXZBean xz, int from, int size,
			FunctionFactoryService function)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,
			EsStoreZSBean zs, int from, int size, String groovyFile)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type,null,
				eqs.getSimString(demand,zs, from, size),groovyFile,null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}

	@Override
	public Object searchSimDemand(RequestDemand demand,
			EsStoreXZBean xz, int from, int size, String groovyFile)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type,
				eqs.getSimString(demand,xz, from, size),null,null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}

	
	public static void main(String[] args) {
		String str="{"+
//			  "\"_index\": \"search_demand_test\","+
			  "\"_type\": \"mall_demand\","+
			  "\"_id\": \"55f7c7e7de833cb1208b4567\","+
			  "\"_score\": 1.85,"+
//			  "\"fields\": {"+
//			    "\"bid\": [0],"+
//			    "\"demand_desc\": [\"南海官窯區龍頭位置，人口密度大，官窯首個商業項目，周邊配套完善，公寓商場于一體\"],"+
//			    "\"demandId\": [\"55f7c7e7de833cb1208b4567\"]"+
//			  "},"+
			  "\"sort\": [1.85, 0.6931471805599453]"+
			"}";
		
		EsResponseBean bean =(EsResponseBean) JsonUtil.getDtoFromJsonObjStr(str, EsResponseBean.class);
		System.out.println(JsonUtil.getJsonStr(bean));
		
		str="[{\"_index\":\"sd\",\"s\":{\"a\":3}},{\"_id\":\"sw\",\"s\":{}}]";
		ArrayNode node=JsonUtil.parseArray(str);
		for(int i=0;i<node.size();i++)
		{
			((ObjectNode)node.get(i)).remove("_index");
			((ObjectNode)((ObjectNode)node.get(i)).get("s")).remove("a");
		}
		System.out.println(JsonUtil.getJsonStr(node));
//		
//		Object obj=(Object)JsonUtil.getDtoFromJsonObjStr(
//				str, ResponseDemandXZ.class);//ResponseDemandXZ.class);
//				System.out.println(JsonUtil.getJsonStr(obj));
		
	}

	@Override
	public Object searchMatchHardDemand(RequestDemand demand,
			EsStoreZSBean zs) throws Exception {
		// TODO Auto-generated method stub
		String esJson = ss.search(StaticBean.relIndex(demand.type),null,
				eqs.getMatchHardString(demand,zs,demand.from,demand.size),null);
		return changeSourceStringToResponseDemand(StaticBean.relIndex(demand.type),esJson);
	}

	@Override
	public Object searchSimHardDemand(RequestDemand demand,
			EsStoreZSBean zs)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type,null,
				eqs.getSimHardString(demand,zs,demand.from,demand.size));
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}

	@Override
	public Object searchMatchHardDemand(RequestDemand demand,
			EsStoreXZBean xz)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(StaticBean.relIndex(demand.type),null,
				eqs.getMatchHardString(demand,xz,demand.from,demand.size),null);
		return changeSourceStringToResponseDemand(StaticBean.relIndex(demand.type),esJson);
	}

	@Override
	public Object searchSimHardDemand(RequestDemand demand,
			EsStoreXZBean xz)  throws Exception{
		// TODO Auto-generated method stub
		String esJson = ss.search(demand.type,null,
				eqs.getSimHardString(demand,xz,demand.from,demand.size),null);
		return changeSourceStringToResponseDemand(demand.type,esJson);
	}

}
