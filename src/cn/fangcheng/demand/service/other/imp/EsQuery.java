package cn.fangcheng.demand.service.other.imp;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.Feature;
import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.bean.demand.DemandFeature;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.demand.bean.script.Script;
import cn.fangcheng.demand.bean.script.ScriptUseStoreXZ;
import cn.fangcheng.demand.bean.script.ScriptUseStoreZS;
import cn.fangcheng.demand.service.other.EsQueryService;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;

@Service
public class EsQuery implements EsQueryService {
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(EsQuery.class);

	public static String mallMatchDemand = "mallMatchDemand";
	public static String mallSimDemand = "mallSimDemand";
	public static String brandMatchDemand = "brandMatchDemand";
	public static String brandSimDemand = "brandSimDemand";

	public static String mallMatchDemandCatZero = "mallMatchDemandCatZero";
	public static String mallSimDemandCatZero = "mallSimDemandCatZero";
	public static String brandMatchDemandCatZero = "brandMatchDemandCatZero";
	public static String brandSimDemandCatZero = "brandSimDemandCatZero";

	public static String mallMatchDemandCatOne = "mallMatchDemandCatOne";
	public static String mallSimDemandCatOne = "mallSimDemandCatOne";
	public static String brandMatchDemandCatOne = "brandMatchDemandCatOne";
	public static String brandSimDemandCatOne = "brandSimDemandCatOne";

	public static String mallMatchDemandCatTwo = "mallMatchDemandCatTwo";
	public static String mallSimDemandCatTwo = "mallSimDemandCatTwo";
	public static String brandMatchDemandCatTwo = "brandMatchDemandCatTwo";
	public static String brandSimDemandCatTwo = "brandSimDemandCatTwo";

	public static String mallMatchDemandCatThree = "mallMatchDemandCatThree";
	public static String mallSimDemandCatThree = "mallSimDemandCatThree";
	public static String brandMatchDemandCatThree = "brandMatchDemandCatThree";
	public static String brandSimDemandCatThree = "brandSimDemandCatThree";

	public static String mallMatchHardDemand = "mallMatchHardDemand";
	public static String mallSimHardDemand = "mallSimHardDemand";
	public static String brandMatchHardDemand = "brandMatchHardDemand";
	public static String brandSimHardDemand = "brandSimHardDemand";

	// @Resource(name="MatchFunctionFactory")
	// FunctionFactoryService ffs_match;
	//
	// @Resource(name="SimFunctionFactory")
	// FunctionFactoryService ffs_sim;

	@Override
	public String getString(RequestDemand demand, DemandFeature demandFeature,
			UserFeature userFeature, Feature feature, int from, int size)
			throws Exception {
		return null;
	}

	public String getByBid(int bid, int from, int size) throws Exception {
		return null;
	}

