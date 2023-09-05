package com.chirag;

/***
 *  Solution to https://leetcode.com/problems/linked-list-cycle/
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }
 

class LinkedListCycle {
    // basic idea is to have 2 pointers, one slow pointer and one fast pointer.
    // slow pointer will on each iteration point to the next node, fast pointer will jump 2 places
    // if there is a cycle in the list, the pointers will eventually point to the same node.
    // if any or both of them are null, there is no cycle.

    public boolean hasCycle(ListNode head) {
        boolean hasCycle = false;
        ListNode ptr1 = head; 
        ListNode ptr2 = head;
        if (ptr1 == null)
        return false;

        while (ptr1.next != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;

            if (ptr1 == null || ptr2 == null ) {
                return false;
            }
            if (ptr1 == ptr2)
                return true;

        }
        
        return hasCycle;
    }


    public static void main(String[] args) {
        
    }
    
}