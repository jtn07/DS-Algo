package com.company;
public class Main {
    public static void minheapify(int [] A){
    int len =A.length;
        for(int i=(len/2)-1;i>=0;i--  ){
            heapify(A,i);
        }
    }
    public static void heapify(int []A,int i){
        int len =A.length;
        int small=i;
        int lchild =(2*i)+1;
        int rchild =(2*i)+2;
        if(lchild <len && A[lchild] < A[small])
            small =lchild;
        if(rchild <len && A[rchild] <A[small])
            small =rchild;
        if(small != i){
            int temp = A[small];
            A[small] = A[i];
            A[i] = temp;
            heapify(A,small);
        }
    }
    public static int [] getmax(int [] A){
    int k=3;
    int len =A.length;
    int [] res=new int[len];
    int [] minheap=new int[k];
    int lastsum=0;
    int i=0;
    for(i=0;i<k;i++){
        lastsum+=A[i];
        minheap[i]=A[i];
        if(i<k-1)
        res[i]=-1;
        else res[i]=lastsum;
    }
    minheapify(minheap);
    for (i=k;i<len;i++){
        if(A[i] >minheap[0]){
            lastsum-=minheap[0];
            lastsum+=A[i];
            minheap[0]=A[i];
            minheapify(minheap);
            res[i]=lastsum;
        }
        else res[i]=lastsum;
    }
    return res;
}
    public static void main(String[] args) {
	int []A={5,1,7,6,2,8,4,9,2};
	int [] res =getmax(A);
	for(int x:res)
	    System.out.print(x+" ");
    }
}