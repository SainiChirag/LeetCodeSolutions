package com.chirag;

public class ZigZagConversion {
    /**
     * Solution to LeetCOde https://leetcode.com/problems/zigzag-conversion/
     */
    // ) Nsquared complexity, could be improved for sure


     public static void main (String[] args) {
        System.out.println(convert("AB", 1));
     }

     public static String convert(String s, int numRows) {
        // basic idea is to create a 2-d array of size s x s (for a lack of max size as of now) -- think about it later . 
        //
        int size = s.length();
        String[][] valueArray = new String[size][size];


        int x= 0;
        int y = -1;
        boolean goingDown = true;

      //  boolean goingUp = false;

        for(char c : s.toCharArray()) {
            //valueArray[x][y] = String.valueOf(c);
            if (numRows == 1) {
                return  s;
            }
            if(goingDown && y < numRows -1 ) {
                y = y +1;
            } else
            if (goingDown && y == numRows -1 )  {
                y = y-1;
                x = x+ 1;
                goingDown = false;
            } else if (!goingDown && y > 0 )
            {   
                y = y - 1;
                x = x + 1;

            }else if (!goingDown && y == 0 ){
                y = y + 1;
                goingDown = true;
            }
            valueArray[y][x] = String.valueOf(c);
        }

        // now read the array till all the characters are found
        String resultString = "";
        for (int i = 0; i < size; i ++) {
            for (int j = 0 ; j < size; j ++) {
                if (valueArray[i][j] != null){
                    resultString =  resultString.concat(valueArray[i][j]);
                } 
            }
        }


        return resultString;


     }

}