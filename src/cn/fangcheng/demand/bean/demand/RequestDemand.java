package cn.fangcheng.demand.bean.demand;

import java.io.Serializable;

import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.service.DemandInterface;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;

/**
 * 新增需求的实体类
 * 
 * @author Administrator
 *
 */
public class RequestDemand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7619223725493352738L;
	/**
	 * 用户id
	 */
	public int uid;
	/**
	 * 页数
	 */
	public int from = 0;
	/**
	 * 数量
	 */
	public int size = 10;
	/**
	 * 时间延后项
	 */
	public long time = 0L;

	public long timeEnd = 0L;
	/**
	 * 发送过来的数据集内容
	 */
	public ObjectNode demand = null;
	/**
	 * 是否删除
	 */
	public boolean isDelete = false;

	public int type = 1;

	public String _id = null;

	DemandInterface dis = null;

	public RequestDemand(int uid, int from, int size, long time, long timeEnd, ObjectNode demand, DemandInterface dis) {
		this.uid = uid;
		this.from = from;
		this.size = size;
		this.time = time;
		this.demand = demand;
		this.timeEnd = timeEnd;
		this.dis = dis;
		if (demand.get("demand_status").asInt() == StaticBean.DELETE) {
			this.isDelete = true;
			this._id = demand.get("_id").asText();
			// return;
		}
		if (demand.get("demand_type").asInt() == StaticBean.MALL_TYPE) {
			type = StaticBean.MALL_TYPE;
		}else{
			type= StaticBean.BRAND_TYPE;
		}
		
		this._id =demand.get("_id").asText();
	}

	public void fill() {
		// System.out.println("demandBean:"+demand.toString());
		// 如果为删除则标记删除 否则为添加

		if (type== StaticBean.MALL_TYPE) {
			if(zs==null){
			zs = dis.getDemandZSbyJson(demand.toString());
			}
			// System.out.println("out:"+JsonUtil.getJsonStr(zs));
		} else {
			if(xz==null){
			xz = dis.getDemandXZbyJson(demand.toString());
			}
			// System.out.println("out:"+JsonUtil.getJsonStr(xz));
		}
	}

	public static void main(String[] args) {
		String json = "{ \"demand_ctime\" : \"2015-07-13 17:08:22\" , \"demand_utime\" : \"2015-09-05 15:24:37\" , \"demand_expiry_at\" : \"2015-08-26\" , \"passport_id\" : 1879 , \"mall_id\" : 724 , \"mall_name\" : \"南锣鼓巷左右时代\" , \"area_id\" : [ 86999030] , \"demand_desc\" : \"面积35至200至500平米不等；\\n左右时代位于北京南锣鼓巷，紧邻地铁6、8号线出口。\" , \"demand_show_mobile\" : 1 , \"demand_level\" : 1 , \"demand_status\" : 2 , \"category_ids\" : [ 10101 , 10117 , 10200 , 10300 , 10400 , 10600 , 11000 , 20103 , 20400 , 20700 , 20800 , 50902 , 60100 , 70200 , 90202] , \"category_ids_other\" : \"\" , \"demand_shop_type\" : [ 2 , 3] , \"demand_type\" : 2 , \"passport_type\" : 3 , \"passport_company\" : \"北京南锣文化发展有限公司\" , \"tag\" : { \"group_126\" : { \"lower\" : 5000 , \"upper\" : 0}} , \"_id\" : \"55a38006de833c75738b456a\"}";
		Gson gson = new Gson();
		DemandZS demandZS = null;
		// DBObject dbc = dbc =(DBObject)JSON.parse(json);
		if (null != json && json.length() > 100) {
			demandZS = gson.fromJson(json, DemandZS.class);
			// //设置招商店铺类型(主力店......)
			// if(demandZS.getDemand_shop_type() != null &&
			// demandZS.getDemand_shop_type().length>0){
			// demandZS.setDemand_shop_type_name(getDemand_shop_type(demandZS.getDemand_shop_type()));
			// }
			// //设置tag值
			// demandZS.setTag(transforTag(demandZS.getTag()));
			// demandZS.setCategory_name(getMallCategory(demandZS.getCategory_ids(),2));
			System.out.println(gson.toJson(demandZS));
		}
	}

	/**
	 * 实体化的数据
	 */
	public DemandZS zs = null;
	/**
	 * 实体化的数据
	 */
	public DemandXZ xz = null;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public ObjectNode getDemand() {
		return demand;
	}

	public void setDemand(ObjectNode demand) {
		this.demand = demand;
	}

	public DemandZS getZs() {
		return zs;
	}

	public void setZs(DemandZS zs) {
		this.zs = zs;
	}

	public DemandXZ getXz() {
		return xz;
	}

	public void setXz(DemandXZ xz) {
		this.xz = xz;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

}
