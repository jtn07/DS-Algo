package com.company;
/*For Given Number A find if its COLORFUL number or not.

If number A is a COLORFUL number return 1 else return 0.

What is a COLORFUL Number:

A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.*/
import java.util.*;
public class Main {
    public static  int colorful(int A) {
        Set <Long> h=new HashSet<>();
        String  l =A+"";
        int len =l.length();
        // Long sum=new Long (0);
        for(int i=0;i<len;i++){
            Long sum=new Long (1);

            for(int j=i;j<len;j++){
                sum=new Long (1);
                String temp= (l.substring(i,j+1));
                int le=temp.length();
                for(int k=0;k<le;k++)
                sum*=Long.parseLong(temp.substring(k,k+1));
                 System.out.println(temp);
                if(h.contains(sum))
                    return 0;
                h.add(sum);

            }System.out.println("sum="+sum);

        }
        return 1;

    }
    public static void main(String[] args) {
        int a=99;
        System.out.println(colorful(a));
    }
}
