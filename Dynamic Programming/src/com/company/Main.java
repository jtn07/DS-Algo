package com.company;
import java.util.*;
public class Main {

    public int solve(int [][]A){
        int [] dp =new int [A.length];
        dp[0]=Math.max(A[0][0],A[0][1]);
        return solve(A, dp, A.length-1);
    }
    public int solve(int [][] A, int [] dp,int i){
        if(i < 0)
            return 0;
        if(dp[i] != 0)
            return dp[i];
        return dp[i] = Math.max(solve(A,dp,i-1),(solve(A,dp,i-2)+Math.max(A[i][0],A[i][1])) );
    }

    public static void main(String[] args) {
	Main m =new Main();
	int [][] arr={{74,66},{37,38},{82,16},{1,1}};
	System.out.println(m.solve(arr));
    }
}
