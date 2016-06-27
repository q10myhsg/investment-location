package cn.fangcheng.demand.test;

import java.util.ArrayList;

public class Test3 {

	public static class Bean {

		public StringBuffer sb = new StringBuffer();
		public Double value = null;
		/**
		 * 如果匹配上
		 */
		public double ttt;
		/**
		 * 没匹配上
		 */
		public double fff;
		/**
		 * 没匹配上
		 */
		public double fft;
		public double ftt;
		public double ftf;

		/**
		 * 获取得分 1为匹配上 2为没匹配上 空 空 3为没匹配上 空 有 4为没匹配上 有 有 5为没匹配上 有 空
		 * 
		 * @param match
		 * @param notMatch
		 * @param empty
		 */
		public Bean(double ttt, double fff, double fft, double ftt, double ftf) {
			this.ttt = ttt;
			this.fff = fff;
			this.fft = fft;
			this.ftt = ftt;
			this.ftf = ftf;
		}

		public Bean(double value, StringBuffer sb) {
			this.value = value;
			this.sb = sb;
		}
		
		public String toString(){
			return sb.toString()+"\tvalue:"+this.value;
		}

		public void setWeight(double value) {
			this.ttt *= value;
			this.fff *= value;
			this.fft *= value;
			this.ftt *= value;
			this.ftf *= value;
		}

		/**
		 *	获取所有分类
		 * @param bean
		 * @return
		 */
		public ArrayList<Bean> getSplit() {
			ArrayList<Bean> list = new ArrayList<Bean>();
			list.add(new Bean(this.ttt, new StringBuffer("ttt")));
			list.add(new Bean(this.fff, new StringBuffer("fff")));
			list.add(new Bean(this.fft, new StringBuffer("ftf")));
			list.add(new Bean(this.ftt, new StringBuffer("ftt")));
			list.add(new Bean(this.ftf, new StringBuffer("ftf")));
			return list;
		}
		/**
		 * 组合
		 * @param list
		 * @return
		 */
		public ArrayList<Bean> join(ArrayList<Bean> list) {
			ArrayList<Bean> re=new ArrayList<Bean>();
			for(int i=0;i<list.size();i++){
				re.add(new Bean(this.value+list.get(i).value,new StringBuffer(this.sb.toString()).append(":").append(list.get(i).sb.toString())));
			}
			return re;
		}
	}
	
	public static ArrayList<Bean> join(ArrayList<Bean> list1,ArrayList<Bean> list2){
		ArrayList<Bean> re=new ArrayList<Bean>();
		for(int i=0;i<list1.size();i++){
			re.addAll(list1.get(i).join(list2));
		}
		return re;
	}
	public static void println(ArrayList<Bean> result){
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}

	public static void main(String[] args) {
		//System.out.println(JavaNetURLRESTFullClient.post2("http://192.168.1.64:9200/search_demand_matching/brand_demand/55a88287de833ce56b8b4568", "GET", null, "utf-8"));
	
		ArrayList<Bean> cat1=new Bean(1,-1,-1,-1,-1).getSplit();
		//System.out.println("cat1");
		Test3.println(cat1);
		ArrayList<Bean> cat2=new Bean(1,-1,-1,-1,-1).getSplit();
		//System.out.println("cat2");
		Test3.println(cat2);
		ArrayList<Bean> cat3=new Bean(1,-1,-1,-1,-1).getSplit();
		//System.out.println("1:2");
		//ArrayList<Bean> temp=new ArrayList<Bean>();
		//temp.add(cat1.get(0));
		//Test3.println(Test3.join(cat1,cat2));
		ArrayList<Bean> result=Test3.join(Test3.join(cat1,cat2),cat3);
		Test3.println(result);
	}
}
