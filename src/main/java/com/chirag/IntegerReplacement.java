package com.chirag;// Solution to https://leetcode.com/problems/integer-replacement/

/*
Given a positive integer n, you can apply one of the following operations:

If n is even, replace n with n / 2.
If n is odd, replace n with either n + 1 or n - 1.
Return the minimum number of operations needed for n to become 1.



Example 1:

Input: n = 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1
Example 2:

Input: n = 7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1
Example 3:

Input: n = 4
Output: 2


Constraints:

1 <= n <= 231 - 1



 */
public class IntegerReplacement {
    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(4));

    }
    public static int integerReplacement(int n) {

        int iterations = 0;
        if (n == 2147483647) { // 2^32 overflows integer
            n = n - 1;
        }
        while ( n > 1 ) {
            if (n % 2 == 0 ){ // n is even - have to divide
                n = n/2;
                iterations ++;
            }
            else {
                iterations ++;
                int plusOneIteration = integerReplacement(n + 1);
                int minusOneIteration = integerReplacement( n - 1);

                if (minusOneIteration < plusOneIteration)
                    iterations = iterations + minusOneIteration;
                else
                    iterations = iterations + plusOneIteration;

                n = 1;
            }
        }

        return iterations;

    }

}
