package com.chirag;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import static java.util.Collections.sort;

public class KthLargestNumber {

    public static void main(String[] args) {

    }

    public static int findKthLargest(int[] nums, int k) {
// sorting is not to be used ..

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.peek();

    }

    // another approach is to use quickSelect
}
