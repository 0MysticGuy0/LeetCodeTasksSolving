package com.vlat.easy;

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.



Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class MiddleOfTheLinkedList {

    private int midIndx = 0;

    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        return getMid(head, -1);
    }
    private ListNode getMid(ListNode node, int lastNodeIndx){
        int currIndx = lastNodeIndx + 1;

        ListNode res = null;
        if(node.next == null){
            midIndx = currIndx / 2;
            if(currIndx % 2 != 0) midIndx++;
        }else{
            res = getMid(node.next, currIndx);
        }

        if(currIndx == midIndx) return node;
        else return res;
    }

    class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
