package com.company;

public class Main {
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         public TreeNode(int val) {
        this.val =val;
     }
    }

    public int solve(TreeNode A,int B,int C){

         if(A == null)
             return 0;
         if(B < A.val && C< A.val)
            return  solve(A.left,B,C);
         if(B>A.val && C>A.val)
             return solve(A.right,B,C);
         if(B==A.val){
             if(C == A.val)
                 return 0;
             if(C<A.val){
                 return dist(A.left,C);
             }
             if(C >A.val)
             {
                 return dist(A.right,C);
             }
         }
        if(C==A.val){
            if(B == A.val)
                return 0;
            if(B<A.val){
                return dist(A.left,B);
            }
            if(B>A.val)
            {
                return dist(A.right,B);
            }

        }
            return (dist(A, B)+ dist(A,C));
    }
    public int dist(TreeNode A, int B){
        if(A== null)
            return 0;
        if(B== A.val)
            return 0;
        if(B <A.val)
            return (1+dist(A.left,B));
        else return (1+dist(A.right,B));
    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right =new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.right.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        Main m =new Main();
        System.out.println(m.solve(root,1,4));
    }
}
