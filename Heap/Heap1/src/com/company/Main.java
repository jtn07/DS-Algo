package com.company;
class Solution {
    public  int []  Construct(int [] A){
        int Alen =A.length;
        for (int i = (Alen / 2) - 1; i >= 0; i--) {
            heapify(A, i);
        }
        return A;
    }
    public void heapify (int[] A, int i){
        int Alen =A.length;
        int largest=i;
        int Lchild =(i*2)+1;
        int Rchild= (i*2)+2;
        if(  (Lchild < Alen && A[Lchild] < A[i] ) ||  (Rchild <Alen && A[Rchild] < A[i]) ){

            if(Lchild < Alen && A[Lchild] < A[i]  && Rchild <Alen && A[Rchild] < A[i]){
                int m =Math.min(A[Lchild],A[Rchild]);
                int min=0;
                if(A[Lchild] == m )
                    min=Lchild;
                else min=Rchild;
                int temp = A[i];
                A[i] = A[min];
                A[min] = temp;
                heapify(A, min);
            }
            else{
        if(Lchild < Alen && A[Lchild] < A[i])
            largest=Lchild;
        if(Rchild <Alen && A[Rchild] < A[i])
            largest=Rchild;
        if(largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            heapify(A, largest);
        }
        }
        }


    }
}
public class Main {

    public static void main(String[] args) {
        Solution s=new Solution();
	int [] arr ={10,11,12,13,14};
	int [] A= new int [arr.length];

	int x=0;
	for(int i=arr.length-1;i>=0;i--) {
        A[x++]=arr[i];
    }
        for (int l: A)
            System.out.print(l+" ");
        System.out.println();
	int [] X=s.Construct(A);
	for(int k:X)
	    System.out.print(k+" ");

    }
}
