package cn.fangcheng.test;

import java.util.Arrays;

public class Test {

	public static double signod(double x){
		return 1/(1+Math.exp(-x));
	}
	
	public static void main(String[] args) {
		System.out.println(signod(10));
		int length=1000000;
		double[] x=new double[length-10];
		for(int i=1000000-10;i<length;i++){
			x[i+10-1000000]=signod(i*1d);
		}
		System.out.println(Arrays.toString(x));
	}
}
