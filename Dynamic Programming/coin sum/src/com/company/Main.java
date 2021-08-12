package com.company;
import java.util.*;
/*You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:

Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).*/
public class Main {
    public int coinchange2(int[] A, int B) {
        Integer [][] dp=new Integer [B+1][A.length];
       // for(int i=0;i<A.length;i++)
            //dp[A[i]][]=1;
        return solve(A,B,0,dp);
    }

    public int solve(int []A,int N,int i,Integer [][] dp){
        if(N==0)
            return 1;
        if(N<0)
            return 0;
        if(i >=A.length)
            return 0;
        if(dp[N][i] != null)
            return dp[N][i];

        return dp[N][i]= (solve(A,N,i+1,dp) + ( solve(A,N-A[i],i,dp)) );

    }
    public static void main(String[] args) {
        Main m=new Main();
	int []A={ 2, 5, 3, 6 };
	int N=10;
	System.out.println(m.coinchange2(A,N));

    }
}
