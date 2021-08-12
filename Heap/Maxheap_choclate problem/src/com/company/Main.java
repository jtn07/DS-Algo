package com.company;
import java.util.*;
public class Main {

    public static void maxheapify(ArrayList<Integer> l){
        int len =l.size();
        for(int i=(len/2)-1;i>-1;i--  ){
            heapify(l,i);
        }
    }
    public static void heapify(ArrayList<Integer> l,int i){
        int large =i;
        int len =l.size();
        int lchild=(2*i)+1;
        int rchild=(2*i)+2;
        if(lchild <len && l.get(lchild) > l.get(large) )
            large=lchild;
        if(rchild <len && l.get(rchild) > l.get(large))
            large=rchild;
        if(large != i){
            int temp=l.get(large);
            l.set(large,l.get(i));
            l.set(i,temp);
            heapify(l,large);
        }
    }
    public static int nchoc (ArrayList<Integer> l,int n){

        maxheapify(l);
        int count=0;
        while(n-- > 0 ){
            int temp=l.get(0);
            if(temp>0)
            count +=temp;
            l.set(0,temp/2);
            heapify(l,0);
        }
        return count;
    }
    public static void main(String[] args) {
	int [] arr={2, 4, 6, 8, 10};
	int a=5;
	ArrayList<Integer> l=new ArrayList<>();
	for(int x:arr)
	    l.add(x);
	System.out.println(nchoc(l,5));
    }
}
