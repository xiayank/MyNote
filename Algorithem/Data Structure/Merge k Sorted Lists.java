Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.

Have you met this question in a real interview? Yes
Example
Given lists:

[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode>heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });
        for(ListNode node : lists){
            if(node != null){
                heap.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while(!heap.isEmpty()){
            ListNode minNode = heap.poll();
            if(minNode.next != null){
                heap.add(minNode.next);
            }
            head.next = minNode;
            head = head.next;
        }
        return dummy.next;

    }
}
