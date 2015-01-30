package test;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Given an array and a value, remove all instances of that value in place and return the new length。
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author zhoushibao
 * 
 *
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        int count = 0;
		for(int i = 0; i < A.length; i ++){
			if(A[i] != elem){
				A[count ++] = A[i];
			}
		}
		return count;
    }
}