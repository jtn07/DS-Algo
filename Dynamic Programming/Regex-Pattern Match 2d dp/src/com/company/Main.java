package com.company;

public class Main {

    public int solve(String b, String a){
        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];

        dp[0][0]=true;
        for(int i=1;i<b.length()+1;i++)
            if(b.charAt(i-1)=='*')
                dp[0][i]=dp[0][i-1];

           for(boolean [] A:dp){
                for (boolean x:A)
                    System.out.print(x+" ");
                System.out.println();
            }

           // System.out.println(a+" "+b);
        for(int i=1;i <a.length()+1;i++) {
            for (int j = 1; j < b.length()+1; j++) {
              //  System.out.println(i+" "+j);
                if (a.charAt(i - 1) == b.charAt(j - 1) || b.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];

                else if (b.charAt(j - 1) == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }
        /*for(boolean [] A:dp) {
            for (boolean x : A)
                System.out.print(x + " ");
            System.out.println();
        }*/
            return dp[a.length()][b.length()]?1:0;

    }
    public static void main(String[] args) {
        Main m =new Main();
        String a="aaaa";
        String b="a*****";
        System.out.println(m.solve(b,a));
    }
}
