package com.company;
import java.util.*;
public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
        public TreeNode solve(ArrayList<Integer> A){
            return sol(A,0,A.size()-1);
        }
        public TreeNode sol(ArrayList<Integer> A, int start, int end){
            if(start>end)
                return null;
            int mid=(start+end)/2;
            TreeNode root=new TreeNode(A.get(mid));
            root.left=sol(A,0,mid-1);
            root.right=sol(A,mid+1,end);
            return root;
        }

    public static void main(String[] args) {

        Main m =new Main();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        TreeNode n = m.solve(A);
    }
}
