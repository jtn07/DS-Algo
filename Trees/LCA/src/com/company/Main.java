package com.company;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class Main {
    boolean n1 = false;
    boolean n2 = false;
    TreeNode head = null;
    public Main() {
    }
    public TreeNode LCA(TreeNode root, int a, int b) {
        this.head = root;
        TreeNode temp = this.findLCA(root, a, b);
        if (this.n1 && this.n2) {
            return temp;
        } else if (this.n1) {
            return this.isPresent(temp, b) ? temp : null;
        } else {
            return this.isPresent(temp, a) ? temp : null;
        }
    }
    public TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null) {
            return null;
        } else if (root.val != a && root.val != b) {
            TreeNode left = this.findLCA(root.left, a, b);
            TreeNode right = this.findLCA(root.right, a, b);
            if (left != null && right != null) {
                return root;
            } else {
                return left != null ? left : right;
            }
        } else if (root.val == a) {
            this.n1 = true;
            return root;
        } else {
            this.n2 = true;
            return root;
        }
    }
    public static void main(String[] args) {
        Main M = new Main();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode x = M.LCA(root, 4, 1);
        if (x == null) {
            System.out.println(-1);
        } else {
            System.out.println(x.val);
        }
    }
    public boolean isPresent(TreeNode root, int x) {
        if (root == null) {
            return false;
        } else if (root.val == x) {
            return true;
        } else {
            boolean l = this.isPresent(root.left, x);
            boolean r = this.isPresent(root.right, x);
            return l || r;
        }
    }
}
