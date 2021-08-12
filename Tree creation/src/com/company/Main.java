package com.company;
 class Node {
    int data;
    Node left;
    Node right;
    public Node (int value){
        data=value;
        left=right=null;
    }
}
public class Main {
    static void Inorder(Node node){
             if(node == null)
             return;
             System.out.print(node.data+" ");
             Inorder(node.left);
             Inorder(node.right);
    }
    static Node  Insert (Node node , int value){
            if (node==null){
            Node a=new Node(value);
            return a;
            }
            if (node.data >= value) {
                node.left= Insert(node.left, value);
            } else {
                node.right= Insert(node.right, value);
            }
            return node;
    }
    public static void main(String[] args) {
        Node root=null;
        int [] arr={5,4,6,3,7,2,8,1,9};
        root=Insert(root,arr[0]);
        Node temp=root;
        for (int i=1;i<arr.length;i++) {
        temp=Insert(temp,arr[i]);
        //System.out.println(root.data);
        }
        Inorder(temp);
    }
}