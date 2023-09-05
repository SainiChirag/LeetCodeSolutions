package com.chirag;/*
 * Solution to https://leetcode.com/problems/merge-sorted-array/
 * 
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * 
 */
//[5, 0, 0, 0, 0], 1 , [1, 2, 3 , 4], 4

// fastest solution is to have two pointers that point to the end of the values of the arrays. 
// compare the values, the greateer one moves to the end of the original array. 
// keey a pointer to the end of values as well to indicate the position of the new value
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr = nums1.length -1;
        while ( m > 0 && n > 0 ) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[ptr] = nums1[m-1];
                m = m-1;
            }
            else if ( nums1[m-1] <= nums2[n-1]) {
                nums1[ptr] = nums2[n-1];
                n = n-1;
            }
            ptr = ptr - 1;
        }
        // for conditios where the first array's data is finished.
        // when the second array's data is finished, the first array
        // already has the values in the correct place so no need to have the other way round.
        if (n > 0) {
            for (int i = 0 ; i < n ; i ++ ) {
                nums1[i] = nums2[i];
            }
        }    
    }
}
