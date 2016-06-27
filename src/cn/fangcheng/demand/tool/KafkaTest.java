package cn.fangcheng.demand.tool;

import kafka.message.MessageAndMetadata;

/**
 * kafka测试方法
 * 
 * @author Administrator
 *
 */
public class KafkaTest {

	public static String split = ",";

	public static String getString(String... strList) {
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (String str : strList) {
			i++;
			if (i == 1) {
				sb.append(str);
			} else {
				sb.append(KafkaTest.split).append(str);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		// jar加载器

		KafkaUtil consumer = new KafkaUtil() {
			@Override
			public void consumer(MessageAndMetadata<String, String> msg) {
				System.out.println("key2:" + msg.key() + "\tinput2:"
						+ msg.message());
				// KafkaTransmitBean
				// kafkaBean=(KafkaTransmitBean)JsonUtil.getDtoFromJsonObjStr(msg.message(),KafkaTransmitBean.class,JsonMappingStatic.kafkaTransmitBeanMap);
				// System.out.println("topic:"+kafkaBean.topic);
				// System.out.println("status:"+kafkaBean.status.execStatus);
				// System.out.println("结束");
				try {
					Thread.sleep(0);
					// Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		// consumer.sentMsgs("HDFS_LOG","1","sldjflsdjf");
		// System.exit(1);
		// 消费者处理消息
		String topic = "test";// TopicStatic.DEBUGE_LOG;//TopicStatic.TEST2;
		// topic="test4";
		String groupId = "consumerTest3";
		// consumer.getMsgs(groupId, topic);
		String key = "0";
		// String
		// temp="\"{\"baidu\":{\"lng\":116.508803,\"lat\":39.809128},\"id\":360,\"name\":\"北京华联力宝购物中心\",\"city\":\"北京\"}\\\"";
		// System.out.println(temp);
		// System.exit(1);
		for (int i = 0; i < 1; i++) {
			// consumer.sentMsgs(kafkaTransmitBean);
			System.out.println("test");
			// consumer.sentMsgs(kafkaTransmitBean);
		}

	}

}
