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
    public ArrayList<Integer> solve (TreeNode A){
       Queue<TreeNode> q=new LinkedList<>();
       ArrayList<Integer> res=new ArrayList<>();
       q.add(A);
       while (! q.isEmpty()){
           TreeNode removed=q.remove();
           if(removed == null)
               res.add(-1);
           else {
               res.add(removed.val);
               q.add(removed.left);
               q.add(removed.right);
           }
       }
       return res;
    }

    public static void main(String[] args) {
        Main m= new Main();

        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.right=new TreeNode(3);
        root.right.right.right=new TreeNode(4);


        ArrayList<Integer> res=(m.solve(root));

        for(int x:res)
            System.out.print(x+" ");

    }
}
