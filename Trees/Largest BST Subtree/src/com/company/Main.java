package com.company;

public class Main {
static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
    int count;
    public int solve(TreeNode A){
        sol(A);
        return count;

    }
    public int sol(TreeNode A){
        if(A== null)
            return 0;
        int left = 1+sol(A.left);
        int  right =1+sol(A.right);
        int x=0;
        if(left== right && A.left != null && A. right != null && A.left.val <=A.val && A.right.val >=A.val)
            x+= ((2*left) +1);
        if(x> count)
            count=x;
        return x;
    }

    public static void main(String[] args) {
	TreeNode root =new TreeNode(10);
	root.left=new TreeNode(5);
	root.right=new TreeNode(15);
	root.left.left=new TreeNode(1);
	root.left.right=new TreeNode(8);
	root.right.right=new TreeNode(7);
	Main m =new Main();
	System.out.println(m.solve(root));
    }
}
