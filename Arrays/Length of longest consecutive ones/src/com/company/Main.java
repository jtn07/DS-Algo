package com.company;
import java.util.*;

public class Main {
public static int LongestOnesPossible(String s){

   String [] ar= (s.split( ""));
   int len=ar.length;
   int [] arr=new int[len];
   for(int i=0;i<len;i++)
       arr[i]=Integer.parseInt(ar[i]);
    /*  for (int x:arr)
        System.out.print(x+" ");
    System.out.println(); */

    int [] prefix=new int[len+1];
    int [] postfix=new int[len+1];
    postfix[len]=0;

    prefix[0]=0;
   int countx=0;
   for(int i=0;i<len;i++){

       if(arr[i]==0){
           prefix[i+1]=0;   //prefix addition
           countx=0;
       }
       else{
           prefix[i+1]=++countx;
       }
   }
    countx=0;
   int countingx=0;
    for(int i=len-1;i>=0;i--){

        if(arr[i]==0){
            postfix[i]=0;
            countx=0;
        }
        else{
            countingx++;
            postfix[i]=++countx;
        }
    }
    /*  for (int x:prefix)
        System.out.print(x+" ");
    System.out.println();
    for (int x:postfix)
        System.out.print(x+" ");
    System.out.println(); */
    int l=0;
   for(int i=0;i<len;i++){
       if(arr[i]==0){
           l=Math.max(prefix[i]+postfix[i+1],l);
       }
   }
   if(l==countingx)
    return l;
   return l+1;
}
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    System.out.println(LongestOnesPossible(s));
     }
  }
/*
for (int x:prefix)
      System.out.print(x+" ");
  System.out.println();
    for (int x:postfix)
        System.out.print(x+" ");
    System.out.println();

 */