package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 三种方法
 * @author Administrator
 *
 */
public class MergeKSortedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/*public ListNode mergeKLists(List<ListNode> lists) {
		ListNode rslt = null;
		ListNode pointer = null;
		while(true){
			int min = Integer.MAX_VALUE;
			ListNode tmp = null;
			for(int i = 0; i < lists.size();i ++){
				if(lists.get(i) == null){
					lists.remove(i);
				}
			}
			for(ListNode node:lists){
				if(node != null && node.val <= min){
					tmp = node;
				}
			}
			if(tmp == null){
				break;
			}else{
				if(rslt == null){
					rslt = new ListNode(tmp.val);
					pointer = rslt;
				}else{
					pointer.next = new ListNode(tmp.val);
					pointer = pointer.next;
				}
				int k = lists.indexOf(tmp);
				tmp = tmp.next;
				lists.set(k, tmp);
			}
		}
		return rslt;
	}*/
	/*public ListNode mergeKLists(List<ListNode> lists) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(ListNode node:lists){
			while(node != null){
				pq.add(node.val);
				node = node.next;
			}
		}
		ListNode head = null;
		ListNode tail = null;
		while(pq.size() != 0){
			int min = pq.poll();
			if(head == null){
				head = new ListNode(min);
				tail = head;
			}else{
				tail.next = new ListNode(min);
				tail = tail.next;
			}
		}
		return head;
	}*/
	public ListNode mergeKLists(List<ListNode> lists){
		Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
			@Override
            public int compare(ListNode l1, ListNode l2) { 
                return l1.val - l2.val; 
            }
        });
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
	}
	public static void main(String[] args) {
		List<ListNode> lists = new ArrayList<MergeKSortedList.ListNode>();
		lists.add(new MergeKSortedList().new ListNode(1));
		lists.add(new MergeKSortedList().new ListNode(0));
		new MergeKSortedList().mergeKLists(lists);
	}
}
