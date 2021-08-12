package com.company;

public class Main {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public int solve(TreeNode A){
        boolean x= sol(A.left,A.right);
        if(x)
            return 1;
        return 0;
    }

    public boolean sol(TreeNode A, TreeNode B){

        if(A== null && B== null)
            return true;
        if(A== null || B== null)
        return false;

        if(A.val== B.val )
           return  sol(A.left, B.right) && sol(A.right,B.left);
        return false;
    }

    public static void main(String[] args) {
	Main m= new Main();

	TreeNode root=new TreeNode(1);
	root.left=new TreeNode(2);
	root.right =new TreeNode(2);
	root.left.left=new TreeNode(3);
	root.right.right=new TreeNode(3);
	root.right.left=new TreeNode(4);

	System.out.println(m.solve(root));

    }
}
