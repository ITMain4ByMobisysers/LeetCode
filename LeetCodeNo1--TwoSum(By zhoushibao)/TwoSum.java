package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
/**
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * 
 *  Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * 
 * Output: index1=1, index2=2
 * 
 * @author Administrator O(nlgn)
 *
 */
public class TwoSum {
	/**
	 * 记录排序后的顺序
	 * @author Administrator
	 *
	 */
	private class Pairs implements Comparable<Pairs>{
		Integer index;
		Integer value;
		@Override
		public int compareTo(Pairs o) {
			// TODO Auto-generated method stub
			if(value.compareTo(o.value) == 0 && index.compareTo(o.index) == 0){
				return -2;
			}else{
				return value.compareTo(o.value);
			}
		}
	}
	public int[] twoSum(int[] numbers, int target) {
        int[] a = new int[2];
        Pairs[] p = new Pairs[numbers.length];
        for(int i = 0; i < numbers.length; i ++){
        	p[i] = new Pairs();
        	p[i].index = i + 1;
        	p[i].value = numbers[i];
        }
        Arrays.sort(p);//nlgn
        for(int i = 0; i < p.length; i ++){//n
        	Pairs tmp = new Pairs();
        	tmp.value = target - p[i].value;
        	tmp.index = p[i].index;
            int index2 = Arrays.binarySearch(p, tmp);//lgn：二分查找
            if(index2 >= 0 && i != index2){
            	a[0] = p[i].index < p[index2].index ? p[i].index: p[index2].index;
            	a[1] = p[i].index < p[index2].index ? p[index2].index: p[i].index;
            	break;
            }
        }
        return a;
    }
	public static void main(String[] args) {
		System.out.println(new TwoSum().twoSum(new int[]{2,1,9,4,4,56,90,3},8));
		System.out.println(Arrays.stream(new int[]{2,1,9,4,4,56,90,3}).toString());
		System.out.println(Arrays.stream(new int[]{2,1,9,4,4,56,90,3}).mapToObj((int n) -> Integer.toString(n)).toString());
		Arrays.stream(new int[]{2,1,9,4,4,56,90,3}).mapToObj((int n) -> Integer.toString(n)).sorted((a, b) -> (b + a).compareTo(a + b)).reduce((a, b) -> ((a.equals("0") && b.equals("0")) ? "0" : a + b)).get();
	}
}
