package cn.fangcheng.iptool;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Set;

/**
 * 用于检测ip 对应的是内网测试环境还是线上环境
 * @author Administrator
 *
 */
public class IpUtil {

	/**
	 * 是否为内网ip
	 * @return
	 */
	public static boolean isLocal(){
		 InetAddress netAddress = getInetAddress();  
		 String ip= getHostIp(netAddress);
	     if(ip.startsWith("192.168.")){
	    	 return true;
	     }
	     return false;
	}
	public static String getIp(){
		 InetAddress netAddress = getInetAddress();  
		 String ip= getHostIp(netAddress);
		 return ip;
	}
	
	  public static void main(String [] args){  
	        InetAddress netAddress = getInetAddress();  
	        System.out.println("host ip:" + getHostIp(netAddress));  
	        System.out.println("host name:" + getHostName(netAddress));  
	        Properties properties = System.getProperties();  
	        Set<String> set = properties.stringPropertyNames(); //获取java虚拟机和系统的信息。  
	        for(String name : set){  
	            System.out.println(name + ":" + properties.getProperty(name));  
	        }  
	    }  
	  
	    public static InetAddress getInetAddress(){  
	  
	        try{  
	            return InetAddress.getLocalHost();  
	        }catch(UnknownHostException e){  
	            System.out.println("unknown host!");  
	        }  
	        return null;  
	  
	    }  
	  
	    public static String getHostIp(InetAddress netAddress){  
	        if(null == netAddress){  
	            return null;  
	        }  
	        String ip = netAddress.getHostAddress(); //get the ip address  
	        return ip;  
	    }  
	  
	    public static String getHostName(InetAddress netAddress){  
	        if(null == netAddress){  
	            return null;  
	        }  
	        String name = netAddress.getHostName(); //get the host address  
	        return name;  
	    }  
}
