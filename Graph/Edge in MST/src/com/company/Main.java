package com.company;
import java.util.*;
public class Main {
    public class Node{
        int a;
        int b;
        int cost;
        int index;
        public Node(int a, int b, int c,int index){
            this.a=a;
            this.b=b;
            this.cost=c;
            this.index=index;
        }
    }
    public int[] solve(int A, int [][] B) {
        Node[] l = new Node[B.length];
        int[] rank = new int[A + 1];
        int par[] = new int[A + 1];
        for(int i=0;i< A+1;i++)
            par[i]=i;
        for (int i = 0; i < B.length; i++) {
            l[i] = new Node(B[i][0], B[i][1], B[i][2],i);
        }
        int [] res=new int [B.length];
        Arrays.sort(l, (o1, o2) -> (o1.cost - o2.cost));
        int cost=0;
        for (int i = 0; i <B.length; i++) {
            int x = find(l[i].a, par);
            int y=find(l[i].b,par);
            if(x != y){
                res[l[i].index]=1;
                cost+=l[i].cost;
                union(x,y, par,rank);
            }
        }
        return res;
    }
    public void union(int x, int y,int [] par ,int []rank){
        if(rank[x] > rank[y] ){
            par[y]=x;
        }
        else {
            if(rank[x] == rank[y]){
                par[x]=y;
                rank[x]++;
            }
            else par[x]=y;
        }
    }
    public int find (int a, int [] par){
        if(par[a]==a)
            return a;
        int t=find(par[a],par);
        par[a]=t;
        return t;
    }
    public static void main(String[] args) {
        Main m =new Main();
        int A = 4;
        int [][] B = {  {1, 2, 1},
                {2, 3, 4},
                {1, 4, 3},
                {4, 3, 2},
                {1, 3, 10} };
        int [] res=(m.solve(A,B));
        for (int x:res)
            System.out.print(x+" ");
        System.out.println();
    }
}

