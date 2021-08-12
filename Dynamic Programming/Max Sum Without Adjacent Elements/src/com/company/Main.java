package com.company;

public class Main {

     int [] dp =new int[10];
    {
        dp[0]=31;
        for(int i=1;i<10;i++)
            dp[i]=-1;
    }
    public  int solve(int [] arr,int i){
        if(i < 0 )
            return 0;
        if(dp[i] != -1)
            return dp[i];

        if(arr[i]+ solve(arr,i-2 ) > solve(arr,i-1)  ) {
            dp[i] = arr[i] + solve(arr, i - 2);
            return dp[i];
        }
        else return dp[i-1];
    }
    public static void main(String[] args) {

        Main m=new Main();
        int [][] arr={{16, 5, 54, 55, 36, 82, 61, 77, 66, 61},{31, 30, 36, 70, 9, 37, 1, 11, 68, 14}};

        int [] A=new int[arr[0].length];
        for(int i=0;i<A.length;i++)
            A[i]=Math.max( arr[0][i], arr[1][i] );
        System.out.println(m.solve(A,9));
    }
}
