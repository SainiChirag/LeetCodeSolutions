package com.chirag;

import java.util.ArrayList;
import java.util.List;

// Solution to https://leetcode.com/problems/3sum/
public class ThreeSum {

    public static void main(String[] args) {

    }

    public static List<List<Integer>>ThreeSumSolution (int [] nums) {
        int numOfValues = nums.length;

       List<List<Integer>> retVal = new ArrayList<>();

        for (int i = 0; i < numOfValues; i ++) {
            for (int j = i; j < numOfValues ; j ++) {
                for (int k = j; k < numOfValues ; k ++) {
                    if (nums[i] + nums[j] + nums[k] == 0 ) {
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]);
                        retVal.add(innerList);
                    }
                }
            }
        }
        return retVal;
    }
}