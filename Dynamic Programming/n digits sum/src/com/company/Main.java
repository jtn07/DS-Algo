package com.company;

public class Main {

    public int solve(int A, int B) {
        int [][] dp=new int [A+1][B+1];
        return sol(A,B,dp);
    }

    public int sol(int n,int sum,int[][] dp){

        dp[0][0]=1;
        for(int i=1;i<=sum;i++)
            dp[1][i]=1;

       // for(int [] x:dp){
       //     for (int k:x)
       //         System.out.print(k+" ");
       //     System.out.println();
     //   }

        for(int i=2;i<=n;i++ ){
            for(int j=0;j<=sum;j++){
                for(int k=0;k<=9;k++) {
                 //   System.out.println(i+" "+j+" "+k);
                    if (k <= j) {
                        dp[i][j]+= dp[i - 1][j - k];
                    }
                }
            }
        }
        for(int [] x:dp){
            for (int k:x)
                System.out.print(k+" ");
            System.out.println();
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
	int a=8;
	Main m =new Main();
	int b=4;
	System.out.println(m.solve(a,b));
    }
}
