package com.vlat.medium;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
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
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));

        ListNode res = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.print("\n[");
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.print("]");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumHead = l1;
        ListNode currentNode = sumHead;
        int savedSum = 0;

        while (l1 != null || l2 != null){
            if(savedSum == 0 && (l1 == null || l2 == null)) break;
            int sum = savedSum;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            if(sum < 10){
                savedSum = 0;
                currentNode.val = sum;
            }else{
                savedSum = sum / 10;
                currentNode.val = sum % 10;
            }

            if(currentNode.next != null){
                currentNode = currentNode.next;
            } else if (l1 == null && l2 != null) {
                currentNode.next = l2;
                currentNode = l2;
            }else if (l1 == null && l2 == null){
                if(savedSum > 0){
                    currentNode.next = new ListNode(savedSum, null);
                }
            }
        }

        return sumHead;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
