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
    int x=0;
    public int solve(TreeNode A){
        sol(A);
        if(x==1) {
            x=0;
            return 0;
        }
        return 1;
    }
    public int sol(TreeNode A){
        if(A== null)
            return 1;
        int left =1+sol(A.left);
        int right=1+sol(A.right);

        if(Math.abs(left - right) > 1)
           x=1;

        return Math.max(left,right);
    }

    public static void main(String[] args) {
	TreeNode root=new TreeNode(1);
	root.left=new TreeNode(2);
	root.right=new TreeNode(2);
	root.left.left=new TreeNode(3);

	Main m=new Main();
	System.out.println(m.solve(root));
    }
}
