package com.company;
/*Given an array of integers A consisting of only 0 and 1.

Find the maximum length of a contiguous subarray with equal number of 0 and 1.

*/
import java.util.*;

public class Main
{
    public static int countbefore(HashMap<Integer,String> H,int index,String search){
        String arr[]=search.split(" ");
         System.out.println(index+" "+H.get(index));

        int one  =Integer.parseInt(arr[0]);
        int zero =Integer.parseInt(arr[1]);
         if(one ==zero) return index+1;
        for(int i=0;i<index;i++){
            String ar[]=H.get(i).split(" ");

            int o=Integer.parseInt(ar[0]);
            int z=Integer.parseInt(ar[1]);
          System.out.println(" o ="+o+" z ="+z);
             System.out.println("one="+""+one+" zero= "+zero+" "+" o ="+o+" z ="+z);
            System.out.println("one-o "+(one-o)+" "+"zero-z "+(zero-z));
            if(one==zero)
                return index-i;
            if((one-o)==(zero-z)){
                //System.out.println("coutnbefore "+(index-i));
              return (index-i)  ;

            }
        }
        return 0;


    }
    public static int solve (int [] A){
        int len=A.length;


        HashMap<Integer,String> h=new HashMap<>();
        int countzero=0;
        int countone=0;
        int  max=0;

        for(int i=0;i<len;i++){
            if(A[i]==0){
                countzero++;
                //System.out.println(countzero);
            }
            else{
                countone++;
                //System.out.println(countone);
            }

            String temp=countone+" "+countzero;
            //System.out.println(countone+" "+countzero );
            h.put(i ,temp);
            // System.out.println(i+" "+temp);
        }
         System.out.println(countone+" "+countzero );
        for(int i=0;i<len;i++){
            int tempmax=countbefore(h,i ,h.get(i));
            if(tempmax>max)
                max=tempmax;

        }

        return max;

    }


    public static void main(String[] args) {
       int[] ar={ 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1  };
        ArrayList<Integer>l=new ArrayList<>();
int[] arr={0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0};
       // System.out.println("0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0");
        System.out.println(solve(ar));
    }
}


