package com.company;
import java.util.*;
public class Main {
static HashSet<String> h=new HashSet<>();
    String S="";
    int [][]dp=new int[20][20];
public int solve(String s1,String s2,int i,int j ){

    if(i<0|| j<0)
        return 0;

    if(dp[i][j] != 0)
        return dp[i][j];
    if(s1.charAt(i) ==  s2.charAt(j) && i != j) {
        return dp[i][j]=1+solve(s1,s2,i-1,j-1);
    }
    return dp[i][j]=Math.max(solve(s1,s2,i-1,j),solve(s1,s2,i,j-1) );
}

public static void main(String[] args) {
        Main m =new Main();
	String s1="abcdffghjabcd";
	String s2=s1;
	System.out.println(m.solve(s1,s1,s1.length()-1 ,s1.length()-1));

    }


}
