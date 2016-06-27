package cn.fangcheng.demand.service.extra.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.demand.bean.demand.ResponseXZ;
import cn.fangcheng.demand.bean.demand.ResponseZS;
import cn.fangcheng.demand.service.extra.BrandExService;
import cn.fangcheng.demand.service.extra.DemandExService;
import cn.fangcheng.demand.service.extra.MallExService;
import cn.fangcheng.demand.service.extra.UserExService;
import cn.fangcheng.demand.service.function.ComputeScoresFunctionService;
import cn.fangcheng.demand.service.inner.DemandInService;
import cn.fangcheng.demand.service.other.imp.Storage;
import cn.fangcheng.demand.tool.JsonUtil;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;
import cn.fangcheng.mybatis.po.PassportActivity;

@Service
public class DemandEx<T> implements DemandExService {
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(DemandEx.class);
	@Autowired
	DemandInService dis;
	@Autowired
	UserExService ues;
	@Autowired
	MallExService mes;
	@Autowired
	BrandExService bes;
	@Autowired
	ComputeScoresFunctionService csfs;

	@Autowired
	Storage ss;

	@Override
	public boolean addDemand(RequestDemand demand,String alias) throws Exception {
		// TODO Auto-generated method stub
		// 获取demand feature
		try {
			// logger.info("addDemand");tian
			// 计算新的数据集
			if (demand.isDelete()) {
				// 如果为清除操作则需要删除数据
				//对于替换别名表不存在删除操作
				dis.deleteDemandByDocId(demand.getType(), demand.get_id(),null);
			} else {
				//mall和brand的数据字段转换,如店铺类型、tag等
				demand.fill();
				// 获取 brand信息
				if (demand.type == StaticBean.MALL_TYPE) {
					Mall mallFeature = null;
					// 先获取 userFeature
					DemandZS demandZS = demand.zs;
					PassportActivity userFeature = null;
					try {
						userFeature = ues.getUserFeature(demandZS.getPassport_id());
					} catch (Exception e) {
					}
					// 更新demand feature数据
					// DemandZS demandZS = dis.getDemandZSFeatureSourceByDocId(
					// StaticBean.MALL_TYPE, demand.docId);
					if (demandZS.getDemand_status() != 0) {// 如果需求状态为有效则更新
						if (!isAvailably(demandZS)) {
							return true;
						}
					} else {
						logger.info("应被删除数据");
						return true;
					}

					mallFeature = mes.getFeatureByBid(demandZS.getMall_id());
					//mallFeature.setMallAddress(new String(mallFeature.getMallAddress().getBytes(),"UTF-8"));
					EsStoreZSBean esBean = csfs.computeFeature(demand,userFeature, mallFeature, demandZS);
					//logger.info("add------------------------------ esBean:"+JsonUtil.getJsonStr(esBean));
					return dis.updateDemandFeature(demandZS.getDemand_type(),demandZS.get_id(), esBean,alias);
				} else {
					Brand brandFeature = null;
					DemandXZ demandXZ = demand.xz;
				
					// logger.info(demand.bid+"\t==-----:"+JsonUtil.getJsonStr(brandFeature));
					// 更新demand feature数据
					// DemandXZ demandXZ = dis.getDemandXZFeatureSourceByDocId(
					// StaticBean.BRAND_TYPE, demand.docId);
					if (demandXZ.getDemand_status() != 0) {// 如果需求状态为有效则更新
						if (!isAvailably(demandXZ)) {
							return true;
						}
					} else {
						logger.info("应被删除数据");
						return true;
					}
					PassportActivity userFeature = null;
					try {
						userFeature = ues.getUserFeature(demandXZ.getPassport_id());
					} catch (Exception e) {
					}
						brandFeature = bes.getFeatureByBid(demandXZ
								.getBrand_id());
					EsStoreXZBean esBean = csfs.computeFeature(demand,userFeature, brandFeature, demandXZ);
					//logger.info("add------------------------- esBean:"+JsonUtil.getJsonStr(esBean));
					return dis.updateDemandFeature(demandXZ.getDemand_type(),demandXZ.get_id(), esBean,alias);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateDemand(RequestDemand demand) throws Exception {
		return addDemand(demand,null);
	}

	@Override
	public boolean deleteDemand(RequestDemand demand) throws Exception {
		// return dis.deleteDemandByDocId(demand.type, demand.docId);
		return false;
	}

	public String getRequestDemand(RequestDemand demand) {
		return null;
	}

	@Override
	public Object getMatchDemand(RequestDemand demand) throws Exception {
		// TODO Auto-generated method stub
		// 获取
		Object list = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			// 获取用户属性
			// UserFeature userFeature = ues.getUserFeature(demand.uid);
			
			// Mall mallFeature=null;
			// mallFeature=mes.getFeatureByBid(demand.bid);
			// // 更新demand feature数据
			// DemandZS
			// demandZS=dis.getDemandZSFeatureSourceByDocId(StaticBean.MALL_TYPE,
			// demand.docId);
			// list=dis.searchMatchDemand(demand,demandZS, userFeature,
			// mallFeature);
			// 直接获取es中的处理过后的数据作为输入
			EsStoreZSBean esStore = null;
			try {
				esStore = dis.getDemandZSFeatureByDocId(demand.getType(),demand.get_id());
			} catch (Exception e) {
				logger.info("es不存在该数据:"+demand.getType()+"\t"+demand.get_id());
			}
			if (esStore == null) {
				demand.fill();
				DemandZS demandZS = demand.zs;
				esStore = csfs.copy(null, null, null, demandZS);
			}
			list = dis.searchMatchDemand(demand, esStore);
			return list;
		} else {
			// Brand brandFeature=null;
			// brandFeature=bes.getFeatureByBid(demand.bid);
			// // 更新demand feature数据
			// DemandXZ
			// demandXZ=dis.getDemandXZFeatureSourceByDocId(StaticBean.BRAND_TYPE,
			// demand.docId);
			// list=dis.searchMatchDemand(demand,demandXZ, userFeature,
			// brandFeature);
			// 直接获取es中的处理过后的数据作为输入
			// EsStoreXZBean esStore =
			// dis.getDemandXZFeatureByDocId(demand.type,
			// demand.docId);
			// UserFeature userFeature = ues.getUserFeature(demand.uid);
			
			EsStoreXZBean esStore = null;
			try {
				esStore = dis.getDemandXZFeatureByDocId(demand.getType(),demand.get_id());
			} catch (Exception e) {
				logger.info("es不存在该数据:"+demand.getType()+"\t"+demand.get_id());
			}
			if (esStore == null) {
				demand.fill();
				DemandXZ demandXZ = demand.xz;
				esStore = csfs.copy(null, null, null, demandXZ);
			}
			list = dis.searchMatchDemand(demand, esStore);
		}
		if (list == null) {
			list = new Object();
		}
		// if (list.length < demand.size) {
		// Object[] fill = getFillMatchDemand(demand);
		// return fillDemand(list, fill, demand.size);
		// }
		return list;
	}

	@Override
	public Object getSimDemand(RequestDemand demand) throws Exception {
		// TODO Auto-generated method stub
		// 获取用户属性
		//UserFeature userFeature = ues.getUserFeature(demand.uid);
		// 获取
		Object list = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			// Mall mallFeature=null;
			// mallFeature=mes.getFeatureByBid(demand.bid);
			// 更新demand feature数据
			// EsStoreZSBean esStore =
			// dis.getDemandZSFeatureByDocId(demand.type,
			// demand.docId);
			// list = dis.searchSimDemand(demand, esStore);
			// DemandZS
			// demandZS=dis.getDemandZSFeatureSourceByDocId(StaticBean.MALL_TYPE,
			// demand.docId);
			// list=dis.searchSimDemand(demand,demandZS, userFeature,
			// mallFeature);
			
			EsStoreZSBean esStore = null;
			try {
				esStore = dis.getDemandZSFeatureByDocId(demand.getType(),demand.get_id());
			} catch (Exception e) {
				logger.info("es不存在该数据:"+demand.getType()+"\t"+demand.get_id());
			}
			if (esStore == null) {
				demand.fill();
				DemandZS demandZS = demand.zs;
				esStore = csfs.copy(null, null, null, demandZS);
			}
			list = dis.searchSimDemand(demand, esStore);
		} else {
			// Brand brandFeature=null;
			// brandFeature=bes.getFeatureByBid(demand.bid);
			// 更新demand feature数据

			// DemandXZ
			// demandXZ=dis.getDemandXZFeatureSourceByDocId(StaticBean.BRAND_TYPE,
			// demand.docId);
			// list=dis.searchSimDemand(demand,demandXZ, userFeature,
			// brandFeature);
			// EsStoreXZBean esStore =
			// dis.getDemandXZFeatureByDocId(demand.type,
			// demand.docId);
			// list = dis.searchSimDemand(demand, esStore);
			
			EsStoreXZBean esStore = null;
			try {
				esStore = dis.getDemandXZFeatureByDocId(
						demand.getType(), demand.get_id());
			} catch (Exception e) {
				try{
				logger.info("es不存在该数据:"+demand.getType()+"\t"+demand.get_id());
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
			if (esStore == null) {
				demand.fill();
				DemandXZ demandXZ = demand.xz;
				esStore = csfs.copy(null, null, null, demandXZ);
			}
			list = dis.searchSimDemand(demand, esStore);
		}
		if (list == null) {
			list = new Object();
		}
		// if (list.length < demand.size) {
		// Object[] fill = getFillSimDemand(demand);
		// return fillDemand(list, fill, demand.size);
		// }
		return list;
	}

	@Override
	public Object getFillMatchDemand(RequestDemand demand) throws Exception {
		// TODO Auto-generated method stub
		return dis.getFillMatchDemand(demand.type);
	}

	@Override
	public Object getFillSimDemand(RequestDemand demand) throws Exception {
		// TODO Auto-generated method stub
		return dis.getFillSimDemand(demand.type);
	}

	@Override
	public Object[] fillDemand(Object[] demand1, Object[] demand2, int size)
			throws Exception {
		// TODO Auto-generated method stub
		if (demand1.length > size) {
			return demand1;
		}
		if (demand2 == null) {
			return demand1;
		}
		int count = size - demand1.length > demand2.length ? demand2.length
				: size - demand1.length;
		Object[] temp = new Object[demand1.length + count];
		System.arraycopy(demand1, 0, temp, 0, demand1.length);
		System.arraycopy(demand2, demand1.length, temp, demand1.length, count);
		return demand1;
	}
	
	//DemandInService dis
	@Override
	public Object getDemand(int type, String docId) throws Exception {
		// TODO Auto-generated method stub
		if (type == StaticBean.MALL_TYPE) {
			return dis.getDemandZSFeatureByDocId(type, docId);
		} else {
			return dis.getDemandXZFeatureByDocId(type, docId);
		}
	}

	@Override
	public Object getDemandResponse(int type, String docId) throws Exception {
		// TODO Auto-generated method stub
		String temp = "{\"query\": {" + "\"bool\": {" + "\"must\": [" + "{"
				+ "\"term\": {" + "\"demandId\": {" + "\"value\": \"" + docId
				+ "\"" + "}" + "}" + "}" + "]" + "}}}";

		String json = ss.search(type, "_search", temp);
		Object list = dis.changeSourceStringToResponseDemand(type, json);
		// if (list.length > 0) {
		// return list[0];
		// }
		if (type == StaticBean.MALL_TYPE) {
			ResponseZS te = (ResponseZS) list;
			if (te.hits != null && te.hits.length > 0) {
				return te.hits[0];
			}
		} else {
			ResponseXZ te = (ResponseXZ) list;
			if (te.hits != null && te.hits.length > 0) {
				return te.hits[0];
			}
		}
		return new Object();
	}

	@Override
	public Object getMatchHardDemand(RequestDemand demand) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 获取用户属性
		// UserFeature userFeature = ues.getUserFeature(demand.uid);
		// 获取
		Object list = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			// Mall mallFeature=null;
			// mallFeature=mes.getFeatureByBid(demand.bid);
			// // 更新demand feature数据
			// DemandZS
			// demandZS=dis.getDemandZSFeatureSourceByDocId(StaticBean.MALL_TYPE,
			// demand.docId);
			// list=dis.searchMatchDemand(demand,demandZS, userFeature,
			// mallFeature);
			// 直接获取es中的处理过后的数据作为输入
			// EsStoreZSBean esStore =
			// dis.getDemandZSFeatureByDocId(demand.type,
			// demand.docId);
			// list = dis.searchMatchHardDemand(demand, esStore);
		} else {
			// Brand brandFeature=null;
			// brandFeature=bes.getFeatureByBid(demand.bid);
			// // 更新demand feature数据
			// DemandXZ
			// demandXZ=dis.getDemandXZFeatureSourceByDocId(StaticBean.BRAND_TYPE,
			// demand.docId);
			// list=dis.searchMatchDemand(demand,demandXZ, userFeature,
			// brandFeature);
			// 直接获取es中的处理过后的数据作为输入
			// EsStoreXZBean esStore =
			// dis.getDemandXZFeatureByDocId(demand.type,
			// demand.docId);
			// list = dis.searchMatchHardDemand(demand, esStore);
		}
		if (list == null) {
			list = new Object[0];
		}
		return list;
	}

	@Override
	public Object getSimHardDemand(RequestDemand demand) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 获取用户属性
		// UserFeature userFeature = ues.getUserFeature(demand.uid);
		// 获取
		Object list = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			// Mall mallFeature=null;
			// mallFeature=mes.getFeatureByBid(demand.bid);
			// 更新demand feature数据
			// EsStoreZSBean esStore =
			// dis.getDemandZSFeatureByDocId(demand.type,
			// demand.docId);
			// list = dis.searchSimHardDemand(demand, esStore);
			// DemandZS
			// demandZS=dis.getDemandZSFeatureSourceByDocId(StaticBean.MALL_TYPE,
			// demand.docId);
			// list=dis.searchSimDemand(demand,demandZS, userFeature,
			// mallFeature);
		} else {
			// Brand brandFeature=null;
			// brandFeature=bes.getFeatureByBid(demand.bid);
			// 更新demand feature数据

			// DemandXZ
			// demandXZ=dis.getDemandXZFeatureSourceByDocId(StaticBean.BRAND_TYPE,
			// demand.docId);
			// list=dis.searchSimDemand(demand,demandXZ, userFeature,
			// brandFeature);
			// EsStoreXZBean esStore =
			// dis.getDemandXZFeatureByDocId(demand.type,
			// demand.docId);
			// list = dis.searchSimHardDemand(demand, esStore);
		}
		if (list == null) {
			list = new Object();
		}
		return list;
	}

