package com.company;
import java.util.*;
class Node{
    int val;
    int n;
    public Node(int n,int val){
        this.n=n;
        this.val=val;

    }
}
//using ArrayList minheap
public class Main {
    public int [] Dijsktra(int A, int [][]B,int C){
        List<Node> l[]=new List[A];
        for(int i=0;i<A;i++)
            l[i]=new ArrayList<Node>();
        for(int i=0;i<B.length;i++) {
            l[B[i][0]].add(new Node(B[i][1], B[i][2]));
            l[B[i][1]].add(new Node( B[i][0],B[i][2]));
        }
        boolean vis[] =new boolean [A];
        ArrayList<Node> minheap=new ArrayList<>();
        int [] res=new int[A];
        Arrays.fill(res,-1);
        res[C]=0;
        //vis[C]=true;
        minheap.add(new Node (C,0));
        ArrayList<Node> q=new ArrayList<>();
        Dij(l,q,vis,minheap,res);
        return res;
    }
    public void Dij(List<Node> l[], ArrayList<Node> q, boolean[] vis,ArrayList<Node> minheap,int[] res){
        while (minheap.size() >0) {
            Node removed = delete(minheap);
            heapify(minheap, 0);
            //System.out.println(removed.n+" ");
             if(vis[removed.n]) continue;
             else {
                 res[removed.n] = removed.val;
                 vis[removed.n] = true;
                 q.add(removed);

                 for (int i = 0; i < q.size(); i++) {
                     for (Node x : l[q.get(i).n]){
                         if(!vis[x.n]  ) {
                             addition(minheap, new Node(x.n, x.val + res[q.get(i).n]));
                         }
                 }}
             }
        }
    }
    public void addition(ArrayList<Node> minheap, Node n){
        minheap.add(n);
        upstream(minheap,minheap.size()-1);
    }
    public static void upstream(ArrayList<Node> l,int i){
        int len=l.size();
        int parent=i/2;
        if(parent >=0 && l.get(parent).val > l.get(i).val)
        {
            Node temp=l.get(parent);
            l.set(parent,l.get(i));
            l.set(i,temp);
            upstream(l,parent);
        }
    }
    public Node delete(ArrayList<Node> minheap){
       // System.out.print(minheap.size()+" ");
        Node top=minheap.get(0);
        Node last =minheap.get(minheap.size()-1);
        minheap.set(0,last);
        minheap.remove(minheap.size()-1);
        return top;
    }
    /*public void heapify(ArrayList<Node> minheap,int i){
        if(i >= minheap.size() )
            return;
        int len =minheap.size();
        Node temp=minheap.get(i);
        int left=(2*i)+1;
        int right =(2*i)+2;
        int temp_index=i;
        if((2*i)+1 <  len && minheap.get((2*i)+1).val < temp.val) {
            temp = minheap.get((2 * i) + 1);
            temp_index=left;
        }
        if((2*i)+2 < len && minheap.get((2*i)+1).val < temp.val) {
            temp = minheap.get((2 * i) + 2);
            temp_index=right;
        }
        if(temp != minheap.get(i)){
            Node top=minheap.get(i);
            minheap.set(i,temp);
            minheap.set(temp_index,top);
            heapify(minheap,temp_index);
        }
    }*/
 public static void heapify(ArrayList<Node> l,int i){
      int len =l.size();
      int lchild=(2*i)+1;
      int rchild=(2*i)+2;
      int small=i;
      if(lchild <len && l.get(lchild).val < l.get(small).val )
          small=lchild;
      if(rchild <len && l.get(rchild).val < l.get(small).val)
          small=rchild;
      if(small != i){
          Node temp=l.get(small);
          l.set(small,l.get(i));
          l.set(i,temp);
          heapify(l,small);
      }
  }


    public static void main(String[] args) {
	Main m=new Main();
    int     A = 6;
    int [][]    B = { {0, 4, 9},
            {3, 4, 6},
            {1, 2, 1},
            {2, 5, 1},
            {2, 4, 5},
            {0, 3, 7},
            {0, 1, 1},
            {4, 5, 7},
            {0, 5, 1} };
        int C = 4;
        int [] res=m.Dijsktra(A,B,C);

        for(int x:res)
            System.out.print(x+" ");
    }
}
