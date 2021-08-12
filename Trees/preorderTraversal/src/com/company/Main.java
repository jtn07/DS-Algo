package com.company;
import java.util.*;
public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
        this.val=val;
    }
    }
    public ArrayList<Integer> preorderTraversal(TreeNode A){

        ArrayList<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode a=A;
        while (! st.isEmpty() || a != null){
            if(a == null){
                TreeNode x=st.pop();
                a=x.right;
            }
            else {
                res.add(a.val);
                st.push(a);
                a=a.left;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        Main m= new Main();

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right =new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.right.right=new TreeNode(3);


       ArrayList<Integer> res=(m.preorderTraversal(root));

       for(int x:res)
           System.out.print(x+" ");

    }
}
