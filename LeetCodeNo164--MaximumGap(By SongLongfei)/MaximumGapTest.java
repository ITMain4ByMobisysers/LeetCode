/**
 * <p>Title: MaximumGapTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) </p>
 * @author Feifei
 * @date 2015-3-19  上午10:25:19
 * @version 1.0
 */
package ffei.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @Description: 
 * @author  Feifei
 * @date    2015-3-19
 */
public class MaximumGapTest {
	MaximumGap mg = new MaximumGap(); 

	@Test
	public void test() {
		int[] test1 = null;
		int[] test2 = {1};
		int[] test3 = {1, 2};
		int[] test4 = {2, 2};
		int[] test5 = {1, 1, 1, 1};
		int[] test6 = {1, 5, 4, 2};
		int[] test7 = {1, 1, 1, 1, 5, 4, 2, 10};
		
		assertEquals(0, mg.maximumGap(test1));
		assertEquals(0, mg.maximumGap(test2));
		assertEquals(1, mg.maximumGap(test3));
		assertEquals(0, mg.maximumGap(test4));
		assertEquals(0, mg.maximumGap(test5));
		assertEquals(2, mg.maximumGap(test6));
		assertEquals(5, mg.maximumGap(test7));
	}

}
