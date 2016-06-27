package cn.fangcheng.demand.controller.rest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.bytecode.opencsv.CSVWriter;
import cn.fangcheng.demand.bean.EsStoreXZBean;
import cn.fangcheng.demand.bean.EsStoreZSBean;
import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.demand.bean.demand.ResponseDemandXZ;
import cn.fangcheng.demand.bean.demand.ResponseDemandZS;
import cn.fangcheng.demand.bean.demand.ResponseXZ;
import cn.fangcheng.demand.bean.demand.ResponseZS;
import cn.fangcheng.demand.bean.script.Script;
import cn.fangcheng.demand.bean.script.ScriptAlias;
import cn.fangcheng.demand.service.extra.DemandExService;
import cn.fangcheng.demand.service.extra.UserExService;
import cn.fangcheng.demand.service.other.StorageService;
import cn.fangcheng.demand.servlet.InitServlet;
import cn.fangcheng.demand.tool.FormatUtil;
import cn.fangcheng.demand.tool.JavaNetURLRESTFullClient;
import cn.fangcheng.demand.tool.JsonUtil;
import cn.fangcheng.service.DemandInterface;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 招商选址需求的控制器
 * 
 * @author Administrator
 *
 */
@Controller
public class DemandRestController {
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory
			.getLogger(DemandRestController.class);
	/**
	 * 需求接口
	 */
	@Autowired
	private DemandExService des;
	@Autowired
	private UserExService ues;
	@Autowired
	private MongoTemplate admin;
	@Autowired
	private StorageService ss;
	@Autowired
	private DemandInterface dis;