	@Override
	public String getMatchString(RequestDemand demand, DemandZS zs,
			UserFeature userFeature, Mall feature, int from, int size)
			throws Exception {
		// TODO Auto-generated method stub
		String script = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			if (zs.getCategory_name().getCat1() == null
					|| zs.getCategory_name().getCat1().size() == 0) {
				script = Script.getScript(mallMatchDemandCatZero, zs,
						userFeature, feature, from, size);
			} else if (zs.getCategory_name().getCat2() == null
					|| zs.getCategory_name().getCat2().size() == 0) {
				script = Script.getScript(mallMatchDemandCatOne, zs,
						userFeature, feature, from, size);
			} else if (zs.getCategory_name().getCat3() == null
					|| zs.getCategory_name().getCat3().size() == 0) {
				script = Script.getScript(mallMatchDemandCatTwo, zs,
						userFeature, feature, from, size);
			} else {
				script = Script.getScript(mallMatchDemandCatThree, zs,
						userFeature, feature, from, size);
			}
			// script = Script.getScript(mallMatchDemand, demandFeature,
			// userFeature, feature, from, size);
		} else {
			// script = Script.getScript(brandMatchDemand, demandFeature,
			// userFeature, feature, from, size);
			// if(demand.getXz().getCategory_name().getCat1()==null||demand.getXz().getCategory_name().getCat1().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatZero, zs,
			// userFeature, feature, from, size);
			// }else
			// if(demand.getXz().getCategory_name().getCat2()==null||demand.getXz().getCategory_name().getCat2().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatOne, zs,
			// userFeature, feature, from, size);
			// }else
			// if(demand.getXz().getCategory_name().getCat3()==null||demand.getXz().getCategory_name().getCat3().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatTwo, zs,
			// userFeature, feature, from, size);
			// }else{
			// script = Script.getScript(brandMatchDemandCatThree, zs,
			// userFeature, feature, from, size);
			// }
		}
		// logger.info("script:"+script);
		return script;
	}

	@Override
	public String getMatchString(RequestDemand demand, DemandXZ xz,
			UserFeature userFeature, Brand feature, int from, int size)
			throws Exception {
		// TODO Auto-generated method stub
		String script = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			// script = Script.getScript(mallMatchDemand, demandFeature,
			// userFeature, feature, from, size);
			// if(xz.getCategory_name().getCat1()==null||xz.getCategory_name().getCat1().size()==0)
			// {
			// script = Script.getScript(mallMatchDemandCatZero, xz,
			// userFeature, feature, from, size);
			// }else
			// if(xz.getCategory_name().getCat2()==null||xz.getCategory_name().getCat2().size()==0)
			// {
			// script = Script.getScript(mallMatchDemandCatOne, xz,
			// userFeature, feature, from, size);
			// }else
			// if(xz.getCategory_name().getCat3()==null||xz.getCategory_name().getCat3().size()==0)
			// {
			// script = Script.getScript(mallMatchDemandCatTwo, xz,
			// userFeature, feature, from, size);
			// }else{
			// script = Script.getScript(mallMatchDemandCatThree, xz,
			// userFeature, feature, from, size);
			// }
		} else {
			// script = Script.getScript(brandMatchDemand, demandFeature,
			// userFeature, feature, from, size);
			if (xz.getCategory_name().getCat1() == null
					|| xz.getCategory_name().getCat1().size() == 0) {
				script = Script.getScript(brandMatchDemandCatZero, xz,
						userFeature, feature, from, size);
			} else if (xz.getCategory_name().getCat2() == null
					|| xz.getCategory_name().getCat2().size() == 0) {
				script = Script.getScript(brandMatchDemandCatOne, xz,
						userFeature, feature, from, size);
			} else if (xz.getCategory_name().getCat3() == null
					|| xz.getCategory_name().getCat3().size() == 0) {
				script = Script.getScript(brandMatchDemandCatTwo, xz,
						userFeature, feature, from, size);
			} else {
				script = Script.getScript(brandMatchDemandCatThree, xz,
						userFeature, feature, from, size);
			}
		}
		// System.out.println("script:"+script);
		return script;
	}

	@Override
	public String getSimString(RequestDemand demand, DemandZS zs,
			UserFeature userFeature, Mall feature, int from, int size)
			throws Exception {
		// TODO Auto-generated method stub
		String script = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			// script = Script.getScript(mallSimDemand, demandFeature,
			// userFeature, feature, from, size);
			if (zs.getCategory_name().getCat1() == null
					|| zs.getCategory_name().getCat1().size() == 0) {
				script = Script.getScript(mallSimDemandCatZero, zs,
						userFeature, feature, from, size);
			} else if (zs.getCategory_name().getCat2() == null
					|| zs.getCategory_name().getCat2().size() == 0) {
				script = Script.getScript(mallSimDemandCatOne, zs, userFeature,
						feature, from, size);
			} else if (zs.getCategory_name().getCat3() == null
					|| zs.getCategory_name().getCat3().size() == 0) {
				script = Script.getScript(mallSimDemandCatTwo, zs, userFeature,
						feature, from, size);
			} else {
				script = Script.getScript(mallSimDemandCatThree, zs,
						userFeature, feature, from, size);
			}
		} else {
			// script = Script.getScript(brandSimDemand, demandFeature,
			// userFeature, feature, from, size);
			// if(demand.getXz().getCategory_name().getCat1()==null||demand.getXz().getCategory_name().getCat1().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatZero, demandFeature,
			// userFeature, feature, from, size);
			// }else
			// if(demand.getXz().getCategory_name().getCat2()==null||demand.getXz().getCategory_name().getCat2().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatOne, demandFeature,
			// userFeature, feature, from, size);
			// }else
			// if(demand.getXz().getCategory_name().getCat3()==null||demand.getXz().getCategory_name().getCat3().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatTwo, demandFeature,
			// userFeature, feature, from, size);
			// }else{
			// script = Script.getScript(brandMatchDemandCatThree,
			// demandFeature,
			// userFeature, feature, from, size);
			// }
		}
		return script;
	}

	@Override
	public String getSimString(RequestDemand demand, DemandXZ xz,
			UserFeature userFeature, Brand feature, int from, int size)
			throws Exception {
		// TODO Auto-generated method stub
		String script = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			// script = Script.getScript(mallSimDemand, demandFeature,
			// userFeature, feature, from, size);
			// if(xz.getCategory_name().getCat1()==null||xz.getCategory_name().getCat1().size()==0)
			// {
			// script = Script.getScript(brandSimDemandCatZero, xz,
			// userFeature, feature, from, size);
			// }else
			// if(xz.getCategory_name().getCat2()==null||xz.getCategory_name().getCat2().size()==0)
			// {
			// script = Script.getScript(brandSimDemandCatOne, xz,
			// userFeature, feature, from, size);
			// }else
			// if(xz.getCategory_name().getCat3()==null||xz.getCategory_name().getCat3().size()==0)
			// {
			// script = Script.getScript(brandSimDemandCatTwo, xz,
			// userFeature, feature, from, size);
			// }else{
			// script = Script.getScript(brandSimDemandCatThree, xz,
			// userFeature, feature, from, size);
			// }
		} else {
			// script = Script.getScript(brandSimDemand, demandFeature,
			// userFeature, feature, from, size);
			if (xz.getCategory_name().getCat1() == null
					|| xz.getCategory_name().getCat1().size() == 0) {
				script = Script.getScript(brandSimDemandCatZero, xz,
						userFeature, feature, from, size);
			} else if (xz.getCategory_name().getCat2() == null
					|| xz.getCategory_name().getCat2().size() == 0) {
				script = Script.getScript(brandSimDemandCatOne, xz,
						userFeature, feature, from, size);
			} else if (xz.getCategory_name().getCat3() == null
					|| xz.getCategory_name().getCat3().size() == 0) {
				script = Script.getScript(brandSimDemandCatTwo, xz,
						userFeature, feature, from, size);
			} else {
				script = Script.getScript(brandSimDemandCatThree, xz,
						userFeature, feature, from, size);
			}
		}
		return script;
	}

	@Override
	public String getMatchString(RequestDemand demand, EsStoreZSBean zs,
			int from, int size) throws Exception {
		// TODO Auto-generated method stub
		ScriptUseStoreZS xzBean = getScriptUseStoreZS(demand, zs, from, size);
		String script = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			// script = Script.getScript(mallMatchDemand, xzBean);
			if (zs.getCategory_name().getCat1() == null
					|| zs.getCategory_name().getCat1().size() == 0) {
				script = Script.getScript(mallMatchDemandCatZero, xzBean);
			} else if (zs.getCategory_name().getCat2() == null
					|| zs.getCategory_name().getCat2().size() == 0) {
				script = Script.getScript(mallMatchDemandCatOne, xzBean);
			} else if (zs.getCategory_name().getCat3() == null
					|| zs.getCategory_name().getCat3().size() == 0) {
				script = Script.getScript(mallMatchDemandCatTwo, xzBean);
			} else {
				if (!zs.getCategory_name().getCat1().contains("餐饮")) {

				} else {
					xzBean.setRepast(18);
				}
				script = Script.getScript(mallMatchDemandCatThree, xzBean);
			}
		} else {
			// script = Script.getScript(brandMatchDemand, xzBean);
			// if(demand.getXz().getCategory_name().getCat1()==null||demand.getXz().getCategory_name().getCat1().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatZero,xzBean);
			// }else
			// if(demand.getXz().getCategory_name().getCat2()==null||demand.getXz().getCategory_name().getCat2().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatOne,xzBean);
			// }else
			// if(demand.getXz().getCategory_name().getCat3()==null||demand.getXz().getCategory_name().getCat3().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatTwo,xzBean);
			// }else{
			// script = Script.getScript(brandMatchDemandCatThree,xzBean);
			// }
		}
		// logger.info("script:"+script);
		return script;
	}

	public ScriptUseStoreZS getScriptUseStoreZS(RequestDemand demand,
			EsStoreZSBean zs, int from, int size) {
		ScriptUseStoreZS xzBean = new ScriptUseStoreZS();
		xzBean.from = from;
		xzBean.size = size;
		xzBean.time = demand.time;
		xzBean.timeEnd = demand.timeEnd;
		xzBean._source = zs;
		return xzBean;
	}

	public ScriptUseStoreXZ getScriptUseStoreXZ(RequestDemand demand,
			EsStoreXZBean zs, int from, int size) {
		ScriptUseStoreXZ xzBean = new ScriptUseStoreXZ();
		xzBean.from = from;
		xzBean.size = size;
		xzBean.time = demand.time;
		xzBean.timeEnd = demand.timeEnd;
		xzBean._source = zs;
		return xzBean;
	}

	@Override
	public String getMatchString(RequestDemand demand, EsStoreXZBean xz,
			int from, int size) throws Exception {
		// TODO Auto-generated method stub
		ScriptUseStoreXZ xzBean = getScriptUseStoreXZ(demand, xz, from, size);
		String script = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			// script = Script.getScript(mallMatchDemand, xzBean);
			// if(zs.getCategory_name().getCat1()==null||zs.getCategory_name().getCat1().size()==0)
			// {
			// script = Script.getScript(mallMatchDemandCatZero,xzBean);
			// }else
			// if(zs.getCategory_name().getCat2()==null||zs.getCategory_name().getCat2().size()==0)
			// {
			// script = Script.getScript(mallMatchDemandCatOne,xzBean);
			// }else
			// if(zs.getCategory_name().getCat3()==null||zs.getCategory_name().getCat3().size()==0)
			// {
			// script = Script.getScript(mallMatchDemandCatTwo,xzBean);
			// }else{
			// script = Script.getScript(mallMatchDemandCatThree,xzBean);
			// }
		} else {
			// script = Script.getScript(brandMatchDemand, xzBean);
			if (xz.getCategory_name().getCat1() == null
					|| xz.getCategory_name().getCat1().size() == 0) {
				script = Script.getScript(brandMatchDemandCatZero, xzBean);
			} else if (xz.getCategory_name().getCat2() == null
					|| xz.getCategory_name().getCat2().size() == 0) {
				script = Script.getScript(brandMatchDemandCatOne, xzBean);
			} else if (xz.getCategory_name().getCat3() == null
					|| xz.getCategory_name().getCat3().size() == 0) {
				script = Script.getScript(brandMatchDemandCatTwo, xzBean);
			} else {
				if (!xz.getCategory_name().getCat1().contains("餐饮")) {

				} else {
					xzBean.setRepast(18);
				}
				script = Script.getScript(brandMatchDemandCatThree, xzBean);
			}
		}
		// logger.info("script:"+script);
		return script;
	}

	@Override
	public String getSimString(RequestDemand demand, EsStoreZSBean zs,
			int from, int size) throws Exception {
		// TODO Auto-generated method stub
		String script = null;
		ScriptUseStoreZS xzBean = getScriptUseStoreZS(demand, zs, from, size);
		if (demand.type == StaticBean.MALL_TYPE) {
			// script = Script.getScript(mallSimDemand, xzBean);
			if (zs.getCategory_name().getCat1() == null
					|| zs.getCategory_name().getCat1().size() == 0) {
				script = Script.getScript(mallSimDemandCatZero, xzBean);
			} else if (zs.getCategory_name().getCat2() == null
					|| zs.getCategory_name().getCat2().size() == 0) {
				script = Script.getScript(mallSimDemandCatOne, xzBean);
			} else if (zs.getCategory_name().getCat3() == null
					|| zs.getCategory_name().getCat3().size() == 0) {
				script = Script.getScript(mallSimDemandCatTwo, xzBean);
			} else {
				if (!zs.getCategory_name().getCat1().contains("餐饮")) {

				} else {
					xzBean.setRepast(18);
				}
				script = Script.getScript(mallSimDemandCatThree, xzBean);
			}
		} else {
			// script = Script.getScript(brandSimDemand, xzBean);
			// if(demand.getXz().getCategory_name().getCat1()==null||demand.getXz().getCategory_name().getCat1().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatZero,xzBean);
			// }else
			// if(demand.getXz().getCategory_name().getCat2()==null||demand.getXz().getCategory_name().getCat2().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatOne,xzBean);
			// }else
			// if(demand.getXz().getCategory_name().getCat3()==null||demand.getXz().getCategory_name().getCat3().size()==0)
			// {
			// script = Script.getScript(brandMatchDemandCatTwo,xzBean);
			// }else{
			// script = Script.getScript(brandMatchDemandCatThree,xzBean);
			// }
		}
		return script;
	}

	@Override
	public String getSimString(RequestDemand demand, EsStoreXZBean xz,
			int from, int size) throws Exception {
		// TODO Auto-generated method stub
		String script = null;
		ScriptUseStoreXZ xzBean = getScriptUseStoreXZ(demand, xz, from, size);
		if (demand.type == StaticBean.MALL_TYPE) {
			// script = Script.getScript(mallSimDemand, xzBean);
			// if(zs.getCategory_name().getCat1()==null||zs.getCategory_name().getCat1().size()==0)
			// {
			// script = Script.getScript(mallSimDemandCatZero,xzBean);
			// }else
			// if(zs.getCategory_name().getCat2()==null||zs.getCategory_name().getCat2().size()==0)
			// {
			// script = Script.getScript(mallSimDemandCatOne,xzBean);
			// }else
			// if(zs.getCategory_name().getCat3()==null||zs.getCategory_name().getCat3().size()==0)
			// {
			// script = Script.getScript(mallSimDemandCatTwo,xzBean);
			// }else{
			// script = Script.getScript(mallSimDemandCatThree,xzBean);
			// }
		} else {
			// script = Script.getScript(brandSimDemand, xzBean);
			if (xz.getCategory_name().getCat1() == null
					|| xz.getCategory_name().getCat1().size() == 0) {
				script = Script.getScript(brandSimDemandCatZero, xzBean);
			} else if (xz.getCategory_name().getCat2() == null
					|| xz.getCategory_name().getCat2().size() == 0) {
				script = Script.getScript(brandSimDemandCatOne, xzBean);
			} else if (xz.getCategory_name().getCat3() == null
					|| xz.getCategory_name().getCat3().size() == 0) {
				script = Script.getScript(brandSimDemandCatTwo, xzBean);
			} else {
				if (!xz.getCategory_name().getCat1().contains("餐饮")) {

				} else {
					xzBean.setRepast(18);
				}
				script = Script.getScript(brandSimDemandCatThree, xzBean);
			}
		}
		return script;
	}

	@Override
	public String getMatchHardString(RequestDemand demand, EsStoreZSBean zs,
			int from, int size) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ScriptUseStoreZS xzBean = getScriptUseStoreZS(demand, zs, from, size);
		String script = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			script = Script.getScript(mallMatchHardDemand, xzBean);
		} else {
			script = Script.getScript(brandMatchHardDemand, xzBean);
		}
		// logger.info("script:"+script);
		return script;
	}

	@Override
	public String getMatchHardString(RequestDemand demand, EsStoreXZBean xz,
			int from, int size) throws Exception {
		// TODO Auto-generated method stub
		ScriptUseStoreXZ xzBean = getScriptUseStoreXZ(demand, xz, from, size);
		String script = null;
		if (demand.type == StaticBean.MALL_TYPE) {
			script = Script.getScript(mallMatchHardDemand, xzBean);
		} else {
			script = Script.getScript(brandMatchHardDemand, xzBean);
		}
		// logger.info("script:"+script);
		return script;
	}

	@Override
	public String getSimHardString(RequestDemand demand, EsStoreZSBean zs,
			int from, int size) throws Exception {
		// TODO Auto-generated method stub
		String script = null;
		ScriptUseStoreZS xzBean = getScriptUseStoreZS(demand, zs, from, size);
		if (demand.type == StaticBean.MALL_TYPE) {
			script = Script.getScript(mallSimHardDemand, xzBean);
		} else {
			script = Script.getScript(brandSimHardDemand, xzBean);
		}
		return script;
	}

	@Override
	public String getSimHardString(RequestDemand demand, EsStoreXZBean xz,
			int from, int size) throws Exception {
		// TODO Auto-generated method stub
		String script = null;
		ScriptUseStoreXZ xzBean = getScriptUseStoreXZ(demand, xz, from, size);
		if (demand.type == StaticBean.MALL_TYPE) {
			script = Script.getScript(mallSimHardDemand, xzBean);
		} else {
			script = Script.getScript(brandSimHardDemand, xzBean);
		}
		return script;
	}

}
