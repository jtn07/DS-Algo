package com.company;
/*Tom and Harry are given N numbers, with which they play a game as a team.

Initially, Tom chooses a particular number P from the N numbers, and he takes away all the numbers that are equal to P.

Next, Harry chooses a different number Q, different from what Tom chose, and takes away all the numbers equal to Q from the remaining N numbers.

They win the game if they can take all the numbers by doing the above operation once and if each of them has the same amount of numbers towards the end.

If they win, return the string "WIN", else return "LOSE".*/


import java.util.*;

public class Main {
    public static String solve(int[] A) {
        int len=A.length;
        HashMap<Integer,Integer>h=new HashMap<>();
        Set<Integer> s=new HashSet <>();
        for(int i=0;i<len;i++){
            if((h.containsKey(A[i]))){
                h.put(A[i],h.get(A[i])+1);

            }
            else
                h.put(A[i],1);
        }
        int a=0;
        int b=0;
        int k=0;
       /* s.addAll(h.keySet());
        for ( int x:s){
            if((k&1)==0){

                a+=  h.get(x);
                h.remove(x);
                k++;
            }
            else
            {
                b+=  h.get(x);
                h.remove(x);
                k++;
            }


        }
        if(a==b)
            return "WIN";
        return "LOSE";*/
        s.addAll(h.keySet());
        if(s.size()>2)
            return "LOSE";
        for( int x:s){
            int key =x;

            int value=h.get(key);     //
            h.remove(key);
            if(h.containsValue(value) )
                return "WIN";

        }

   return "LOSE";
    }
    public static void main(String[] args) {
	 int [] arr={1, 1, 2, 2, 3, 3, 4, 4};
	 String temp=solve(arr);
System.out.println(temp);
    }
}
