package cn.fangcheng.demand.bean.script;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.fangcheng.demand.bean.EsResponseFieldsBean;
import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.demand.bean.UserFeature;
import cn.fangcheng.demand.servlet.InitServlet;
import cn.fangcheng.demand.tool.FileUtil2;
import cn.fangcheng.demand.tool.JsonUtil;
import cn.fangcheng.mybatis.po.Brand;
import cn.fangcheng.mybatis.po.DemandXZ;
import cn.fangcheng.mybatis.po.DemandZS;
import cn.fangcheng.mybatis.po.Mall;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Script {

	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(InitServlet.class);

	public static HashMap<String, ScriptCommon> scriptMap = new HashMap<String, ScriptCommon>();

	public static String demand_mall = null;

	public static String demand_brand = null;
	/**
	 * 期望获取的返回数据
	 */
	public static String fieldsString = null;

	public static void init() {
		init2();
		try {
			demand_mall = System.getProperty("user.dir") + "/config/" + "mapping/mall_deamnd_mapping.txt";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			demand_brand = System.getProperty("user.dir") + "/config/" + "mapping/brand_deamnd_mapping.txt";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Entry<String, ScriptCommon> map : scriptMap.entrySet()) {
			logger.info("可用脚本名:" + map.getKey());
		}
	}

	public static void init2() {
		String path = null;
		try {
			// 获取es方法中需要返回的数据
			Field[] fields = EsResponseFieldsBean.class.getDeclaredFields();
			StringBuffer sb = null;
			if (fields.length > 0) {
				sb = new StringBuffer(",\"fields\":[");
			}
			for (int i = 0; i < fields.length; i++) {
				if (i != 0) {
					sb.append(",");
				}
				String bean = InitServlet.beanToEs.get(fields[i].getName());
				if (bean == null) {
					sb.append("\"" + fields[i].getName() + "\"");
				} else {
					sb.append("\"" + bean + "\"");
				}

			}
			if (fields.length > 0) {
				sb.append("]");
				Script.fieldsString = sb.toString();
			}

			fieldsString = ",\"fields\":[\"\"]";
			// 获取脚本内容
			path = Script.class.getClassLoader().getResource("").toURI()
					.getPath()
					+ "script";
			logger.info("读取脚本目录:" + path);
			File[] files = new File(path).listFiles();
			for (File file : files) {
				logger.info("获取脚本:" + file.getName());
				readDemandScript(file);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void readDemandScript(File file) {
		String script = readAllAndClose(file, "", "#");
		// 把返回field关闭
		if (fieldsString != null) {
			script = script.substring(0, script.length() - 1);
			script += fieldsString + "}";
		}
		scriptMap.put(file.getName(), new ScriptCommon(file.getName(), script));
	}

	/**
	 * 获取所有数据 回车分隔符替换为 split
	 * 
	 * @param deleteString
	 *            为 开头为这个的则删除该行
	 * @return
	 */
	public static String readAllAndClose(File file, String split, String deleteString) {
		StringBuffer result = new StringBuffer();
		BufferedReader reader = null;
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
			reader = new BufferedReader(read);
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			// 是否为注释
			while ((tempString = reader.readLine()) != null) {
				if (tempString.length() == 0) {
					continue;
				}
				tempString = tempString.trim();
				if (tempString.trim().startsWith(deleteString)) {
					continue;
				}
				result.append(tempString).append(split);
			}
			try {
				reader.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				read.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return result.toString();
	}

	/**
	 * 获取脚本内容
	 * 
	 * @param scriptName
	 */
	public static String getScript(String scriptName) {
		// Thread.currentThread().getStackTrace()[1].getMethodName();
		ScriptCommon comm = Script.scriptMap.get(scriptName);
		if (comm == null) {
			logger.error("不存在名为:" + scriptName + ".xxx  的脚本");
			return null;
		}
		return comm.get();
	}

	public static String getScript(String scriptName, int obj) {
		// Thread.currentThread().getStackTrace()[1].getMethodName();
		ScriptCommon comm = Script.scriptMap.get(scriptName);
		if (comm == null) {
			logger.error("不存在名为:" + scriptName + ".xxx  的脚本");
			return null;
		}
		return comm.get(obj);
	}

	/**
	 * 获取脚本内容
	 * 
	 * @param scriptName
	 */
	public static String getScript(String scriptName, DemandZS demandZS,
			UserFeature userFeature, Mall mall, int from, int size) {
		// Thread.currentThread().getStackTrace()[1].getMethodName();
		ScriptCommon comm = Script.scriptMap.get(scriptName);
		if (comm == null) {
			logger.error("不存在名为:" + scriptName + ".xxx  的脚本");
			return null;
		}
		ScriptUseBeanZS zs = new ScriptUseBeanZS(demandZS, userFeature, mall,
				from, size);

		return comm.get(zs);
	}

	/**
	 * 获取脚本内容
	 * 
	 * @param scriptName
	 */
	public static String getScript(String scriptName, DemandXZ demandXZ,
			UserFeature userFeature, Brand brand, int from, int size) {
		// Thread.currentThread().getStackTrace()[1].getMethodName();
		ScriptCommon comm = Script.scriptMap.get(scriptName);
		if (comm == null) {
			logger.error("不存在名为:" + scriptName + ".xxx  的脚本");
			return null;
		}
		ScriptUseBeanXZ zs = new ScriptUseBeanXZ(demandXZ, userFeature, brand,
				from, size);
		return comm.get(zs);
	}

	/**
	 * 获取脚本内容
	 * 
	 * @param scriptName
	 */
	public static String getScript(String scriptName, ScriptUseStoreZS zs) {
		// Thread.currentThread().getStackTrace()[1].getMethodName();
		ScriptCommon comm = Script.scriptMap.get(scriptName);
		if (comm == null) {
			logger.error("不存在名为:" + scriptName + ".xxx  的脚本");
			return null;
		}
		return comm.get(zs);
	}

	/**
	 * 获取脚本内容
	 * 
	 * @param scriptName
	 */
	public static String getScript(String scriptName, ScriptUseStoreXZ xz) {
		// Thread.currentThread().getStackTrace()[1].getMethodName();
		ScriptCommon comm = Script.scriptMap.get(scriptName);
		if (comm == null) {
			logger.error("不存在名为:" + scriptName + ".xxx  的脚本");
			return null;
		}
		return comm.get(xz);
	}

	/**
	 * 获取mapping数据
	 * 
	 * @param type
	 * @return
	 */
	public static String getEsMapping(int type) {
		HashMap<String, String> date = new HashMap<String, String>();
		date.put("demand_ctime", "yyyy-MM-dd HH:mm:ss");
		date.put("demand_utime", "yyyy-MM-dd HH:mmm:ss");
		date.put("demand_expiry_at", "yyyy-MM-dd");
		if (type == StaticBean.BRAND_TYPE) {
			EsStoreXZBean es = new EsStoreXZBean();
			Class<?> classType = es.getClass();
			// System.out.println(InitServlet.brandTargetURL);
			String str = InitServlet.brandTargetURL;
			String temp = null;
			if (str.lastIndexOf("/") == str.length() - 1) {
				temp = str.substring(0, str.length() - 1);

			} else {
				temp = str;
			}
			String esTypeName = temp.substring(temp.lastIndexOf("/") + 1,
					temp.length());
			return getMapping(esTypeName, classType, date);
		} else {
			EsStoreZSBean zs = new EsStoreZSBean();
			Class<?> classType = zs.getClass();
			String str = InitServlet.mallTargetURL;
			String temp = null;
			if (str.lastIndexOf("/") == str.length() - 1) {
				temp = str.substring(0, str.length() - 1);

			} else {
				temp = str;
			}
			String esTypeName = temp.substring(temp.lastIndexOf("/") + 1,
					temp.length());

			return getMapping(esTypeName, classType, date);
		}
	}

	/**
	 * 创建mapping脚本文件
	 */
	public static void createEsMapping() {
		Script.init();
		// 获取所有的变量
		// 生成正规mapping
		HashMap<String, String> date = new HashMap<String, String>();
		date.put("demand_ctime", "yyyy-MM-dd HH:mm:ss");
		date.put("demand_utime", "yyyy-MM-dd HH:mmm:ss");

		EsStoreXZBean es = new EsStoreXZBean();
		Class<?> classType = es.getClass();
		String esTypeName = InitServlet.brandTargetURL.substring(0,
				InitServlet.brandTargetURL.length() - 1);
		StringBuffer sb = new StringBuffer();
		sb.append("# create this file is cn.fangcheng.demand.tool.Script.main\n");
		sb.append("curl -XPOST "
		// + esTypeName.substring(0, esTypeName.lastIndexOf("/")+1)
				+ esTypeName + "/_mapping -d ");
		String val = formatJson(sb.append(
				getMapping(esTypeName, classType, date)).toString());
		logger.info("mapping:" + formatJson(val));
		logger.info("file:" + Script.demand_brand);
		FileUtil2 file = new FileUtil2(Script.demand_brand, "utf-8", "delete");
		file.write(val);
		file.close();

		EsStoreZSBean zs = new EsStoreZSBean();
		classType = zs.getClass();
		esTypeName = InitServlet.mallTargetURL.substring(0,
				InitServlet.mallTargetURL.length() - 1);
		sb = new StringBuffer();
		sb.append("# create this file is cn.fangcheng.demand.tool.Script.main\n");
		sb.append("curl -XPOST "
		// + esTypeName.substring(0, esTypeName.lastIndexOf("/")+1)
				+ esTypeName + "/_mapping -d ");
		val = formatJson(sb.append(getMapping(esTypeName, classType, date))
				.toString());
		logger.info("mapping:" + val);
		logger.info("file:" + Script.demand_mall);
		FileUtil2 file2 = new FileUtil2(Script.demand_mall, "utf-8", "delete");
		file2.write(val);
		file2.close();
		;
	}

	/**
	 * 将json格式化为\n格式
	 * 
	 * @param json
	 * @return
	 */
	public static String formatJson(String json) {
		StringBuffer sb = new StringBuffer();
		int skip = -1;
		boolean flag = false;
		for (char val : json.toCharArray()) {
			if (val == '{') {
				skip++;
				if (skip == 0) {
					sb.append("\n");
				}
				sb.append(val).append("\n");
				flag = true;
			} else if (val == '}') {
				sb.append("\n").append(seq('\t', skip)).append(val);
				if (skip == 0) {
					sb.append("");
				}
				skip--;
				flag = true;
			} else if (val == ',') {
				sb.append(val).append("\n");
				flag = true;
			} else {
				if (skip == -1 && flag == true) {
					sb.append(val);
				} else if (flag == true) {
					sb.append(seq('\t', skip)).append(' ').append(val);
				} else {
					sb.append(val);
				}
				flag = false;
			}
		}
		return sb.toString();
	}

	public static String seq(char val, int count) {
		StringBuffer sb = new StringBuffer();
		while (count > 0) {
			count--;
			sb.append(val);
		}
		return sb.toString();
	}

	public static String getMapping(String esTypeName, Class<?> classType,
			HashMap<String, String> date) {
		ObjectNode json = JsonUtil.init();
		ObjectNode mapping = JsonUtil.init();
//		System.out.println(esTypeName);
//		System.out.println("name:"
//				+ esTypeName.substring(esTypeName.lastIndexOf("/") + 1,
//						esTypeName.length()));
		json.replace(esTypeName.substring(esTypeName.lastIndexOf("/") + 1,
				esTypeName.length()), mapping);
		ObjectNode properties = JsonUtil.init();
		mapping.replace("properties", properties);
		StringBuffer sb = new StringBuffer();

		int count = 0;
		while (true) {
			count++;
			if (count != 1) {
				classType = classType.getSuperclass();
			}
			if (classType == null) {
				// logger.info("父类为空");
				break;
			}

			// logger.info("class:" + classType.getName());
			if (!classType.getName().startsWith("cn.fangcheng")) {
				// logger.info("非有效父类");
				break;
			}
			// logger.info("类:" + classType.getName());
			Field[] filedObj = classType.getDeclaredFields();
			for (int i = 0; i < filedObj.length; i++) {
				try {
					Field field = filedObj[i];
					String fieldName = field.getName();
					// System.out.println(fieldName + "\t" + field.getType());
					properties = addNode(properties, fieldName,
							field.getType(), date);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		sb.append(json.toString());
		return sb.toString();
	}

	/**
	 * 添加node
	 * 
	 * @param json
	 * @param fieldName
	 * @param type
	 * @param date
	 *            对应的时间格式
	 * @return
	 */
	public static ObjectNode addNode(ObjectNode json, String fieldName,
			Class<?> type, HashMap<String, String> date) {
		if (fieldName.equals("_id") || fieldName.equals("serialVersionUID")) {
		} else if (type.equals(HashMap.class)) {
		} else if (type.equals(Map.class)) {
		} else {
			ObjectNode node2 = JsonUtil.init();
//			if (date.containsKey(fieldName)) {
//				node2.put("type", "date");
//				node2.put("format", date.get(fieldName));
//				node2.put("index", "not_analyzed");
//				node2.put("store", "no");
//			} else 
				if (type.equals(String.class)) {
				node2.put("type", "string");
				node2.put("index", "not_analyzed");
				node2.put("store", "no");
			} else if (type.equals(Date.class)) {
				node2.put("type", "date");
				node2.put("format", "yyyy-MM-dd");
				node2.put("index", "not_analyzed");
				node2.put("store", "no");
			} else if (type.equals(double.class)) {
				node2.put("type", "double");
				node2.put("store", "no");
			} else if (type.equals(Double.class)) {
				node2.put("type", "double");
				node2.put("store", "no");
			} else if (type.equals(float.class)) {
				node2.put("type", "float");
				node2.put("store", "no");
			} else if (type.equals(Float.class)) {
				node2.put("type", "float");
				node2.put("store", "no");
			} else if (type.equals(Byte.class)) {
				node2.put("type", "byte");
				node2.put("store", "no");
			} else if (type.equals(int.class)) {
				node2.put("type", "integer");
				node2.put("store", "no");
			} else if (type.equals(Integer.class)) {
				node2.put("type", "integer");
				node2.put("store", "no");
			} else if (type.equals(long.class)) {
				node2.put("type", "long");
				node2.put("store", "no");
			} else if (type.equals(Long.class)) {
				node2.put("type", "long");
				node2.put("store", "no");
			} else if (type.equals(int[].class)) {
				node2.put("type", "integer");
				node2.put("store", "no");
			} else if (type.equals(String[].class)) {
				node2.put("type", "string");
				node2.put("index", "not_analyzed");
				node2.put("store", "no");
			} else if (type.equals(long[].class)) {
				node2.put("type", "long");
				node2.put("store", "no");
			} else if(type.getName().equals("java.util.Set"))
			{
				node2.put("type", "string");
				node2.put("index", "not_analyzed");
				node2.put("store", "no");
//				Field[] filedObj = type.getDeclaredFields();
//				Object onnl=type.getComponentType();
//				for (int i = 0; i < filedObj.length; i++) {
//					try {
//						Field field = filedObj[i];
//						String fieldName2 = field.getName();
//						// logger.info("father:"+fieldName+":"+"子类:"+fieldName2
//						// + "\t" + field.getType());
//						node2 = addNode(node2, fieldName2, field.getType(),
//								date);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
			}
			else {
				// 为一个其他类
				ObjectNode node3 = JsonUtil.init();
				node2.replace("properties", node3);
				// 获取子类
				Field[] filedObj = type.getDeclaredFields();
				for (int i = 0; i < filedObj.length; i++) {
					try {
						Field field = filedObj[i];
						String fieldName2 = field.getName();
						// logger.info("father:"+fieldName+":"+"子类:"+fieldName2
						// + "\t" + field.getType());
						node3 = addNode(node3, fieldName2, field.getType(),
								date);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			json.replace(fieldName, node2);
		}

		return json;
	}

	public static void main(String[] args) {
		// Script.createEsMapping();
		String str = "http://192.168.1.64:9200/search_demand_matching/brand_demand/";
		String temp = null;
		System.out.println();
		if (str.lastIndexOf("/") == str.length() - 1) {
			temp = str.substring(0, str.length() - 1);

		} else {
			temp = str;
		}
		System.out.println(temp);
		System.out.println(temp.substring(temp.lastIndexOf("/") + 1,
				temp.length()));
	}

}
