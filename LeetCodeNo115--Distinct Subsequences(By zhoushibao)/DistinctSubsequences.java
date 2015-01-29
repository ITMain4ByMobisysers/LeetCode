package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequences {
	/**
	 * 解法一
	 * @param S
	 * @param T
	 * @return
	 */
	public int numDistinct(String S, String T) {
		if (S.length() == 0 || T.length() == 0 || S.length() < T.length()) {
			return 0;
		}

		ArrayList<Map<Integer, Integer>> frequence = new ArrayList<Map<Integer, Integer>>();
		for (int i = 0; i <= T.length(); i++) {
			if (i == 0) {
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				map.put(-1, 1);
				frequence.add(map);
			} else {
				frequence.add(null);
			}
		}
		for (int i = 0; i < S.length(); i++) {
			for (int j = 0; j < T.length(); j++) {
				if (S.charAt(i) == T.charAt(j)
						&& i <= S.length() - (T.length() - j)) {
					Map<Integer, Integer> tmp = frequence.get(j + 1);
					if (tmp == null) {
						tmp = new HashMap<Integer, Integer>();
						tmp.put(i, 0);
						frequence.set(j + 1, tmp);
					} else {
						frequence.get(j + 1).put(i, 0);
					}
				}
			}
		}
		Map<Integer, Integer> rslt = frequence.get(0);
		int count = 0;
		for (int i = 1; i < frequence.size(); i++) {
			Map<Integer, Integer> tmp = frequence.get(i);
			rslt = compareTwoArray(rslt, tmp);
		}
		rslt = frequence.get(T.length());
		if (rslt != null) {
			for (Map.Entry<Integer, Integer> entry : rslt.entrySet()) {
				count += entry.getValue();
			}
		}
		return count;
	}

	public Map<Integer, Integer> compareTwoArray(Map<Integer, Integer> a,
			Map<Integer, Integer> b) {
		if (a == null || b == null) {
			return null;
		}
		for (Map.Entry<Integer, Integer> aentry : a.entrySet()) {
			for (Map.Entry<Integer, Integer> bentry : b.entrySet()) {
				if (aentry.getKey().intValue() < bentry.getKey().intValue()) {
					bentry.setValue(bentry.getValue() + aentry.getValue());
				}
			}
		}
		return b;
	}
	/**
	 * 解法二
	 * @param S
	 * @param T
	 * @return
	 */
	/*public int numDistinct(String S, String T) {
		String[] ss = S.split(" ");
		if (S == null || T == null)
			return 0;
		int occu[] = new int[T.length()];
		for (int i = S.length() - 1; i >= 0; i--) {
			for (int j = 0; j < T.length(); j++) {
				if (S.charAt(i) == T.charAt(j)) {
					if (j == (T.length() - 1))
						occu[j]++;
					else
						occu[j] += occu[j + 1];
				}
			}
		}
		return occu[0];
	}*/

	public static void main(String[] args) {
		String s = "";
		String[] ss = s.split("_");
		long start = System.currentTimeMillis();
		System.out.println(new DistinctSubsequences().numDistinct(
				"subsequences", "se"));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
