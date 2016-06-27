package cn.fangcheng.demand.tool.filemonitor;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.sun.nio.file.ExtendedWatchEventModifier;

//import name.pachler.nio.file.FileSystems;
//import name.pachler.nio.file.Path;
//import name.pachler.nio.file.Paths;
//import name.pachler.nio.file.StandardWatchEventKind;
//import name.pachler.nio.file.WatchEvent;
//import name.pachler.nio.file.WatchKey;
//import name.pachler.nio.file.WatchService;
//import name.pachler.nio.file.ext.ExtendedWatchEventModifier;

/**
 * 文件状态变更监控容器
 * 
 * @author Administrator
 *
 */
public class ClientFileWatch implements Runnable {
	/**
	 * 基础文件时间容器
	 */
	private BlockingQueue<FileStatusBean> queue = new ArrayBlockingQueue<FileStatusBean>(
			200);
	private WatchService watcher;
	
	private long timeOut=3000;
	/**
	 * 使用的目录
	 */
	private String path;
	/**
	 * 过滤掉包含的数据
	 */
	public HashSet<String> filterContain = new HashSet<String>();
	/**
	 * 过滤掉开始的字符
	 */
	public HashSet<String> filterStartsWith = new HashSet<String>();
	/**
	 * 过滤掉结束的字符
	 */
	public HashSet<String> filterEndsWith = new HashSet<String>();

	/**
	 * 初始化
	 */
	public void init() {
		filterContain.add("~");
		filterContain.add("$");
		filterContain.add(".log");
		filterEndsWith.add(".java");
		filterEndsWith.add(".swp");
	}

	public FileStatusBean getEvent() {
		while (true) {
			FileStatusBean bean=null;
			try {
				bean = queue.poll(timeOut,TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (bean != null) {
				return bean;
			}
		}
	}

	/**
	 * linux 不能使用 监控器 也就不能使用目录树
	 * 构造函数
	 * 
	 * @param path
	 *            {@link String}
	 */
	public ClientFileWatch(String dirTree,List<String> dir) {
		this.dirTree = dirTree;
		this.dir=dir;
		if (this.standardEvents == null) {
			this.standardEvents = new WatchEvent.Kind[4];
			this.standardEvents[0] = StandardWatchEventKinds.ENTRY_CREATE;
			this.standardEvents[1] = StandardWatchEventKinds.ENTRY_DELETE;
			this.standardEvents[2] = StandardWatchEventKinds.ENTRY_MODIFY;
			this.standardEvents[3] = StandardWatchEventKinds.OVERFLOW;
		}
		init();
	}

	/**
	 * 使用的事件
	 */
	private WatchEvent.Kind[] standardEvents = null;

	private String dirTree;
	private List<String> dir;
	/**
	 * 
	 * @param dirTree
	 *            监控的目录树
	 * @param dir 目录
	 * @param standardEvents
	 *            使用的监控项目 standardEvents = {
	 *            StandardWatchEventKind.ENTRY_CREATE,
	 *            StandardWatchEventKind.ENTRY_DELETE,
	 *            StandardWatchEventKind.ENTRY_MODIFY,
	 *            StandardWatchEventKind.OVERFLOW };
	 */
	public ClientFileWatch(String dirTree,List<String> dir, WatchEvent.Kind[] standardEvents) {
		this.dirTree = dirTree;
		this.dir=dir;
		this.standardEvents = standardEvents;
		if (this.standardEvents == null) {
			this.standardEvents = new WatchEvent.Kind[4];
			this.standardEvents[0] = StandardWatchEventKinds.ENTRY_CREATE;
			this.standardEvents[1] = StandardWatchEventKinds.ENTRY_DELETE;
			this.standardEvents[2] = StandardWatchEventKinds.ENTRY_MODIFY;
			this.standardEvents[3] = StandardWatchEventKinds.OVERFLOW;
		}
		init();
	}

	@Override
	public void run() {

		try {
			this.filewatch(dirTree,dir);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	
	private void filewatch(String dirTree,List<String> dir) throws Exception {
		watcher = FileSystems.getDefault().newWatchService();
		if(dirTree!=null){
		Path path = Paths.get(dirTree);
		path.register(watcher, standardEvents,
				ExtendedWatchEventModifier.FILE_TREE);
		}else{
			for(String str:dir){
				Path path=Paths.get(str);
				path.register(watcher, standardEvents);
			}
		}
		while (true) {
			WatchKey key = watcher.take();
			List<WatchEvent<?>> list = key.pollEvents();
			key.reset();
			/**
			 * 获取事件列表
			 */
			for (WatchEvent event : list) {
				// 文件名过滤条件
				FileStatusBean bean = new FileStatusBean(event, filterContain,
						filterStartsWith, filterEndsWith);
				this.queue.add(bean);
			}
			if (!key.reset()) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("f:/jsonTest");
		list.add("F:/jsonTest/新建文件夹");
		ClientFileWatch clientFileWater = new ClientFileWatch(null,list);
		Thread thread = new Thread(clientFileWater);
		thread.start();
	}
}