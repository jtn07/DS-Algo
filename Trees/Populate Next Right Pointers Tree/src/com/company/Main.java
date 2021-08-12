package com.company;

public class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void solve(TreeNode root){
        TreeNode n=root;
        while(n != null){
            TreeNode temp=n;
            TreeNode t=null;
            TreeNode prev=null;
            while (temp != null ){
                if(t== null && temp.left != null){
                    t=temp.left;
                }
                if(t== null && temp.right != null){
                    t=temp.right;
                }
                if(prev != null && temp.left != null)
                    prev.next=temp.left;
                if(temp.left != null && temp.right != null){
                    temp.left.next=temp.right;
                }
                prev=temp.right;
                temp=temp.next;
            }
            n=t;
        }
    }
    public void sol(TreeNode root){
        TreeNode n=root;
        while(n != null) {
            TreeNode temp = n;
            while (temp != null) {
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
            n=n.left;
        }
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(99);
        root.left.right=new TreeNode(100);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        Main m =new Main();
        m.solve(root);
        m.sol(root);

    }
}
