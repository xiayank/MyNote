Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode node1 = dummy1;
        ListNode node2 = dummy2;
        while(head != null){
            if(head.val < x){
                node1.next = head;
                node1 = node1.next;
            }else{
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }
        node1.next = dummy2.next;
        node2.next = null;
        return dummy1.next;

    }
}
