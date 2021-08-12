package com.company;
import java.util.*;
public class Main {
public static int Solve(String txt,String pat ){
    int count=0;
    int len = txt.length() +( pat.length() +1);
    char [] T=new char [len];
    int i=0;
    for(;i<pat.length();i++){
        T[i]=pat.charAt(i);
    }
    T[i++]='$';
    for(int j=0;j<txt.length();j++){
        T[i++]=txt.charAt(j);
    }

    System.out.println(String.valueOf(T));
    int [] Z=new int[len];
    int temp=0;
    int start=0;
    int end=0;
    Z[0]=0;
    for(i=1;i<len;i++){
        char x=T[i];
        start=end=i;
        if(x==T[0]){
            int range=get_Range(Z,T,len,i);
            int index=i;
            System.out.println(i+" "+range);
            Z[i]=range;
            int j=index;
            for(  ;j< (index+range-1);j++){
                if(j<len)
                Z[++i]=Z[j-index+1];
            }
        }else Z[i]=0;
    }
    for(int c:Z) {
        if(c>=3)
            count++;
        System.out.print(c + " ");
    }
    System.out.println();

    return count;
}
public static int get_Range(int []Z,char[] T,int len,int i){
    int count =0;
    int start=0;
    while (i < len && T[i] ==T[start] ){
        count ++;
        i++;
        start++;
    }
    return count;
}
    public static void main(String[] args) {
  String txt="baabxaabc";
  String pat="aabc";
  System.out.println(Solve(txt,pat));
    }
}
