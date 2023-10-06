package com.chirag;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

// Solution to Leetcode #9
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNodeFromEndOfLinkedList {
    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        //ListNode four = new ListNode(4);
        //ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        //three.next = four;
        //four.next = five;

        ListNode result = removeNthFromEnd(one, 2);


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Queue<ListNode> myQueue = new ArrayDeque<>(n+1);

        ListNode ptr = head;
        int listSize = 0;
        if (head.next == null)
        {
            if (n == 1)
                return null;
            if (n == 0 )
                return head;
        }
        while (ptr!= null) {
            if (myQueue.size() == n+1) {
                myQueue.remove();
            }
            listSize ++;
            myQueue.add(ptr);
            ptr = ptr.next;
        }
        if (myQueue.size() == listSize) {
            ListNode val = myQueue.peek();
            if ( n == listSize ) {
                return val.next;
            }
            else {
                val.next = null;
                return  val;
            }

        }
        else {
            ListNode a = myQueue.poll();
            myQueue.poll();
            ListNode b = myQueue.poll();
            a.next = b;
            return head;
        }
    }
}
