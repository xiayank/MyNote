Sort a linked list in O(n log n) time using constant space complexity.
Example
Given 1->3->2->null, sort it to 1->2->3->null.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow; // prev跟着slow走，但是是slow的上一个node，以便最后prev.next=null，将list分成两半
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);
        return merge(node1, node2);
        
    }
    private ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                head.next = node1;
                node1 = node1.next;
            }else{
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
                
        }
        if(node1 == null)
            head.next = node2;
        if(node2 == null)
            head.next = node1;
        return dummy.next;
    }
    
    
    
    
    
}