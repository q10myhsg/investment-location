package cn.fangcheng.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

public class Project_Tool {

	public static void main(String[] args) {
		
		
	}
	/**
	 * 将数据时间节点放入map中
	 */
	public static Map<String,Integer> setNum_map(String[] list_time){
		Map<String,Integer> num_map = new HashMap<String,Integer>();
		for(int i=0;i<list_time.length;i++){
			num_map.put(list_time[i], 0);
		}
		return num_map;
	}
	/**
	 * 生成csv文件
	 */
	public static void createCSV(List<JSONObject> coll,String path) {
		System.out.println("11111111111111------------------------------------");
		try {
			//value.shopType	value.shopName	value.shopnum	value.monthlyHits_a	value.wishTotal_a	value.score_a	value.voteTotal_a	value.popularity_a

			FileWriter fw = new FileWriter(path);
			fw.write("shopType,");
			fw.write("shopName,");
			fw.write("shopnum,");
			fw.write("monthlyHits_a,");
			fw.write("wishTotal_a,");
			fw.write("score_a,");
			fw.write("voteTotal_a,");
			fw.write("popularity_a");
			fw.write("\r\n");
			for (int i=0;i<coll.size();i++) {
				//System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		        try {
					fw.write(coll.get(i).getString("shopType")+",");
					fw.write(coll.get(i).getString("shopName")+",");
			        fw.write(coll.get(i).getString("shopnum")+",");
			        fw.write(coll.get(i).getString("monthlyHits_a")+",");
			        fw.write(coll.get(i).getString("wishTotal_a")+",");
			        fw.write(coll.get(i).getString("score_a")+",");
			        fw.write(coll.get(i).getString("voteTotal_a")+",");
			        fw.write(coll.get(i).getString("popularity_a"));
			        fw.write("\r\n");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	        fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 读取文件
	 */
	public static List<String> readfile(String filePath){
		List<String> list = new ArrayList<String>();
		try{
			String encoding="utf-8";
	        File file=new File(filePath);
	        if(file.isFile() && file.exists()){ //判断文件是否存在
	            InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
	            BufferedReader bufferedReader = new BufferedReader(read);
	            String lineTxt = null;
	            while((lineTxt = bufferedReader.readLine()) != null){
	            	list.add(lineTxt);
	            }
	            read.close();
			}else{
			    System.out.println("找不到指定的文件");
			}
		}catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
		return list;
	}
	
	public static String getSpecificStr(String idStr,String configpath) {
		Pattern pat = Pattern.compile("Begin_" + idStr + "\r\n([\\s\\S]*)End_"+ idStr + "\r\n", Pattern.DOTALL);
		String str = readFileByLines(configpath);
		Matcher mat = pat.matcher(str);
		String ret = "";
		if (mat.find()) {// 注意，只要字符串里有这个模式，find()就能把它给找出来，但是lookingAt()和matches()，只有在字符串与正则表达式一开始就相匹配的情况下才能返回true。matches()成功的前提是正则表达式与字符串完全匹配，而lookingAt()成功的前提是，字符串的开始部分与正则表达式相匹配。
			ret = mat.group(1).trim();// group()中记录了所有符合指定表达式的字符串
		}
		if (ret == null)
			return null;
		else
			return ret;
	}
	//	 按行读取文件
	public static String readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				sb.append(clearNote(tempString) + "\r\n");// 去掉注释
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return sb.toString();// #value#替换成?,与代码不冲突，参数的问题应该是Object
	}
	
	// 去掉注释，--后面的就是注释
	public static String clearNote(String lineStr) {
		Pattern pat = Pattern.compile(".\\*(\\-\\-.\\*)");
		Matcher mat = pat.matcher(lineStr);
		if (mat.find()) {
			lineStr = lineStr.replaceAll(mat.group(1), "");
		}

		return lineStr;
	}
	/**
	 * append==true不新建文件，继续写到文件尾
	 */
	public static void writeFile(String str,String path,boolean append){
		FileWriter fw;
		BufferedWriter bf;
		try{
			//append==true不新建文件，继续写到文件尾,如果没有第二个参数或者第二个参数为false则新建文件
			fw = new FileWriter(path,append);
			//创建字符输出流对象 
			bf = new BufferedWriter(fw);
			//创建缓冲字符输出流对象
			bf.append(str);
			bf.newLine();
			bf.flush();
			bf.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//通过路径和编码读取指定文件返回lixt列表
	public static List<String> readFileStr(String path,String encoding){
		List<String> list = new ArrayList<String>();
		try {
            //String encoding="utf-8";
            File file=new File(path);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	//System.out.println(lineTxt);
                    list.add(lineTxt);
                }
                read.close();
		    }else{
		        System.out.println("找不到指定的文件");
		    }
	    } catch (Exception e) {
	        System.out.println("读取文件内容出错");
	        e.printStackTrace();
	    }
		
		return list;
	}
	public static List<Integer> readFileInt(String path,String encoding){
		List<Integer> list = new ArrayList<Integer>();
		try {
            //String encoding="utf-8";
            File file=new File(path);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	//System.out.println(lineTxt);
                    list.add(Integer.parseInt(lineTxt));
                }
                read.close();
	    }else{
	        System.out.println("找不到指定的文件");
	    }
	    } catch (Exception e) {
	        System.out.println("读取文件内容出错");
	        e.printStackTrace();
	    }
		
		return list;
	}
	//获取指定时间
    //时间模板一定要按正常格式来编写(yyyy-MM-dd HH:mm:ss)MM和HH一定要大写
    public static String getTime(String timemoban,int num){
    	Calendar cal = Calendar.getInstance() ;
    	SimpleDateFormat format = new SimpleDateFormat(timemoban);
		if(timemoban.endsWith("yyyy")){
			cal.add(Calendar.YEAR, -num);
		}else if(timemoban.endsWith("MM")){
			cal.add(Calendar.MONTH, -num);
		}else if(timemoban.endsWith("HH")){
			cal.add(Calendar.HOUR_OF_DAY, -num);
		}else{
			cal.add(Calendar.DAY_OF_MONTH,-num);
		}
        return format.format(cal.getTime());
	}
}
