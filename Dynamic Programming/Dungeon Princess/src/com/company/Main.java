package com.company;

public class Main {
    static Integer dp[][]=new Integer[3][3];
    public int solve(int [][] A) {
        int i=A.length;
        int j=A[0].length;
        return sol(A,0,0,dp);
    }
    public int sol(int[][]A, int i, int j,Integer [][] dp){
        if(dp[i][j] != null)
            return dp[i][j];
        else {
            if(i==A.length-1 && j==A[0].length-1)
                return  dp[i][j]=A[i][j] > 0 ? 1 : ( ( -1*A[i][j] +1));
            if(i == A.length-1)
                return dp[i][j] =   Math.max(1, sol(A,i,j+1,dp)-A[i][j]);
            if(j == A[0].length-1)
                return dp[i][j] =   Math.max(1, sol(A,i+1,j,dp)-A[i][j]);
            else
                return dp[i][j]= Math.max(1,Math.min(sol(A,i,j+1,dp)-A[i][j],sol(A,i+1,j,dp)-A[i][j]) );
        }
    }
    public static void main(String[] args) {
	int [][] A={{-2, -3, 3},{-5, -10, 1},{10, 30, -5}};
	Main m=new Main();
	System.out.println(m.solve(A));
	for (int i=0;i<3;i++)
    {
        for(int j=0;j<3;j++)
            System.out.print(dp[i][j]+" ");
    System.out.println();
    }
    }
}
/*if(dp[i][j] != null)
            return dp[i][j];
        else {
            if(i==A.length-1 && j==A[0].length-1)
                return A[i][j] >0? 1: -1* A[i][j] +1;
            if(i==A.length -1)
                return dp[i][j] =Math.max(sol(A,i,j+1,dp)-A[i][j],1);
            if(j== A[0].length-1)
                return dp[i][j] =Math.max(sol(A,i+1,j,dp)-A[i][j],1);
            else
                return dp[i][j]=Math.max(1, Math.min(sol(A,i,j+1,dp)-A[i][j],sol(A,i+1,j,dp)-A[i][j]) );
        }*/