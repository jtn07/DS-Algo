package com.company;
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

public class Main {
    boolean n1=false;
    boolean n2=false;
    TreeNode head =null;
    public TreeNode LCA(TreeNode root, int a, int b){
        head =root;
        TreeNode temp=findLCA(root,a,b);
        if(n1 && n2)
            return temp;
        else {
            if(n1) {
                if (isPresent(temp, b))
                    return temp;
                else return null;
            }
            else if(isPresent(temp,a))
                return temp;
                else return null;
        }
    }
    public TreeNode findLCA(TreeNode root, int a, int b){
        if(root == null)
            return null;
        if(root.val == a|| root.val ==b) {
            if (root.val == a) {
                n1 = true;
                return root;
            }
            else {
                n2 = true;
                return root;
            }
        }
        TreeNode left =findLCA(root.left,a,b);
        TreeNode right =findLCA(root.right,a,b);
        if(left != null && right != null) {
            return root;
        }
        if(left != null)
            return left;
        return right;
    }
    public static void main(String[] args) {
        Main M =new Main();
	TreeNode root =new TreeNode (5);
	root.left =new TreeNode(3);
	root.right =new TreeNode (8);
	root.left.left =new TreeNode (1);
	root.left.right=new TreeNode (4);
	root.right.left=new TreeNode (6);
	root.right.right=new TreeNode (9);
	TreeNode x= M.LCA(root, 4,1);
	if(x== null)
	    System.out.println(-1);
	else
	System.out.println(x.val);
    }
    public boolean isPresent(TreeNode root, int x){
        if(root == null)
            return false;
        if(root.val == x)
            return true;
        boolean l= isPresent(root.left,x);
        boolean r=isPresent(root.right,x);
        return l || r;
    }
}
