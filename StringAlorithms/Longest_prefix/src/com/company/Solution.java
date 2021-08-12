package com.company;

public class Solution {
    int max;
    public String longestCommonPrefix(String[] A) {
        String s1=A[0];
        int lena =A.length;
    for(int k= 1;k<lena;k++)
{
    String s2 = A[k];

    String res=s1+"$"+s2;
    char[] T=res.toCharArray();
    int len =T.length;

        int [] Z=new int[len];
        int temp=0;
        int start=0;
        int end=0;
        Z[0]=0;
        int i=0;
        for(i=1;i<len;i++){
            char x=T[i];
            start=end=i;
            if(x==T[0]){
                int range=get_Range(Z,T,len,i);
                int index=i;
                //System.out.println(i+" "+range);
                Z[i]=range;
                int j=index;
                for(  ;j< (index+range-1);j++){
                    if(j<len)
                        Z[++i]=Z[j-index+1];
                }
            }else Z[i]=0;
        }int m=0;
        for(int x:Z){
            if(x>m)
                m=x;
        }

        if(m==0)
            return "";
       // if(m<max)
        max=m;
        s1=res.substring(0,m-1);
        System.out.println(s1);
}

         return  A[0].substring(0,max);
    }
    public int get_Range(int []Z,char[] T,int len,int i){
        int count =0;
        int start=0;
        while (i < len && T[i] ==T[start] ){
            count ++;
            i++;
            start++;
        }
        return count;
    }
}