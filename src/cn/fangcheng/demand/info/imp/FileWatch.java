package cn.fangcheng.demand.info.imp;

import java.io.File;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import name.pachler.nio.file.StandardWatchEventKind;
//import name.pachler.nio.file.WatchEvent;
import cn.fangcheng.demand.bean.script.Script;
import cn.fangcheng.demand.tool.filemonitor.ClientFileWatch;
import cn.fangcheng.demand.tool.filemonitor.FileStatusBean;

public class FileWatch extends Thread {
	
	public static Logger logger = LoggerFactory.getLogger(FileWatch.class);
	ClientFileWatch clientFileWater = null;
	public List<String> directory=null;

	public FileWatch(List<String> filePath) {
		directory=filePath;
//		if(!directory.endsWith("/")){
//			directory=directory+"/";
//		}
		WatchEvent.Kind[] standardEvents = { StandardWatchEventKinds.ENTRY_MODIFY,StandardWatchEventKinds.ENTRY_CREATE};
		clientFileWater = new ClientFileWatch(null,filePath, standardEvents);
		Thread thread = new Thread(clientFileWater);
		thread.start();
	}

	public void run() {
		while (true) {
			FileStatusBean status = clientFileWater.getEvent();
			if (status == null) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				if (status.isModify()) {
					logger.info("修改文件:"+status.getFileName());
					if(status.getFileName().equals("storage.properties")&&!status.getFileName().endsWith(".swp")){
						//需要调整storage，方法对应的参数
						//关闭了 而且directory和脚本路径不匹配，将storeage。做成自动判定ip不需要修改
						//InitServlet.readStorageFile();
					}else if(!status.getFileName().endsWith(".swp")){
						Script.readDemandScript(new File(directory+status.getFileName()));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("f:/jsonTest");
		list.add("F:/jsonTest/新建文件夹");
		FileWatch clientFileWater = new FileWatch(list);
		Thread thread = new Thread(clientFileWater);
		thread.start();
	}
}
