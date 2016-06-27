package cn.fangcheng.demand.info.imp;

import java.net.ConnectException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;
import org.springframework.stereotype.Service;

import cn.fangcheng.demand.info.InfoInterface;
import cn.fangcheng.demand.service.extra.DemandExService;
import cn.fangcheng.demand.servlet.InitServlet;
import cn.fangcheng.demand.tool.JavaNetURLRESTFullClient;
import cn.fangcheng.demand.tool.Redis;
import cn.fangcheng.service.impl.DemandMapperImpl;

@Service
public class RedisInfo implements InfoInterface {

	public static Logger logger = LoggerFactory.getLogger(RedisInfo.class);

	/**
	 * 需求接口
	 */
	@Reference()
	DemandExService des = null;
	@Autowired
	DemandMapperImpl dmi = null;
	private static Redis infoUtil = null;
	private String topic = "queue_demand";
	/**
	 * 暂停时间10秒
	 */
	private int cycle = 10000;
	Timer timer = null;

	public RedisInfo() {
	}

	@Override
	public void init() {
		logger.info("redisInfo 消息队列启动");
		if (infoUtil == null) {
			RedisConfig config = new RedisConfig();
			infoUtil = new Redis(config.ipPort, config.maxActive, config.minIdle, config.timeout, config.poolTimeOut);
			this.topic = config.key;
		}
		timer = new Timer(infoUtil, topic);
		timer.start();
	}

	public static void main(String[] args) throws Exception {
		RedisConfig config = new RedisConfig();
		infoUtil = new Redis("192.168.1.134:6379", config.maxActive,config.minIdle, config.timeout, config.poolTimeOut);
		String topic = config.key;
		System.out.println(config.ipPort);
		System.out.println(topic + "2");
		String str = infoUtil.getInfo();
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(str);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
//		List<String> ll = infoUtil.lrange(topic + "2", 0, -1);
//		System.out.println("结果:" + (ll.size() > 0 ? ll.get(0) : "null"));
	}

	@Override
	public void stopService() {
		// TODO Auto-generated method stub
		timer.setStop();
		while (!timer.isStop()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class Timer extends Thread {
		private Redis infoUtil = null;
		private String topic = "queue_demand";
		private boolean isRun = true;
		private boolean isStop = true;

		public Timer(Redis infoUtil, String topic) {
			this.infoUtil = infoUtil;
			this.topic = topic;
			getConnection();
		}

		public boolean isStop() {
			return isStop;
		}

		public void setStop() {
			this.isRun = false;
		}

		/**
		 * 连接
		 */
		public void getConnection() {
			isStop = true;
			while (true) {
				try {
					if (isRun) {
						String str = infoUtil.getInfo();
						if (str != null) {
							break;
						}
					} else {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

		@SuppressWarnings("unused")
		public void run() {
			String json = null;
			List<String> list = null;
			while (isRun) {
				try {
					list = infoUtil.lrange(topic, -1, -1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (list == null || list.size() == 0) {

				} else {
					if (!InitServlet.isInitIndexSearch()) {
						logger.info("请初始化索引信息 并调用 /rest/demand/init GET 方法执行 请求");
					} else {
						json = list.get(0);
						boolean flag = false;
						try {
							// if(demand.has("mall_id")){
							// // demand.remove("brand_id");
							// // demand.remove("brand_name");
							// // DemandMapperImpl
							// imp=Springfactory.getBean("DemandMapperImpl");
							// // ApplicationContext
							// ctx=WebApplicationContextUtils.getWebApplicationContext(servlet.getServletContext());
							// // DemandMapperImpl
							// imp=(DemandMapperImpl)ctx.getBean("demandInterface");
							// // DemandMapperImpl imp=new DemandMapperImpl();
							// // TagMapperImpl tag=new TagMapperImpl();
							// // imp.tag=tag;
							// // tag.tagMapper=new Tag
							// // imp.category=new CategoryImpl();
							// // DemandZS
							// zs=imp.getDemandZSbyJson(demand.toString());
							// DemandZS
							// zs=dmi.getDemandZSbyJson(demand.toString());
							// flag=des.addDemand(zs);
							// }else{
							// // demand.remove("mall_id");
							// // demand.remove("mall_name");
							// // DemandMapperImpl
							// imp=Springfactory.getBean("DemandMapperImpl");
							// // ApplicationContext
							// ctx=WebApplicationContextUtils.getWebApplicationContext(servlet.getServletContext());
							// // DemandMapperImpl
							// imp=(DemandMapperImpl)ctx.getBean("demandInterface");
							// // DemandMapperImpl imp=new DemandMapperImpl();
							// // imp.tag=new TagMapperImpl();
							// // imp.tag.tagMapper=new TagMapperImpl();
							// // imp.category=new CategoryImpl();
							// // DemandXZ
							// xz=imp.getDemandXZbyJson(demand.toString());
							// DemandXZ
							// xz=dmi.getDemandXZbyJson(demand.toString());
							// flag=des.addDemand(xz);
							// }
							String temp = null;
							synchronized (InitServlet.lock) {
								try {
									logger.info("请求地址为:" + InitServlet.thisURL + "/rest/demand/add" + "\t -d " + json);
									temp = JavaNetURLRESTFullClient.post2(3000, 5000, InitServlet.thisURL + "/rest/demand/add", "POST", json, JavaNetURLRESTFullClient.code);
								} catch (ConnectException e) {
									logger.info("请检查请求地址是否正确");
									logger.info("请求地址为:" + InitServlet.thisURL
											+ "/rest/demand/add" + "\t -d "
											+ json);
								} catch (Exception e2) {
									e2.printStackTrace();
								}
							}
							if (temp != null && temp.startsWith("true")) {
								flag = true;
							}
							logger.info("新增需求:" + json + "\t是否成功:" + flag);
							if (flag == true) {
								String znp = infoUtil.rpop(topic);
								if (znp.equals(json)) {
									logger.info("正确添加需求");
									continue;
								} else {
									logger.info("内容不一致");
									logger.info("内容1"+json);
									logger.info("内容2"+znp);
									infoUtil.rpush(topic, znp);
								}
								// 如果成功则继续 不成功 则重复这条记录
								//continue;
							} else {

							}
						} catch (Exception e) {
							e.printStackTrace();
							logger.error("errorMsg:" + json);
						}
					}
				}
				try {
					Thread.sleep(cycle);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			isStop = false;
		}
	}

	@Override
	public boolean sendMsg(String msg) {
		// 队列不发送数据
		return false;
	}

	@Override
	public String nextMsg() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public boolean addMsg(String msg) {
		// TODO Auto-generated method stub
		return false;
	}

}
