package com.chirag;

import java.util.*;

// Solution to https://leetcode.com/problems/3sum/
public class ThreeSum {

    public static void main(String[] args) {

        System.out.println(ThreeSumSolution(new int[] {-1,0,1,2,-1,-4}));

    }

    // this solution is correct but exceeds time - Need a lesser complexity solution
    public static List<List<Integer>>ThreeSumSolution (int [] nums) {
        int numOfValues = nums.length;

       List<List<Integer>> retVal = new ArrayList<>();

        for (int i = 0; i < numOfValues; i ++) {
            for (int j = i; j < numOfValues ; j ++) {
                for (int k = j; k < numOfValues ; k ++) {
                    if (nums[i] + nums[j] + nums[k] == 0 ) {
                        if (i!=j && i!= k && j != k) {
                            List<Integer> innerList = new ArrayList<>();
                            innerList.add(nums[i]);
                            innerList.add(nums[j]);
                            innerList.add(nums[k]);

                            Collections.sort(innerList);

                            if (!retVal.contains(innerList)) {
                                retVal.add(innerList);
                            }

                        }
                    }
                }
            }
        }
        // remove duplicates?



        return retVal;
    }
}