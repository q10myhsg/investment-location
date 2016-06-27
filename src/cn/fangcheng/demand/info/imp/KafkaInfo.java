package cn.fangcheng.demand.info.imp;

import kafka.consumer.ConsumerIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.fangcheng.demand.bean.demand.RequestDemand;
import cn.fangcheng.demand.info.InfoInterface;
import cn.fangcheng.demand.service.extra.DemandExService;
import cn.fangcheng.demand.tool.JsonUtil;
import cn.fangcheng.demand.tool.KafkaUtil;
import cn.fangcheng.service.impl.DemandMapperImpl;

public class KafkaInfo implements InfoInterface {

	public static Logger logger = LoggerFactory.getLogger(KafkaInfo.class);
	/**
	 * 需求接口
	 */
	@Autowired
	DemandExService des=null;
	@Autowired
	DemandMapperImpl dmi=null;
	private KafkaUtil infoUtil = null;
	private String topic = "DEMAND";
	private String groupId = "SITE_DEMAND";
	private String partition = "0";
	ConsumerIterator<String, String> it = null;
	Timer timer = null;

	public KafkaInfo() {
	
	}
	@Override
	public void init(){
		logger.info("kafkaInfo 消息队列启动");
		infoUtil = new KafkaUtil();
		timer = new Timer(infoUtil, topic, groupId);
		timer.start();
	}

	@Override
	public void stopService() {
		// TODO Auto-generated method stub
		timer.setStop();
		while(!timer.isStop()){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class Timer extends Thread {
		private KafkaUtil infoUtil = null;
		private String topic = "DEMAND";
		private String groupId = "SITE_DEMAND";
		ConsumerIterator<String, String> it = null;
		private boolean isRun = true;
		private boolean isStop=true;

		public Timer(KafkaUtil infoUtil, String topic, String groupId) {
			this.infoUtil = infoUtil;
			this.topic = topic;
			this.groupId = groupId;
			getConnection();
		}
		public boolean isStop(){
			return isStop;
		}
		
		public void setStop(){
			this.isRun=false;
		}

		/**
		 * 连接
		 */
		public void getConnection() {

			isStop=true;
			while (true) {
				try {
					if (isRun) {
						it = infoUtil.getConnectioin(groupId, topic).iterator();
						break;
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

		public void run() {
			while (isRun&&it.hasNext()) {
				String msg = it.next().message();
				try {
					RequestDemand demand = (RequestDemand) JsonUtil
							.getDtoFromJsonObjStr(msg, RequestDemand.class);
					des.addDemand(demand,null);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("errorMsg:" + msg);
				}
			}

			isStop=false;
		}
	}

	@Override
	public boolean sendMsg(String msg) {
		// TODO Auto-generated method stub
		return infoUtil.sentMsgs(topic, partition, msg);
	}

	@Override
	public String nextMsg() {
		// TODO Auto-generated method stub
		if (it.hasNext()) {
			return it.next().message();
		}
		return null;
	}

	@Override
	public boolean addMsg(String msg) {
		// TODO Auto-generated method stub
		return false;
	}

}
