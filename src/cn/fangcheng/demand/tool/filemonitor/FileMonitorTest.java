package cn.fangcheng.demand.tool.filemonitor;

/**
 * 文件变更监控
 * @author Administrator
 *
 */
public class FileMonitorTest {
	public static void main(String[] args) {
		ClientFileWatch clientFileWater=new ClientFileWatch("f:/jsonTest",null);
		Thread thread=new Thread(clientFileWater);
		thread.start();
		//队列监控器
		while(true){
			System.out.println(clientFileWater.getEvent());
		}
	}
}
