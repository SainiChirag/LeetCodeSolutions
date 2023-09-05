package com.chirag;

//Solution to #5 https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(isPallindrome("a"));
        System.out.println(isPallindrome("abc"));
        System.out.println(isPallindrome("aabb"));
        System.out.println(isPallindrome("raaabcba"));
        System.out.println(isPallindrome("abba"));
        System.out.println(isPallindrome("racecar"));

    }


    public static String longestPallindrome(String s) {
      // from each character start checking if the expanded characters are pallindrome

        int start = 0;
        int end = 0;

        for (int i = 0 ; i < s.length(); i ++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            int len = Math.max(len1,len2);

            if (len > end - start) {
                start = i -((len-1)/2);
                end = i + (len/2);
            }

        }

        return (s.substring(start, end +1));


    }

    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right )
            return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right++;
        }

        return right - left - 1;

        }


    /*
    * Brute force method -- find all the substrings in the string and then find if the string is a pallindrome
    * */
    public String longestPalindromeBruteForce(String s) {
        // find all substrings
        String longestPallindrome="";
        for (int i = 0; i <s.length(); i++) {
            for (int j = i; j<s.length(); j++) {
                // substring from i to j
                String test = s.substring(i,j+1); // remember substring end index is exclusive
                if (isPallindrome(test)) {
                    if (test.length() > longestPallindrome.length()) {
                        longestPallindrome = test;
                    }
                }
            }
        }
        //check if substring is a pallindrome
        // record largest substring
        return longestPallindrome;
    }

    public static boolean isPallindrome( String value ) {
        int max = value.length();
        for (int i = 0, j = max-1; (i < max/2 && j >= max/2) ; i++, j--) {
            if (value.charAt(i) != value.charAt(j))
                return false;
        }
        return true;
    }
}
