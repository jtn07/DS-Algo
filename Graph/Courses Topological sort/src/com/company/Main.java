package com.company;
import java.util.*;
public class Main {
    public int solve(int A, int[] B, int[] C) {
        List<Integer> l[]=new List[A+1];
        for(int i=0;i<=A;i++){
            l[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<B.length;i++){
            l [B[i]].add (C[i]);
        }
        int [] vis =new int [A+1];
        Stack<Integer> st=new Stack<>();
        for(int i=1;i<=A;i++){
            int res=0;
            if(vis[i] == 0){
                if(tp(i,res,l,vis,st)==0) return 0;
            }
        }
        return 1;
    }
    public int tp(int i,int res,List<Integer> l[],int vis[],Stack<Integer> st){
        vis[i]=1;
        for(int j:l[i]){
            if(vis[j]==1)
                return  0;
            if(vis[j] == 0)
                if(tp(j,res,l,vis,st)== 0) return 0;

        }
        vis[i]=2;
        return 1;
    }

    public static void main(String[] args) {
	Main m =new Main();
	int A=5;
	int [] B={1, 3, 4, 5 };
	int [] C={2, 1, 5, 3};
	System.out.println(m.solve(A,B,C));
    }
}
