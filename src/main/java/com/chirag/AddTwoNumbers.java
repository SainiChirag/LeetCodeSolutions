package com.chirag;
// Solution to LeetCode #2 https://leetcode.com/problems/add-two-numbers/

import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {

    //    ListNode l2 = convertArrayToLinkedList(new int[] {5,6,4});
     //   ListNode l1 = convertArrayToLinkedList(new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});

        ListNode l2 = convertArrayToLinkedList(new int[] {2,4,3});
        ListNode l1 = convertArrayToLinkedList(new int[]{5, 6, 4});

        addTwoNumbers2(l1,l2);


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode result = new ListNode();
        long multiple = 1;
        long num1 = 0;
        long num2 = 0;
        while ( ptr1 != null ) {
            num1 = num1 + (ptr1.val * multiple);
            multiple = multiple * 10;
            ptr1 = ptr1.next;
        }

        multiple = 1;

        while ( ptr2 != null ) {
            num2 = num2 + (ptr2.val * multiple);
            multiple = multiple * 10;
            ptr2 = ptr2.next;
        }


        long sum = num1 + num2;

        String sumString = String.valueOf(sum);
        sumString = new StringBuilder(sumString).reverse().toString();

        ListNode ptr = result;
        for (String c : sumString.split("")) {
            ListNode node = new ListNode(Integer.parseInt(c));
            ptr.next = node;
            ptr= ptr.next;

        }
        result = result.next;

        return result;

    }


    public static ListNode addTwoNumbers2 (ListNode l1, ListNode l2) {
    // in place addition

        ListNode prev = new ListNode();
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2!= null) {
            if (l1 != null && l2 == null) {
                // l2 have not finished .. check carry and add .. else move
                while (l1!= null) {
                    if (carry > 0) {
                        int val  = l1.val + carry;
                        if (val > 9) {
                            val = val %10;
                        }
                        else {
                            carry = 0;
                        }
                        ListNode newNode = new ListNode(val);
                        prev.next = newNode;
                        prev = newNode;
                    } else {
                        prev.next = l1;
                        l1 = null;
                    }

                }

            }
            else if (l1 == null) {
                while (l2!= null) {
                    if (carry > 0) {
                        int val  = l2.val + carry;
                        if (val > 9) {
                            val = val %10;
                        }
                        else {
                            carry = 0;
                        }
                        ListNode newNode = new ListNode(val);
                        prev.next = newNode;
                        prev = newNode;
                    } else {
                        prev.next = l2;
                        l2 = null;
                    }

                }

            }
            else {
                int val = l1.val + l2.val + carry;
                if (val > 9) {
                    carry = 1;
                    val = val % 10;
                }
                else {
                    carry = 0;
                }
                ListNode newNode = new ListNode(val);
                prev.next = newNode;
                prev = newNode;
            }
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;

        }

        if (carry > 0) {
            ListNode ptr = head;
            while (ptr.next != null ) {
                ptr = ptr.next;
            }

            ptr.next = new ListNode(1);
        }


    return head.next;
    }

    public static ListNode convertArrayToLinkedList(int[] nums) { // 2, 4, 3
        int numOfValues = nums.length;
        ListNode prev = null;
        ListNode head = null;
        for (int i = 0; i < numOfValues; i++) {
            ListNode node = new ListNode(nums[i]);
            if (head == null) {
                head = node;
            }
            if (prev != null) {
                prev.next = node;
            }
            prev = node;
        }

        return  head;
    }
}
