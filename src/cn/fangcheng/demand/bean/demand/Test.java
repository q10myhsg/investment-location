package cn.fangcheng.demand.bean.demand;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String[] arr=new String[]{"asd","d"};
		if(arr.getClass().isArray()){
			System.out.println("true");
		}
		List<String> list=new ArrayList<String>(5);
		if(list instanceof List){
			System.out.println("true");
		}
	}
}
