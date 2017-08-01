Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be any single node in the list. Return the inserted new node.

 Notice

3->5->1 is a cyclic list, so 3 is next node of 1.
3->5->1 is same with 5->1->3

Example
Given a list, and insert a value 4:
3->5->1
Return 5->1->3->4




/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        ListNode newNode = new ListNode(x);
        if(node == null){
            
            newNode.next = newNode;
            return newNode;
        }
        ListNode crut = node.next;
        ListNode prev = node;
        while(crut != node){
           
            if(prev.val <= x && x <= crut.val){
                break;
            }
            if((prev.val > crut.val) && (x > prev.val || x < crut.val)){
                break;
            }
            prev = crut;
            crut = crut.next;
            
        }
        newNode.next = crut;
        prev.next = newNode;
        return newNode;
    }
}