package com.company;
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right ;
    public TreeNode(int val){
        this.val=val;

    }
}
public class Main {
    int count=0;
    public int solve(TreeNode A, TreeNode B){
        HashSet<Integer> h=new HashSet<>();
        traversal(A,h);
        tree_traversal(B,h);
        int x=count;
        count=0;
        return x;
    }
    public void traversal(TreeNode A,HashSet<Integer> h){
        if(A== null)
            return;
        h.add(A.val);
        traversal(A.left,h);
        traversal(A.right,h);
    }
    public void tree_traversal(TreeNode B, HashSet<Integer> h){
        if(B== null)
            return ;
        if( h.contains(B.val))
            count+=B.val;
        tree_traversal(B.left,h);
        tree_traversal(B.right,h);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right =new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.right.right=new TreeNode(3);
        root.right.left=new TreeNode(4);

        TreeNode root2=new TreeNode(1);
        root2.left=new TreeNode(2);
        root2.right =new TreeNode(2);
        root2.left.left=new TreeNode(3);
        root2.right.right=new TreeNode(3);
        root2.right.left=new TreeNode(4);
        Main m =new Main();
        System.out.println(m.solve(root,root2));

    }
}
