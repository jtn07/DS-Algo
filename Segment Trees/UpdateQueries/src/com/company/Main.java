package com.company;
import java.util.*;
public class Main {

    ArrayList<Integer> res=new ArrayList<> ();
    ArrayList<Integer> tree=new ArrayList<>();
    public  ArrayList<Integer> solve(ArrayList<Integer> l, ArrayList<ArrayList<Integer>> q){
        int len =l.size();
        for(int i=0;i<(4*len)+1;i++)
            tree.add(0);
        sol(0,l,tree,0,len-1);
       // System.out.println(tree);
        int qlen=q.size();
        int i=0;
        while (i < qlen){
            ArrayList<Integer> temp=q.get(i);
            if(temp.get(0)==0){
                System.out.println(tree);
                update(0,0,len-1,temp.get(1)-1,temp.get(2)  );
                System.out.println(tree);
            }
            else {
                int x= getMin(0,0,len-1, temp.get(1)-1,temp.get(2)-1);
                res.add(x);
            }

            i++;
        }
        return res;
    }
    public int getMin(int index, int start, int end, int L, int R){
        if(R < start || L> end)
            return Integer.MAX_VALUE;
        if(L <= start && end <= R)
            return tree.get(index);
        int mid =(start+end)/2;

        int lchild= getMin(2*index +1,start,mid,L,R);
        int rchild =getMin(2*index +2,mid+1,end,L,R);

        return Math.min(lchild,rchild);
    }
    public void update(int index,int start,int end,int id,int val){
        if(start == end){
            tree.set(index,val);
            return;
        }
        int mid =(start+end) /2;
        if(id <= mid)
            update(2*index +1, start,mid,id,val);
        else
            update(2*index +2, mid+1,end,id,val);

        int min =Math.min(tree.get(2*index +1),tree.get(2*index +2));
        tree.set(index,min);
    }

    public void sol(int index,ArrayList<Integer> l,ArrayList<Integer> tree,int start,int end){

        if(start >= end){
            tree.set(index,l.get(start));
            return;
        }
        int mid =(start+end) /2;
        sol((2*index) +1,l,tree,start,mid);
        sol((2*index) +2,l,tree,mid+1,end);
        int min =Math.min(tree.get(2*index +1),tree.get(2*index +2));

        tree.set(index,min);

    }
    public static void main(String[] args) {
        Main m =new Main();
	int [] arr={ 7, 2, 19, 24, 5, 24};
	ArrayList<Integer>l =new ArrayList<>();
	for(int x:arr)
	    l.add(x);
	ArrayList<ArrayList<Integer>> q=new ArrayList<>();
	int [][] A={{0, 1, 21},{0, 3, 12},{0, 1, 10},{0, 2, 18},{1, 1, 3}};
        for (int[] temp : A) {
            ArrayList<Integer> t = new ArrayList<>();
            for (int x : temp)
                t.add(x);
            q.add(new ArrayList<>(t));
        }
	System.out.println(m.solve(l,q));
    }
}
