package cn.fangcheng.demand.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.fangcheng.demand.bean.script.Script;
import cn.fangcheng.demand.info.InfoInterface;
import cn.fangcheng.demand.info.imp.FileWatch;
import cn.fangcheng.demand.info.imp.RedisInfo;
import cn.fangcheng.demand.tool.JavaNetURLRESTFullClient;
import cn.fangcheng.demand.tool.JsonUtil;
import cn.fangcheng.iptool.IpUtil;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class InitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9058516963173883334L;

	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory.getLogger(InitServlet.class);

	@Autowired
	InfoInterface info = null;
	/**
	 * value 存储es值 x.x
	 */
	public static HashMap<String, String> beanToEs = new HashMap<String, String>();

	/**
	 * value 存储es值 x.x
	 */
	public static HashMap<String, String> esToBean = new HashMap<String, String>();

	public static String brandTargetURL = "http://192.168.1.64:9200/search_demand_matching/brand_demand";
	public static String mallTargetURL = "http://192.168.1.64:9200/search_demand_matching/mall_demand";
	public static String thisURL = "http://127.0.0.1:8080/Investmentocation";

	public static String targetURL = "http://192.168.1.64:9200/";
	public static String indexTarget = "search_demand_matching";

	public static String projectName = null;
	/**
	 * 需求是否初始化开始
	 */
	public static boolean isDemandInitStart = false;
	public static Object lock = new Object();
	/**
	 * 是否为本地测试环境， false 为线上正式环境
	 */
	public static boolean isLocal = false;
	/**
	 * 是否初始化过索引数据
	 */
	public static boolean isInitIndexSearch = false;

	public static boolean isInitIndexSearch() {
		return isInitIndexSearch;
	}

	public static void setIsInitIndexSearch(boolean flag) {
		isInitIndexSearch = flag;
	}

	/**
	 * 开始执行
	 * 
	 * @return
	 */
	public static void runStart() {
		isDemandInitStart = true;
	}

	/**
	 * 执行停止
	 */
	public static void runStop() {
		isDemandInitStart = false;
	}

	public static boolean getStatus() {
		return isDemandInitStart;
	}

	/**
	 * 初始化
	 */
	public void init() {
		logger.info("初始化程序启动");
		//判断是本地运行还是在线上运行  false 为线上正式环境
		isLocal = IpUtil.isLocal();
		// Class classType2 = EsResponseFieldsUsedBean.class;
		// // Field[] fieldArray = classType.getDeclaredFields();
		// Field[] filedObj = classType2.getDeclaredFields();
		// for (int i = 0; i < filedObj.length; i++) {
		// try {
		// Field field = filedObj[i];
		// String fieldName = field.getName();
		// if (fieldName.contains(StaticBean.DOT)) {
		// String fz = fieldName.replaceAll(StaticBean.DOT, "\\.");
		// String fz2 = fieldName
		// .replaceAll(StaticBean.DOT, "\\\\\\.");
		// beanToEs.put(fieldName, fz);
		// esToBean.put(fz2, fieldName);
		// }
		// } catch (Exception e) {
		//
		// }
		// }

		projectName = this.getServletContext().getServletContextName();
		//初始化需求匹配脚本
		Script.init();
		readStorageFile();

		try {
			if (info == null) {
				info = new RedisInfo();
			}
			info.init();
			// 获取使用的插件集合
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		// 需要修改的配置文件地址
		String direction = null;
		logger.info("direction:" + this.getServletContext().getRealPath("/"));
		direction = this.getServletContext().getRealPath("/") + "WEB-INF/classes/script/";
		// /System.exit(1);
		// 启动文件监控容器
		try {
			ArrayList<String> list = new ArrayList<String>();
			list.add(direction);
			FileWatch clientFileWater = new FileWatch(list);
			Thread thread = new Thread(clientFileWater);
			thread.start();
		} catch (Exception e) {

		}
	}

	public static String clearL(String str) {
		if (str != null && str.length() > 1) {
			if (str.startsWith("/")) {
				str = str.substring(1);
			}
			if (str.endsWith("/")) {
				str = str.substring(0, str.length() - 1);
			}
		}
		return str;
	}

	/**
	 * 将_dot_ 转换成 .
	 * 
	 * @param str
	 * @return
	 */
	public static String getTransport(String str) {
		if (str == null) {
			return str;
		}
		for (Entry<String, String> map : beanToEs.entrySet()) {
			// logger.info("map:"+map.getKey()+":"+map.getValue());
			str = str.replaceAll(map.getKey(), map.getValue());
			// logger.info("str:"+str);
		}
		return str;
	}

	/**
	 * 将 . 转换为 _dot_
	 * 
	 * @param str
	 * @return
	 */
	public static String getTransportRel(String str) {
		if (str == null) {
			return str;
		}
		for (Entry<String, String> map : esToBean.entrySet()) {
			// logger.info("mapRel:"+map.getKey()+":"+map.getValue());
			str = str.replaceAll(map.getKey(), map.getValue());
			// logger.info("str:"+str);
		}
		return str;
	}

	public static void readStorageFile() {
		InputStream inputStream = null;
		String path = null;
		try {
			path = JavaNetURLRESTFullClient.class.getClassLoader().getResource("").toURI().getPath();
		} catch (URISyntaxException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			inputStream = new FileInputStream(path + "/storage.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// InputStream inputStream =
		// ServletContext.getResourceAsStream("config/storeage.properties");
		Properties p = new Properties();

		try {

			p.load(inputStream);

		} catch (IOException e1) {

			e1.printStackTrace();

		}
		// logger.info("es.url:" + p.getProperty("es.url"));
		// targetURL=this.getServletContext().getRealPath("/");
		// indexTarget=this.getServletContext().getServletContextName();
		// logger.info("targetURL:"+targetURL);
		// logger.info(this.getServletConfig().getServletContext().getS);
		// logger.info(this.getServletContext().getServletContextName());
		// logger.info(this.getServletContext().getContextPath());
		// logger.info(this.getServletContext().getServerInfo());
		if (isLocal) {
			targetURL = clearL(p.getProperty("es.url"));
		} else {
			targetURL = clearL(p.getProperty("es.url.online"));
		}
		indexTarget = clearL(p.getProperty("es.index"));
		brandTargetURL = clearL(p.getProperty("brand.es.url"));
		mallTargetURL = clearL(p.getProperty("mall.es.url"));
		targetURL = targetURL + "/";
		brandTargetURL = targetURL + indexTarget + "/" + brandTargetURL + "/";
		mallTargetURL = targetURL + indexTarget + "/" + mallTargetURL + "/";
		if (isLocal) {
			if (IpUtil.getIp().equals("192.168.1.11")) {
				// 11 的tomcat7 配置的是80端口 访问路径不存在端口
				thisURL = clearL(p.getProperty("this.url.online")) + "/"
						+ InitServlet.projectName;
			} else {
				thisURL = clearL(p.getProperty("this.url")) + "/"
						+ InitServlet.projectName;
			}
		} else {
			thisURL = clearL(p.getProperty("this.url.online")) + "/"
					+ InitServlet.projectName;
		}
		ObjectNode node = null;
		while (true) {
			try {
				logger.info(InitServlet.targetURL + InitServlet.indexTarget + "/_alias");
				// 获取是否已经创建了对应的索引
				String str = JavaNetURLRESTFullClient.post2(InitServlet.targetURL + InitServlet.indexTarget + "/_alias", "GET", null, JavaNetURLRESTFullClient.code);
				logger.info("获取对应的_alias:" + str);
				node = JsonUtil.parse(str);
				break;
			} catch (Exception e) {

			}
		}
		// 获取使用中的索引正在关联的别名表
		String alias = null;
		if (node != null) {
			Iterator<String> iter = node.fieldNames();
			while (iter.hasNext()) {
				String name = iter.next();
				if (name.equals(InitServlet.targetURL)) {
					break;
				} else {
					alias = name;
				}
			}
			iter = null;
		}
		logger.info("当前使用的别名:" + alias);
		if (alias == null) {
			// 说明还没有初始化需要初始化
			isInitIndexSearch = false;
		} else {
			isInitIndexSearch = true;
		}
	}

	/**
	 * 系统结束时触发 比如可以关闭相关的长连接等
	 */
	public void destory() {
		logger.info("初始化程序启动");
		logger.info("停止消息服务");
		logger.info("初始化程序销毁结束");
		try {
			if (info != null) {
				info.stopService();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.info(e.getMessage());
		}
		logger.info("消息服务已停止");
	}

	public static void main(String[] args) {
		InitServlet init = new InitServlet();
		String str = JavaNetURLRESTFullClient.post2("http://192.168.1.64:9200/search_demand_matching/_alias", "GET", null, JavaNetURLRESTFullClient.code);
		System.out.println(str);
		String alias = null;
		ObjectNode node = null;
		node = JsonUtil.parse(str);
		System.out.println(InitServlet.targetURL);
		if (node != null) {
			Iterator<String> iter = node.fieldNames();
			while (iter.hasNext()) {
				String name = iter.next();
				System.out.println("name:"+name);
				if (name.equals(InitServlet.targetURL)) {
					break;
				} else {
					alias = name;
				}
				System.out.println("alias:"+alias);
			}
			iter = null;
		}
	}
}
