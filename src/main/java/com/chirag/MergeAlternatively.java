package com.chirag;

//Solution to https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
public class MergeAlternatively {
    // abc xyz
    //axbycz
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "xyz12";

        System.out.println(mergeAlternately(s1,s2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder retVal = new StringBuilder();
        int word1Len = word1.length();
        int word2Len = word2.length();

        int min = Math.min(word1Len, word2Len);


        for (int i = 0; i < min ; i ++) {
            retVal.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if (min < word1Len) {
            retVal.append(word1.substring(min));
        }
        if (min < word2Len) {
            retVal.append(word2.substring(min));
        }

        return retVal.toString();

    }
}
