package com.company;

public class Main {

    class Node {
        int a;
        int b;
        public Node (int a, int b){
            this.a=a;
            this.b=b;
        }
    }
    public int solve(int A, int []B,int [][] C, int D) {
        Node[] l = new Node[B.length];
        int[] rank = new int[A + 1];
        int par[] = new int[A + 1];
        for(int i=0;i< A+1;i++)
            par[i]=i;

        for (int i = 0; i < C.length; i++) {
            l[i] = new Node(C[i][0], C[i][1]);
        }
        int [] res=new int [A+1];
        int cost=0;
        for (int i = 0; i <C.length; i++) {
            int x = find(l[i].a, par);
            int y=find(l[i].b,par);
            if(x != y){
                union(x,y, par,rank);
            }
        }
        for(int i=1;i<par.length;i++){
            par[i]=find(i,par);
        }
        for(int i=1;i<A+1;i++){
            int p=par[i];
            res[p]+=B[i-1];
        }
int count=0;
for(int x:res)
    if(x >= D)
        count++;
        return count;
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
        if(par[a]!=a)
            par[a]=find (par[a],par);
        return par[a];
    }
    public static void main(String[] args) {
        Main m =new Main();
       int  A = 7;
       int [] B = {1, 6, 7, 2, 9, 4, 5};
       int [][] C = { {1, 2},
               {2, 3},{5, 6},
               {5, 7} };
       int D = 12;
       System.out.print(m.solve(A,B,C,D));
    }
}