	/**
	 * 如果是直接传过来的demand 则直接添加
	 */
	@Override
	public boolean addDemand(DemandZS demand) throws Exception {
		// TODO Auto-generated method stub
		try {
			// logger.info("addDemand");
			// 计算新的数据集
			if (demand.getDemand_status() == StaticBean.DELETE) {
				// 如果为清除操作则需要删除数据
				dis.deleteDemandByDocId(demand.getDemand_type(),
						demand.get_id(),null);
			} else {
				// 先获取 userFeature
				PassportActivity userFeature = null;
				try {
					userFeature = ues.getUserFeature(demand.getPassport_id());
				} catch (Exception e) {

				}
				Mall mallFeature = null;
				try{
					mallFeature = mes.getFeatureByBid(demand.getMall_id());
				}catch(Exception e){
					
				}
				if (demand.getDemand_status() != 0) {// 如果需求状态为有效则更新
					if (!isAvailably(demand)) {
						return true;
					}
				} else {
					return true;
				}
				EsStoreZSBean esBean = csfs.computeFeature(null, userFeature,
						mallFeature, demand);
				// logger.info("add esBean:"+JsonUtil.getJsonStr(esBean));
				dis.updateDemandFeature(demand.getDemand_type(),
						demand.get_id(), esBean,null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addDemand(DemandXZ demand) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			
		try {
			// logger.info("addDemand");
			// 计算新的数据集
			if (demand.getDemand_status() == StaticBean.DELETE) {
				// 如果为清除操作则需要删除数据
				dis.deleteDemandByDocId(demand.getDemand_type(),
						demand.get_id(),null);
			} else {
				// 先获取 userFeature
				PassportActivity userFeature = null;
				try {
					userFeature = ues.getUserFeature(demand.getPassport_id());
				} catch (Exception e) {

				}
				Brand brandFeature = null;
				try{
					brandFeature = bes.getFeatureByBid(demand.getDemand_status());
				}catch(Exception e){
					
				}
				// logger.info(demand.bid+"\t==-----:"+JsonUtil.getJsonStr(brandFeature));
				// 更新demand feature数据
				if (demand.getDemand_status() != 0) {// 如果需求状态为有效则更新
					if (!isAvailably(demand)) {
						return true;
					}
				} else {
					return false;
				}
				EsStoreXZBean esBean = csfs.computeFeature(null, userFeature,
						brandFeature, demand);
				// logger.info("add esBean:"+JsonUtil.getJsonStr(esBean));
				dis.updateDemandFeature(demand.getDemand_type(),
						demand.get_id(), esBean,null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 是否有效
	 * 
	 * @param zs
	 * @return
	 * @throws Exception
	 */
	public boolean isAvailably(DemandZS demand) throws Exception {
		if ((demand.getMall_name() != null && demand.getMall_name().contains(
				"测试"))
				|| (demand.getDemand_desc() != null && demand
						.getDemand_desc().contains("测试"))
				|| (demand.getPassport_company() != null && demand
						.getPassport_company().contains("测试"))
				|| demand.getPassport_id() < 30) {
			logger.info("测试信息:"+JsonUtil.getJsonStr(demand));
			return false;
		}
		return true;
	}

	/**
	 * 是否有效
	 * 
	 * @param zs
	 * @return
	 * @throws Exception
	 */
	public boolean isAvailably(DemandXZ demand) throws Exception {
		if ((demand.getBrand_name() != null && demand.getBrand_name().contains(
				"测试"))
				|| (demand.getDemand_desc() != null && demand
						.getDemand_desc().contains("测试"))
				|| (demand.getPassport_company() != null && demand
						.getPassport_company().contains("测试"))
				|| demand.getPassport_id() < 30) {
			logger.info("测试信息:"+JsonUtil.getJsonStr(demand));
			return false;
		}
		return true;
	}

}