	/**
	 * 获取招商的es原始数据
	 * 
	 * @param demandId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/demand/zs/{demandId}")
	public @ResponseBody EsStoreZSBean getZSDemandData(
			@PathVariable("demandId") String demandId) throws Exception {
		// out.write(JsonUtil.getJsonStr(des.getDemand(StaticBean.MALL_TYPE,
		// demandId)));
		try {
			return (EsStoreZSBean) des
					.getDemand(StaticBean.MALL_TYPE, demandId);
		} catch (Exception e) {
			return new EsStoreZSBean();
		}
	}

	/**
	 * 获取选址的es原始数据
	 * 
	 * @param demandId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/demand/xz/{demandId}")
	public @ResponseBody EsStoreXZBean getXZDemandData(
			@PathVariable("demandId") String demandId) throws Exception {
		// out.write(JsonUtil.getJsonStr(des.getDemand(StaticBean.MALL_TYPE,
		// demandId)));
		try {
			return (EsStoreXZBean) des.getDemand(StaticBean.BRAND_TYPE,
					demandId);
			// logger.info("xz:" + JsonUtil.getJsonStr(xz));
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return new EsStoreXZBean();
	}

	/**
	 * 添加新需求
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/demand/test")
	public @ResponseBody Object test(@RequestBody String str) throws Exception {
		try {
			logger.info("进入 修改数据:" + str);
		
		} catch (Exception e) {
			e.printStackTrace();
			return ("false");
		}
		return ("true");
	}

	/**
	 * 添加新需求
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/demand/add")
	public @ResponseBody Object addDemandData(@RequestBody String str) throws Exception {
		RequestDemand demand = null;
		try {
			ObjectNode obj = JsonUtil.parse(str);
			//logger.info("进入 修改数据:" + str);
			demand = new RequestDemand(0, 0, 0, 0L, 0L, (ObjectNode) obj.get("demand"), dis);
		} catch (Exception e) {
			e.printStackTrace();
			return ("error params");
		}
		try {
			// logger.info(JsonUtil.getJsonStr(new RequestDemand()));
			// logger.info(JsonUtil.getJsonStr(de));
			if (demand.type != StaticBean.MALL_TYPE && demand.type != StaticBean.BRAND_TYPE) {
				return ("error params");
			} else {
				// 一定不往别名表中传入数据
				return Boolean.toString(des.addDemand(demand, null));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	/**
	 * 添加新需求
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/demand/addNew/{demandId}")
	public @ResponseBody Object addDemandDataNewId(
			@PathVariable("demandId") String demandId) throws Exception {
		try {
			DB mongo = admin.getDb().getMongo().getDB("fangcheng_v2");
			DBObject qury=new BasicDBObject();
			qury.put("_id", new ObjectId("demandId"));
			DBCursor cursor = mongo.getCollection("demand").find(qury);
			boolean flag = false;
			while (cursor.hasNext()) {
				try {
					DBObject obj = (DBObject) cursor.next();
					String id = obj.get("_id").toString();
					obj.removeField("_id");
					obj.put("_id", id);
					RequestDemand demand = new RequestDemand(0, 0, 0, 0L, 0L,
							JsonUtil.parse(obj.toString()), dis);
					// 如果状态为无效并且为测试用户则跳过--es中不存储无效数据
					if (demand.type == StaticBean.MALL_TYPE) {

						if (!des.isAvailably(demand.zs)) {
							continue;
						}
					} else {
						if (!des.isAvailably(demand.xz)) {
							continue;
						}
					}
					flag = des.addDemand(demand, null);
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			cursor.close();
			return Boolean.toString(flag);
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	/**
	 * 获取推荐的内容
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/demand/re")
	public @ResponseBody Object getReDemandData(@RequestBody String str)
			throws Exception {
		try {
			// logger.error("进入 匹配:"  + str);
			ObjectNode obj = JsonUtil.parse(str);
			int uid = 0;
			if (obj.has("uid")) {
				uid = obj.get("uid").asInt();
			}
			int from = 0;
			if (obj.has("from")) {
				from = obj.get("from").asInt();
			}
			int size = 5;
			if (obj.has("size")) {
				size = obj.get("size").asInt();
			}
			long time = 5;
			if (obj.has("time")) {
				time = obj.get("time").asLong();
			}
			long timeEnd = 2441437877000L;
			if (obj.has("timeEnd")) {
				timeEnd = obj.get("timeEnd").asLong();
			}
			RequestDemand demand = new RequestDemand(uid, from, size, time,
					timeEnd, (ObjectNode) obj.get("demand"), dis);
			// 获取用户信息
			Object list = des.getMatchDemand(demand);
			// logger.info("返回值:" + JsonUtil.getJsonStr(list));
			return list;
			// out.append("请求成功：success"+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object();
	}

	/**
	 * 获取推荐的内容
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/demand/sim")
	public @ResponseBody Object getSimDemandData(@RequestBody String str)
			throws Exception {
		try {
			// logger.info("进入 相似:"  + str);
			ObjectNode obj = JsonUtil.parse(str);
			int uid = 0;
			if (obj.has("uid")) {
				uid = obj.get("uid").asInt();
			}
			int from = 0;
			if (obj.has("from")) {
				from = obj.get("from").asInt();
			}
			int size = 5;
			if (obj.has("size")) {
				size = obj.get("size").asInt();
			}
			long time = 5;
			if (obj.has("time")) {
				time = obj.get("time").asLong();
			}
			long timeEnd = 2441437877000L;
			if (obj.has("timeEnd")) {
				timeEnd = obj.get("timeEnd").asLong();
			}
			RequestDemand demand = new RequestDemand(uid, from, size, time,
					timeEnd, (ObjectNode) obj.get("demand"), dis);
			Object list = des.getSimDemand(demand);
			// logger.info("结果:"+JsonUtil.getJsonStr(list));
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object();
	}

	/**
	 * 获取推荐的内容
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/demand/reHard/{demandId}")
	public @ResponseBody Object getReHardDemandData(@RequestBody String str,
			@PathVariable("demandId") String demandId) throws Exception {
		try {
			// logger.error("进入 匹配:" + demandId + "\t" + str);
			// RequestDemand demand = new RequestDemand();
			// demand.docId = demandId;
			// ObjectNode obj = JsonUtil.parse(str);
			// demand.bid = obj.get("bid").asInt();
			// demand.type = obj.get("type").asInt();
			// demand.from = obj.get("from").asInt();
			// demand.size = obj.get("size").asInt();
			// demand.uid = obj.get("uid").asText();
			// demand.time = obj.get("time").asLong();
			// if (demand.type == 0) {
			// demand.type = StaticBean.MALL_TYPE;
			// }
			// // 获取用户信息
			// return des.getMatchHardDemand(demand);
			// out.append("请求成功：success"+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[0];
	}

	/**
	 * 获取推荐的内容
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/demand/simHard/{demandId}")
	public @ResponseBody Object getSimHardDemandData(@RequestBody String str,
			@PathVariable("demandId") String demandId) throws Exception {
		try {
			// logger.info("进入 相似:" + demandId + ":" + str);
			// RequestDemand demand = new RequestDemand();
			// demand.docId = demandId;
			// ObjectNode obj = JsonUtil.parse(str);
			// demand.bid = obj.get("bid").asInt();
			// demand.type = obj.get("type").asInt();
			// demand.from = obj.get("from").asInt();
			// demand.size = obj.get("size").asInt();
			// demand.uid = obj.get("uid").asText();
			// demand.time = obj.get("time").asLong();
			// if (demand.type == 0) {
			// demand.type = StaticBean.MALL_TYPE;
			// }
			// Object list = des.getSimHardDemand(demand);
			// // logger.info("结果:"+JsonUtil.getJsonStr(list));
			// return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[0];
	}

	/**
	 * 获取推荐的内容
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/user/re/{userId}")
	public @ResponseBody Object[] getUserReDemandData(@RequestBody String str,
			@PathVariable("userId") String userId) throws Exception {
		// try {
		// System.out.println("进入用户 匹配:" + userId);
		// RequestDemand demand = new RequestDemand();
		// demand.uid =userId;
		// demand.bid=1;
		// // 获取用户信息
		// return des.getMatchDemand(demand);
		// // out.append("请求成功：success"+id);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return new Object[0];
	}

	/**
	 * 获取推荐的内容
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/user/sim/{userId}")
	public @ResponseBody Object[] getUserSimDemandData(
			@PathVariable("userId") String userId) throws Exception {
		// try {
		// System.out.println("进入用户 相似:" + userId);
		// RequestDemand demand = new RequestDemand();
		// demand.uid = userId;
		// return des.getSimDemand(demand);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return new Object[0];
	}

	/**
	 * 获取推荐的内容
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/demand/init")
	public void init(PrintWriter out) throws Exception {
		try {
			if (InitServlet.getStatus()) {
				out.append("have one init job starting, Don't repeat ");
			} else {
				InitServlet.setIsInitIndexSearch(false);
				synchronized (InitServlet.lock) {
					InitServlet.runStart();
					try {
						if (initJob()) {
							out.append("init job success");
						} else {
							out.append("error job please scan source code to debug");
						}
					} catch (Exception e) {
						e.printStackTrace();
						out.append("init job error please scan logger file");
					}
					InitServlet.runStop();
				}
				// 多加一层锁防止 redis内容无作用
				InitServlet.setIsInitIndexSearch(true);
			}
		} catch (Exception e) {

			out.append("init job error please scan logger file");
		}
	}

	public synchronized boolean initJob() throws Exception {
		String message = null;
		// 需要先清除所有数据 并新建mapping
		// 获取当前index使用的表
		String str = JavaNetURLRESTFullClient.post2(InitServlet.targetURL + InitServlet.indexTarget + "/_alias", "GET", null, JavaNetURLRESTFullClient.code);
		logger.info("获取对应的_alias:" + str);
		ObjectNode node = JsonUtil.parse(str);
		// 获取使用中的索引正在关联的别名表
		String alias = null;
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
		logger.info("当前使用的别名:" + alias);
		// 获取新的表名
		String newAlias = InitServlet.indexTarget + "_" + FormatUtil.parseDateToString(new Date());
		int countz = 0;
		if (alias != null
				&& alias.length() != InitServlet.indexTarget.length() + 11) {
			countz = Integer.parseInt(alias.substring(InitServlet.indexTarget
					.length() + 11));
		}
		if (newAlias.equals(alias)) {
			// 如果名字重复需求修改
			newAlias += (countz + 1);
		}
		logger.info("新的索引表名:" + newAlias);
		// 获取别名的es操作json
		String aliasAction = ScriptAlias.getAction(InitServlet.indexTarget,alias, newAlias);
		logger.info("修改alias脚本:" + aliasAction);

		// 创建索引
		message = JavaNetURLRESTFullClient.post2(InitServlet.targetURL + newAlias, "PUT", null, JavaNetURLRESTFullClient.code);
		// System.out.println((InitServlet.targetURL+ newAlias));
		// System.out.println("message:"+message);
		if (message.contains("missing") || message.contains("already exists")) {
			message = JavaNetURLRESTFullClient.post2(InitServlet.targetURL + newAlias, "DELETE", null, JavaNetURLRESTFullClient.code);
			// System.out.println("message:delete:"+message);
			message = JavaNetURLRESTFullClient.post2(InitServlet.targetURL + newAlias, "PUT", null, JavaNetURLRESTFullClient.code);
			// System.out.println("message:put:"+message);
			// System.out.println(InitServlet.targetURL
			// + newAlias);
		}
		// 创建mapping
		// System.out.println(InitServlet.mallTargetURL.replaceAll(InitServlet.indexTarget,
		// newAlias) + "_mapping"
		// +"\t"+Script.getEsMapping(StaticBean.MALL_TYPE));
		message = JavaNetURLRESTFullClient.post2(
				InitServlet.brandTargetURL.replaceAll(InitServlet.indexTarget,
						newAlias) + "_mapping", "PUT",
				Script.getEsMapping(StaticBean.BRAND_TYPE),
				JavaNetURLRESTFullClient.code);
		if (message.contains("error")) {
			return false;
		}
		// System.out.println(InitServlet.brandTargetURL.replaceAll(InitServlet.indexTarget,
		// newAlias) + "_mapping"
		// +"\t"+Script.getEsMapping(StaticBean.BRAND_TYPE));
		message = JavaNetURLRESTFullClient.post2(
				InitServlet.mallTargetURL.replaceAll(InitServlet.indexTarget,
						newAlias) + "_mapping", "PUT",
				Script.getEsMapping(StaticBean.MALL_TYPE),
				JavaNetURLRESTFullClient.code);
		if (message.contains("error")) {
			return false;
		}
		DB mongo = admin.getDb().getMongo().getDB("fangcheng_v2");
		DBCursor cursor = mongo.getCollection("demand").find();
		long timer = 0;
		long count = 0;
		long timer2 = 0;
		long timer3 = 0;
		long st = System.currentTimeMillis();
		while (cursor.hasNext()) {
			try {
				DBObject obj = (DBObject) cursor.next();
				long start = System.currentTimeMillis();
				String id = obj.get("_id").toString();
				obj.removeField("_id");
				obj.put("_id", id);
				// if(!id.equals("55add968de833c3b6a8b4569")){
				// continue;
				// }
				// logger.info("进入:"+obj.toString());
				long timeEnd = 2441437877000L;
				RequestDemand demand = new RequestDemand(0, 0, 0, 0L, timeEnd, JsonUtil.parse(obj.toString()), dis);
				demand.fill();
				// 如果状态为无效并且为测试用户则跳过--es中不存储无效数据
				if (demand.isDelete) {
					continue;
				}
				if (demand.type == StaticBean.MALL_TYPE) {
					//System.out.println(JsonUtil.getJsonStr(demand.zs));
					if (!des.isAvailably(demand.zs)) {
						continue;
					}
				} else {
					//System.out.println(JsonUtil.getJsonStr(demand.xz));
					if (!des.isAvailably(demand.xz)) {
						continue;
					}
				}
				long end = System.currentTimeMillis();
				timer += end - start;
				count++;
				start = System.currentTimeMillis();
				boolean flag = des.addDemand(demand, newAlias);
				//System.out.println(flag);
				end = System.currentTimeMillis();
				timer2 += end - start;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		timer3 = System.currentTimeMillis() - st;

		logger.info("总数:" + count + "个");
		logger.info("全部时间耗时:" + timer3 / 1000 + "秒");
		logger.info("平均一个用时:" + timer3 / count);
		logger.info("解析总用时:" + timer / 1000 + "秒");
		logger.info("平均用时:" + timer / count + "毫秒");
		logger.info("解析总用时:" + timer2 / 1000 + "秒");
		logger.info("平均用时:" + timer2 / count + "毫秒");
		// 调用es，别名修改脚本
		logger.info("别名脚本：" + InitServlet.targetURL + "_aliases -XPOST -d " + aliasAction);
		logger.info("修改别名表索引指向到:" + newAlias);
		logger.info(JavaNetURLRESTFullClient.post2(InitServlet.targetURL + "_aliases", "POST", aliasAction, JavaNetURLRESTFullClient.code));
		// 删除旧的索引 如果为第一次则不存在
		if (alias == null || alias.equals("")) {
		} else {
			logger.info("删除旧的索引指向:" + alias);
			logger.info(JavaNetURLRESTFullClient.post2(InitServlet.targetURL + alias, "DELETE", aliasAction, JavaNetURLRESTFullClient.code));
		}
		// InitServlet.runStop();
		return true;
	}

	/**
	 * 获取推荐的内容
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/demand/export")
	public void export(PrintWriter out) throws Exception {
		if (export("excel", 0, 50)) {
			out.append("export job success");
		} else {
			out.append("have one export job starting, Don't repeat ");
		}
		out.close();
	}

	@SuppressWarnings("unused")
	public boolean export(String category, int from, int size) throws Exception {
		String exportDir = "f://demand/";
		if (category.equals("excel")) {
			File dirFile = new File(exportDir);
			if (dirFile.exists()) {
				dirFile.delete();
				dirFile = new File(exportDir);
			} else {

			}
			dirFile.mkdirs();
			dirFile = null;
			dirFile = new File(exportDir + "match");
			dirFile.mkdirs();
			dirFile = null;
			dirFile = new File(exportDir + "sim");
			dirFile.mkdirs();
			dirFile = null;
			DB mongo = admin.getDb().getMongo().getDB("fangcheng_v2");
			DBCursor cursor = mongo.getCollection("demand").find();
			while (cursor.hasNext()) {
				DBObject obj = (DBObject) cursor.next();
				// logger.info("进入:"+obj.toString());
				String id = obj.get("_id").toString();
				obj.removeField("_id");
				obj.put("_id", id);
				long timeEnd = 2441437877000L;
				RequestDemand demand = new RequestDemand(0, from, size, 0L,
						timeEnd, JsonUtil.parse(obj.toString()), dis);
				// 需要数据自己的数据集

				Object own = null;
				if (demand.zs == null) {
					des.getDemandResponse(demand.xz.getDemand_type(),
							demand.xz.get_id());
				} else {
					des.getDemandResponse(demand.zs.getDemand_type(),
							demand.zs.get_id());
				}
				if (own == null) {
					continue;
				}
				// logger.info("获取数据为:" + JsonUtil.getJsonStr(own));
				for (int k = 0; k < 2; k++) {
					boolean nameBoolean = true;
					List<String> exportName = new ArrayList<String>();
					exportName.add("score");
					Object[] responseList = null;
					String dir = null;
					try {
						if (k == 0) {
							dir = "match";
							if (demand.type == StaticBean.MALL_TYPE) {
								responseList = ((ResponseXZ) des
										.getMatchDemand(demand)).hits;
							} else {
								responseList = ((ResponseZS) des
										.getMatchDemand(demand)).hits;
							}
						} else {
							dir = "sim";
							if (demand.type == StaticBean.MALL_TYPE) {
								responseList = ((ResponseZS) des
										.getSimDemand(demand)).hits;
							} else {
								responseList = ((ResponseXZ) des
										.getMatchDemand(demand)).hits;
							}
						}
					} catch (Exception e) {
						continue;
					}
					// 导出excel

					File file = null;
					if (demand.type == StaticBean.MALL_TYPE) {
						file = new File(exportDir + dir + "/"
								+ demand.zs.get_id() + ".csv");
					} else {
						file = new File(exportDir + dir + "/"
								+ demand.xz.get_id() + ".csv");
					}
					// logger.warn(exportDir+dir+"/"+ demand.docId + ".csv");
					Writer writer = new FileWriterWithEncoding(file, "gb2312");
					CSVWriter csvWriter = new CSVWriter(writer, ',');

					for (int j = -1; j < responseList.length; j++) {
						double score = 0d;
						Object response = null;
						if (j == -1) {
							if (demand.type == StaticBean.MALL_TYPE) {
								ResponseDemandZS azn = (ResponseDemandZS) own;
								// response = azn._source;
								score = azn._score;
							} else {
								ResponseDemandXZ azn = (ResponseDemandXZ) own;
								// response = azn._source;
								score = azn._score;
							}
						} else {
							if (k == 0) {
								if (demand.type == StaticBean.MALL_TYPE) {
									ResponseDemandXZ zs = ((ResponseDemandXZ) responseList[j]);
									// response = zs.get_source();
									score = zs._score;
								} else {
									ResponseDemandZS xz = ((ResponseDemandZS) responseList[j]);
									// response = xz.get_source();
									score = xz._score;
								}
							} else {
								if (demand.type == StaticBean.MALL_TYPE) {
									ResponseDemandZS zs = ((ResponseDemandZS) responseList[j]);
									// response = zs.get_source();
									score = zs._score;
								} else {
									ResponseDemandXZ xz = ((ResponseDemandXZ) responseList[j]);
									// response = xz.get_source();
									score = xz._score;
								}
							}
						}
						HashMap<String, String> list = new HashMap<String, String>();
						list.put("score", Double.toString(score));
						// Class classTypeSource = null;
						// if (response instanceof DemandZS) {
						// classTypeSource = DemandZS.class;
						// } else {
						// classTypeSource = DemandXZ.class;
						// }
						Class classType = response.getClass();
						Field[] filedObj = classType.getDeclaredFields();
						for (int i = 0; i < filedObj.length; i++) {
							try {
								Field field = filedObj[i];
								String fieldName = field.getName();
								String useName = fieldName;
								// System.out.println("copy:"+fieldName);
								if (fieldName.equals("serialVersionUID")) {
									continue;
								}
								if (nameBoolean) {
									if (fieldName.equals("mall_name")
											|| fieldName.equals("brand_name")) {
										useName = "name";
									} else if (fieldName.equals("mall_id")
											|| fieldName.equals("brand_id")) {
										useName = "id";
									}
									exportName.add(useName);

								}
								String firstLetter = fieldName.substring(0, 1)
										.toUpperCase();
								// 获得和属性对应的getXXX（）方法的名字
								String getMethodName = "get" + firstLetter
										+ fieldName.substring(1);
								// 获得和属性对应的getXXX()方法
								Method getMethod = classType.getMethod(
										getMethodName, new Class[] {});
								// 调用原对象的getXXX()方法
								Object value2 = getMethod.invoke(response,
										new Object[] {});
								if (value2 == null) {
									list.put(useName, value2 + "");
								} else if (value2.getClass().isArray()) {
									list.put(useName,
											JsonUtil.getJsonStr(value2));
								} else {
									list.put(useName,
											JsonUtil.getJsonStr(value2));
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						// filedObj = classType.getDeclaredFields();
						// for (int i = 0; i < filedObj.length; i++) {
						// try {
						// Field field = filedObj[i];
						// String fieldName = field.getName();
						// // System.out.println("copy:"+fieldName);
						// if (fieldName.equals("serialVersionUID")) {
						// continue;
						// }
						// String useName=null;
						// if (fieldName.equals("mall_name")
						// || fieldName.equals("brand_name")) {
						// exportName.add("name");
						// useName = "name";
						// } else if (fieldName.equals("mall_id")
						// || fieldName.equals("brand_id")) {
						// exportName.add("id");
						// useName = "id";
						// }
						// String firstLetter = fieldName.substring(0, 1)
						// .toUpperCase();
						// // 获得和属性对应的getXXX（）方法的名字
						// String getMethodName = "get" + firstLetter
						// + fieldName.substring(1);
						// // 获得和属性对应的getXXX()方法
						// Method getMethod = classTypeSource.getMethod(
						// getMethodName, new Class[] {});
						// // 调用原对象的getXXX()方法
						// Object value2 = getMethod.invoke(response,
						// new Object[] {});
						// if (value2 == null) {
						// list.put(valueMap.get(useName),null);
						// } else if (value2.getClass().isArray()) {
						// list.put(valueMap.get(useName),JsonUtil.getJsonStr(value2));
						// } else {
						// list.put(valueMap.get(useName),JsonUtil.getJsonStr(value2));
						// }
						// } catch (Exception e) {
						// e.printStackTrace();
						// }
						// }
						String[] arr = new String[exportName.size()];
						for (int i = 0; i < exportName.size(); i++) {
							arr[i] = list.get(exportName.get(i)) == null ? null
									: list.get(exportName.get(i)).replace(",",
											"，");
						}
						if (nameBoolean) {
							String[] name = (String[]) exportName.toArray(new String[exportName.size()]);
							csvWriter.writeNext(name);
						}
						nameBoolean = false;
						csvWriter.writeNext(arr);
					}
					csvWriter.close();
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// File file = new File("F:/demand/" + "1.csv");
		//
		// Writer writer = new FileWriterWithEncoding(file, "gb2312");
		// String[] list = new String[] { "asdf", "多少了" };
		// CSVWriter csvWriter = new CSVWriter(writer, ',');
		// csvWriter.writeNext(list);
		// csvWriter.close();

		String exportDir = "f:/demand/";
		File dirFile = new File(exportDir);
		if (dirFile.exists()) {
			dirFile.delete();
		} else {

		}
		dirFile.mkdirs();
		dirFile = null;
		dirFile = new File(exportDir + "match");
		dirFile.mkdirs();
		dirFile = null;
		dirFile = new File(exportDir + "sim");
		dirFile.mkdirs();
		dirFile = null;
	}
}
