import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(int[] num) {
		int n = num.length;
		if(n<1) return "";
		String[] strs = new String[n];
		for(int i=0;i<n;i++) {
			strs[i]=String.valueOf(num[i]);
		}
		
		Arrays.sort(strs, new CompareString());
		String result = "";
		for(int i=n-1;i>=0;i--) {
			result+=strs[i];
		}
		int i=0;
		while(i<n&&result.charAt(i)=='0') {
			i++;
		}
		if(i==n) return "0";
		else return result.substring(i);

	}

	class CompareString  implements Comparator<String> {
		public int compare(String a, String b) {
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			sb1.append(a).append(b);
			sb2.append(b).append(a);
			return sb1.toString().compareTo(sb2.toString());
		}
	}
	
	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int[] num = new int[]{3, 30, 34, 5, 9};
		System.out.println(ln.largestNumber(num));
	}

}
