package com.chirag;
//https://leetcode.com/problems/plus-one/

// 123, 9999, 1230
class Plusone {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        int [] sumPlusOne = new int[len];

        for (int i = len - 1; i >= 0 ; i --) {
            if (carry > 0) {
                if (digits[i] == 9 ) {
                    sumPlusOne[i] = 0;
                    carry = 1;
                }
                else {
                    sumPlusOne[i] = digits[i] + 1;
                    carry = 0;
                 }
            }
            else {
                sumPlusOne[i] = digits[i];
            }

        }
        if (carry > 0) {
            int[] sumPlusOneCarry = new int[len + 1];
            System.arraycopy(sumPlusOne, 0, sumPlusOneCarry, 1, len);
            sumPlusOneCarry[0] = 1;
            return sumPlusOneCarry;
        }
        else return sumPlusOne;
   }
// uses in place change instead of new array
    public static int[] plusOne2(int[] digits) {
        int len = digits.length;
        boolean carry = true;

        for (int i = len - 1; i >= 0 ; i --) {
            if (carry) {
                if (digits[i] == 9 ) {
                    digits[i] = 0;
                }
                else {
                    digits[i] = digits[i] + 1;
                    carry = false;
                 }
            }
        }
        if (carry) {
            int[] sumPlusOneCarry = new int[len + 1];
            System.arraycopy(digits, 0, sumPlusOneCarry, 1, len);
            sumPlusOneCarry[0] = 1;
            return sumPlusOneCarry;
        }
        else return digits;
   }

   public static void main(String[] args) {
      int[] result = plusOne2(new int[] {1, 9,9, 1});

      for (int i : result) {
        System.out.print(i + " ");
      }
   }
}