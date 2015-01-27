package test;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * @author zhoushibao
 * 
 * @time:238ms
 *
 */
public class LargestNumber {
	private class Utils implements Comparable<Utils>{
		String num;
		@Override
		public int compareTo(Utils o) {
			// TODO Auto-generated method stub
			return (String.valueOf(o.num)+num).compareTo(num+String.valueOf(o.num));
		}
		
	}
	public String largestNumber(int[] num) {
		ArrayList<Utils> tmps = new ArrayList<Utils>();
		for(int i = 0; i < num.length; i ++){
			Utils tmp = new Utils();
			tmp.num = String.valueOf(num[i]);
			tmps.add(tmp);
		}
		Collections.sort(tmps);//排序
		String result = "";
		int k = 0;
		for(Utils str:tmps){
			result +=str.num;
			if(str.num.equals("0")){
				k ++;
			}
		}
		if(k == num.length){//如果全0则输出0；
			result = "0";
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9}));
	}
}
