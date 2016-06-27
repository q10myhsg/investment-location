package cn.fangcheng.demand.bean;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import cn.fangcheng.demand.bean.demand.ResponseDemand;

/**
 * 从es中获取的数据
 * @author Administrator
 *
 */
public class EsResponseBean {
	public String _index = null;

	public String _type = null;

	public String _id = null;

	public double _score;

	public EsResponseFieldsBean fields = null;
	

	public double[] sort;
	/**
	 * 将 EsResponseBean 转换为ResponseDemand
	 * @return
	 */
	public ResponseDemand transportToResponseDemand() {
	//	System.out.println("fields:" + JsonUtil.getJsonStr(fields));
		ResponseDemand demand = new ResponseDemand();
		demand.score = this._score;
		Class<?> classType = fields.getClass();
		Class<?> classType2 = EsResponseFieldsUsedBean.class;
		// Field[] fieldArray = classType.getDeclaredFields();
		Field[] filedObj = classType2.getDeclaredFields();
		for (int i = 0; i < filedObj.length; i++) {
			try {
				Field field = filedObj[i];
				String fieldName = field.getName();
//				if (fieldName.equals("score") || fieldName.equals("docId")) {
//					continue;
//				}
				String firstLetter = fieldName.substring(0, 1).toUpperCase();
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
				Object value2 = getMethod.invoke(fields, new Object[] {});
//				System.out.println(fieldName + ":"
//						+ JsonUtil.getJsonStr(value2));
				// 获得和属性对应的setXXX()方法
				Method setMethod = null;
				// 调用复制对象的setXXX()方法
				if (value2 == null) {
					continue;
				} else if (field.getType().isArray()) {
					setMethod = classType2.getMethod(setMethodName,
							new Class[] { field.getType() });
					setMethod.invoke(demand, new Object[] { value2 });
				} else {
					if (Array.getLength(value2) > 0) {
						setMethod = classType2.getMethod(setMethodName,
								new Class[] { field.getType() });
						setMethod.invoke(demand,
								new Object[] { Array.get(value2, 0) });
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	//	System.out.println("结束");
		return demand;
	}

	public String get_index() {
		return _index;
	}

	public void set_index(String _index) {
		this._index = _index;
	}

	public String get_type() {
		return _type;
	}

	public void set_type(String _type) {
		this._type = _type;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public double get_score() {
		return _score;
	}

	public void set_score(double _score) {
		this._score = _score;
	}

	public EsResponseFieldsBean getFields() {
		return fields;
	}

	public void setFields(EsResponseFieldsBean fields) {
		this.fields = fields;
	}

	public double[] getSort() {
		return sort;
	}

	public void setSort(double[] sort) {
		this.sort = sort;
	}

}
