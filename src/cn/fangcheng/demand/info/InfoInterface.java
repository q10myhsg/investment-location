package cn.fangcheng.demand.info;


public interface InfoInterface {

	/**
	 * 发送消息
	 * @param msg
	 */
	public boolean sendMsg(String msg) throws Exception;
	/**
	 * 初始化
	 */
	public void init() throws Exception;
	/**
	 * 消费消息
	 * @return
	 */
	public String nextMsg() throws Exception;
	/**
	 * 发送新消息
	 * @param msg
	 * @return
	 */
	public boolean addMsg(String msg) throws Exception;
	/**
	 * 停止服务
	 */
	public void stopService() throws Exception;
}
