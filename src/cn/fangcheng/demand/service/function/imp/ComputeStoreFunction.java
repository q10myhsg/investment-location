package cn.fangcheng.demand.service.function.imp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.Feature;
import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.demand.service.function.ComputeScoresFunctionService;
import cn.fangcheng.demand.service.function.ModelService;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;
import cn.fangcheng.mybatis.po.PassportActivity;

@Service
public class ComputeStoreFunction implements ComputeScoresFunctionService {

	@Autowired
	ModelService ms;

	@Override
	public EsStoreZSBean computeFeature(Feature feature)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EsStoreZSBean computeFeature(RequestDemand demand, PassportActivity userFeature, Mall mallFeature, DemandZS feature)  throws Exception{
		// TODO Auto-generated method stub
		EsStoreZSBean es = copy(demand, userFeature, mallFeature, feature);
		es.init();
		return ms.computeFeature(es, demand, userFeature, mallFeature, feature);
	}

	@Override
	public EsStoreXZBean computeFeature(RequestDemand demand, PassportActivity userFeature, Brand brandFeature, DemandXZ feature) throws Exception {
		// TODO Auto-generated method stub
		EsStoreXZBean es = copy(demand, userFeature, brandFeature, feature);
		es.init();
		return ms.computeFeature(es, demand, userFeature, brandFeature, feature);
	}

	/**
	 * 将 feature内容copy到 bean中
	 * 
	 * @param demand
	 * @param userFeature
	 * @param val
	 * @param val2
	 * @return
	 */
	public EsStoreZSBean copy(RequestDemand demand, PassportActivity userFeature, Mall mallFeature, DemandZS val2)  throws Exception{
		EsStoreZSBean es = new EsStoreZSBean();
//		es.bid = val2.getMall_id();
//		if(mallFeature!=null)
//		es.bid_name=val2.getMall_name();
		es.info = mallFeature;
		es.user = userFeature;
		// 将feature中的内容 复制到 存储中
		if (val2 != null) {
			Class classType = val2.getClass();
			Class classType2 = EsStoreZSBean.class;
			while (true) {
				Field[] filedObj = classType.getDeclaredFields();
				for (int i = 0; i < filedObj.length; i++) {
					try {
						Field field = filedObj[i];
						String fieldName = field.getName();
						// System.out.println("copy:"+fieldName);
						if (fieldName.equals("serialVersionUID")) {
							continue;
						}
						String firstLetter = fieldName.substring(0, 1)
								.toUpperCase();
						// 获得和属性对应的getXXX（）方法的名字
						String getMethodName = "get" + firstLetter
								+ fieldName.substring(1);
						// 获得和属性对应的setXXX()方法的名字
						String setMethodName = "set" + firstLetter
								+ fieldName.substring(1);

						// 获得和属性对应的getXXX()方法
						Method getMethod = classType.getMethod(getMethodName,
								new Class[] {});
						// 调用原对象的getXXX()方法
						Object value2 = getMethod.invoke(val2, new Object[] {});

						Method setMethod = null;

						setMethod = classType2.getMethod(setMethodName,
								new Class[] { field.getType() });
						setMethod.invoke(es, new Object[] { value2 });

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				classType = classType.getSuperclass();
				if (classType.equals(Object.class)) {
					break;
				}
			}

		}
		return es;
	}

	/**
	 * 将 feature内容copy到 bean中
	 * 
	 * @param demand
	 * @param userFeature
	 * @param val
	 * @param val2
	 * @return
	 */
	public EsStoreXZBean copy(RequestDemand demand, PassportActivity userFeature,
			Brand brandFeature, DemandXZ val2)  throws Exception{
		EsStoreXZBean es = new EsStoreXZBean();
//		es.bid = val2.getBrand_id();
//		es.bid_name=val2.getBrand_name();
		es.info = brandFeature;
		es.user = userFeature;
		// 将feature中的内容 复制到 存储中
		if (val2 != null) {

			Class classType = val2.getClass();
			Class classType2 = EsStoreXZBean.class;
			while (true) {
				Field[] filedObj = classType.getDeclaredFields();
				for (int i = 0; i < filedObj.length; i++) {
					try {
						Field field = filedObj[i];
						String fieldName = field.getName();
						// System.out.println("copy:"+fieldName);
						if (fieldName.equals("serialVersionUID")) {
							continue;
						}
						String firstLetter = fieldName.substring(0, 1)
								.toUpperCase();
						// 获得和属性对应的getXXX（）方法的名字
						String getMethodName = "get" + firstLetter
								+ fieldName.substring(1);
						// 获得和属性对应的setXXX()方法的名字
						String setMethodName = "set" + firstLetter
								+ fieldName.substring(1);

						// 获得和属性对应的getXXX()方法
						Method getMethod = classType.getMethod(getMethodName,
								new Class[] {});
						// 调用原对象的getXXX()方法
						Object value2 = getMethod.invoke(val2, new Object[] {});

						Method setMethod = null;

						setMethod = classType2.getMethod(setMethodName,
								new Class[] { field.getType() });
						setMethod.invoke(es, new Object[] { value2 });

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				classType = classType.getSuperclass();
				if (classType.equals(Object.class)) {
					break;
				}
			}
		}
		return es;
	}
}
