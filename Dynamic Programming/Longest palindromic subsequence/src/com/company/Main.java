package com.company;

public class Main {

    public int solve(String A) {
        int [][] dp=new int [A.length()][A.length()];
        return sol(A,0, A.length()-1,dp );
    }
    public int sol(String A,int i,int j,int [][] dp){

        //System.out.println(i+" "+j);
        if(i==j)
            return 1;

        if(i>j)
            return 0;
        //if(i > j )
         //   return 1;

         if(dp[i][j] != 0)
         return dp[i][j];

        if(A.charAt(i) == A.charAt(j)  )
            return dp[i][j] = 2+ sol(A,i+1 , j-1,dp);

        else return dp[i][j]= Math.max(sol(A,i+1 ,j,dp) , sol(A,i,j-1,dp) );

    }
    public static void main(String[] args) {
        Main m=new Main();
	String s="abaaddaabbedeedeacbcdcaaed";
	System.out.println(m.solve(s));
    }
}
