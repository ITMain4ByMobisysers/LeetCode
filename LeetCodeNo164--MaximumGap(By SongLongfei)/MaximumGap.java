/**
 * <p>Title: MaximumGap.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) </p>
 * @author Feifei
 * @date 2015-3-19  上午9:59:20
 * @version 1.0
 */
package ffei.leetcode;

import sun.print.resources.serviceui;

/**
 * @Description: 
 * @author  Feifei
 * @date    2015-3-19
 */
public class MaximumGap {
	private class Bucket {
		int max;
		int min;
		Bucket(int max, int min) {
			this.max = max;
			this.min = min;
		}
	}
    public int maximumGap(int[] num) {
        if(num == null || num.length < 2)
        	return 0;
        int max = num[0],
        	min = max,
        	length = num.length;
        for(int i = 1; i < length; i++) {
        	if(num[i] < min)
        		min = num[i];
        	if(num[i] > max)
        		max = num[i];
        }
        if(min == max) 
        	return 0;
        double averageGap = Math.ceil((max - min) / (length - 1.0));
        Bucket[] buckets = new Bucket[length];
        for(int i = 0; i < length; i ++) {
        	int index = (int)Math.floor((num[i] - min) / averageGap);
        	if(buckets[index] == null)
        		buckets[index] = new Bucket(num[i], num[i]);
        	else {
				buckets[index].max = Math.max(buckets[index].max, num[i]);
				buckets[index].min = Math.min(buckets[index].min, num[i]);
			}
        }
        int maxGap = 0;
        int lastBucket = 0;
        for(int i = 0; i < buckets.length; i++) {
        	if(buckets[i] != null) {
        		maxGap = Math.max(buckets[i].min - buckets[lastBucket].max, maxGap);
        		lastBucket = i;
        	}
        }
        return maxGap;
    }
}
