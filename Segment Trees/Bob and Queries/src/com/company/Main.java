package com.company;

/*Bob has an array A of N integers. Initially, all the elements of the array are zero. Bob asks you to perform Q operations on this array.

        You have to perform three types of query, in each query you are given three integers x, y and z.

        if x = 1: Update the value of A[y] to 2 * A[y] + 1.
        if x = 2: Update the value A[y] to ⌊A[y]/2⌋ , where ⌊⌋ is Greatest Integer Function.
        if x = 3: Take all the A[i] such that y <= i <= z and convert them into their corresponding binary strings. Now concatenate all the binary strings and find the total no. of '1' in the resulting string.
        Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.*/


import java.util.ArrayList;
class Node {
    int val;
    int binary;
    public Node(int a){
        this.val=0;
        this.binary=a;
    }
    public Node (int a, int b){
        this.val=a;
        this.binary=b;
    }
}
public class Main {

    ArrayList<Integer> res=new ArrayList<>();
    public ArrayList<Integer> solve(int n, ArrayList<ArrayList<Integer>> q){
        ArrayList<Node> tree =new ArrayList<>();
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(0);
        for(int i=0;i<4*n;i++)
            tree.add(new Node(0));
        sol(A,tree,0,0,n-1);
        for(ArrayList<Integer> t:q){
            int x=t.get(0);
            int y=t.get(1);
            int z=t.get(2);
            if(x==1){
                update1(0,0,n-1,y-1,A,tree);
            }
            if(x==2) {
                update2(0,0,n-1,y-1,A,tree);
            }
            if(x==3) {
                res.add(getsum(0,0,n-1,y-1,z-1,tree));
            }
        }
        return res;
    }
    public void sol(ArrayList<Integer> A, ArrayList<Node> tree,int index,int start, int end ){
        if(start ==end ){
            String bin=Integer.toBinaryString(A.get(start));
            int count =0;
            int te=0;
            while(te>0){
                if((te&1) == 1)
                    count++;
                te=te/10;
            }
            tree.set(index,new Node(A.get(start),count));
            return;
        }
        int mid=(start+end)/2;
        sol(A,tree,2*index +1,start,mid);
        sol(A,tree,2*index +2,mid+1,end);
        int sum=(tree.get(2*index +1).binary ) + (tree.get(2*index +2).binary);
        tree.set(index, new Node (sum) );

    }
    public int getsum(int index,int start,int end, int L, int R,ArrayList<Node> tree) {

        if(R < start || L> end)
            return 0;
        if(L <= start && end <= R)
            return tree.get(index).binary;
        int mid =(start+end)/2;

        int lchild= getsum(2*index +1,start,mid,L,R,tree);
        int rchild =getsum(2*index +2,mid+1,end,L,R,tree);

        return lchild+rchild;
    }

    public void update1(int index, int start, int end, int val, ArrayList<Integer>A, ArrayList<Node> tree ){

        if(start == end ){
            String bin=Integer.toBinaryString(A.get(start));
            int count =0;
            int t=tree.get(index).val;
            int pres=(2*t) +1;
            int te=pres;
            while(te>0){
                if((te&1) == 1)
                    count++;
                te=te/10;
            }

            tree.set(index,new Node(   pres,count));
            return;
        }

        int mid =(start+end)/2;
        if(val <=mid )
            update1(2*index +1, start,mid, val,A,tree);
        else update1(2*index +2, mid+1, end, val,A,tree);
        int sum=(tree.get(2*index +1).binary ) + (tree.get(2*index +2).binary);

        tree.set(index, new Node (sum));

        }

    public void update2(int index, int start, int end, int val, ArrayList<Integer>A, ArrayList<Node> tree ){
        if(start == end ){

            int prev=tree.get(index).val;
            int pres =prev/2;
            int te=pres;
            int count=0;
            while(te>0){
                if((te&1) == 1)
                    count++;
                te=te/10;
            }

            tree.set(index,new Node(   pres,count));
            return;

        }

        int mid =(start+end)/2;

        if(val <=mid )
            update2(2*index +1, start,mid, val,A,tree);

        else update2(2*index +2, mid+1, end, val,A,tree);

        int sum=(tree.get(2*index +1).binary ) + (tree.get(2*index +2).binary);

        tree.set(index, new Node (sum));

    }
    public static void main(String[] args) {
        Main m =new Main();

        int [][] A={{1, 1, -1},{1, 2, -1},{3, 1, 3},{2, 1, -1},{3, 1, 3}};
        ArrayList<ArrayList<Integer>> q= new ArrayList<>();
        for (int[] temp : A) {
            ArrayList<Integer> t = new ArrayList<>();
            for (int x : temp)
                t.add(x);
            q.add(new ArrayList<>(t));
        }
        System.out.println(m.solve(5,q));

        // Update 1 oprations increments 1's by one
        // Update2 operation decrements 1's by one
        // check and update

    }
}
