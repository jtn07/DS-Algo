package com.company;

public class Main {

    public int isMatch(final String A, final String B) {
        Boolean [][] dp=new Boolean [A.length()][B.length()];
        boolean x=solve(A,A.length()-1,B,B.length()-1,dp);
        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++)
                System.out.print(dp[i][j]+" ");
           System.out.println();
        }

        if(x)
            return 1;
        return 0;
    }
    public boolean solve(String A,int i, String B, int j,Boolean [][] dp){


        if(j == 0 && i==0)
            if(B.charAt(j)=='*' )
                return true;


        if(i<0 && j<0)
            return true;

        if(i<0 && j>=0 && B.charAt(j) =='*')
            return solve(A,i,B,j-1,dp);

        if(i<0  || j<0)
            return false;

        if(dp[i][j] != null)
            return dp[i][j];

        if(A.charAt(i) ==B.charAt(j))
            return dp[i][j]=solve(A,i-1,B,j-1,dp);

        if(B.charAt(j)=='?' )
            return  dp[i][j]=solve(A,i-1,B,j-1,dp);
        if(dp[i][j] == true)
            return true;

        if(B.charAt(j)=='*' )
            return dp[i][j]= (solve(A,i-1,B,j,dp) || solve(A,i,B,j-1,dp)) || solve(A,i,B,j-1,dp);

        return false;

    }

    public static void main(String[] args) {
	Main m =new Main();
	String s="cc";
	String b="***??";
	System.out.println(m.isMatch(s,b));


    }
}
