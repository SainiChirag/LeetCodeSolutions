package com.chirag;

import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// solution to LeetCode #1 https://leetcode.com/problems/two-sum/
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{3,2,4}, 6));
        System.out.println(twoSum2(new int[]{3,2,4}, 6));
    }

    // Brute force solution - not good
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i ++ ) {
            for (int j = i+1; j < nums.length ; j ++) {
                if (nums[i] + nums[j] == target)
                {
                    return  new int[] {i,j};
                }
            }
        }
        return new int[]{};
    }



    // Linear time solution
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (myMap.containsKey(difference)) {
                return new int[] {i, myMap.get(difference)};
            }
            else myMap.put(nums[i], i);
        }
        return new int[]{};
    }
}

