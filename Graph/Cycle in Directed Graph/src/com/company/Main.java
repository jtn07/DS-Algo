package com.company;
import java.util.*;
public class Main {
static int p=0;
    public int solve(int A, int [][]B){
        List<Integer> []l=new List[A+1];
        for(int i=0;i<=A;i++){
            l[i]=new ArrayList<>();
        }
        for(int []x:B){
            int a=x[0];
            int b=x[1];
            l[a].add(b);
        }
       // for(int i=0;i<=A;i++){
         //   for(int x:l[i])
         //       System.out.print(i+" "+x+" ");
        //    System.out.println();
      //  }
        boolean [] vis =new boolean [A+1];
        int prev =-1;
        boolean x=false;
        int k=0;
        for(int i=0;i<A+1;i++) {
           if(!vis[i])
            x=dfs(i, k, B, vis, prev, l);
           if(x)
               return 1;
        }
         return 0;
    }
    public boolean dfs(int i, int k,int [][]B,boolean [] vis,int prev,List<Integer> l[]){
        vis[i]=true;
        for(int j=0;j< l[i].size();j++){
            if(!vis[l[i].get(j)]){
                if(dfs(l[i].get(j),k,B,vis,i,l ))
                    return true;
            }
            else {if(l[i].get(j) != prev )
                return true;
        } }
        return false;
    }
    public static void main(String[] args) {
        Main m=new Main();
        int A=5;
	int [][] B={{1, 2},
            {1, 3},
            {2, 3},
            {1, 4},
            {4, 3},
            {4, 5},
            {3, 5}};
	System.out.println(m.solve(A,B));
    }
}