package com.company;
//Find the length of the longest set of consecutive elements from the array A.

import java.util.*;
public class Main {
    public static  int longestConsecutive(final int[] A) {
        Set <Integer> h=new HashSet<>();
        int max=0;
        int len =A.length;
        for(int i=0;i<len;i++){
            h.add(A[i]);
        }
        for(int i=0;i<len;i++){
            int temp=A[i];
            int tempmax=0;

            if(!(h.contains(temp+1)))   {
                while (true){
                    if(h.contains(temp--)){
                        tempmax++;
                        if(tempmax>max)
                            max=tempmax;
                    }
                    else{
                        tempmax=0;
                        break;
                    }
                }

            }

        }
        if(max>0)
            return max;
        return 1;
    }
    public static void main(String[] args) {
        int  [] arr={1,3,4,6,7,8,9};
System.out.println(longestConsecutive(arr));

    }
}
