package com.company;
import java.util.*;
class Node {

    int level;
    int val;
    public Node(int val,int level){
        this.val=val;
        this.level=level;
    }
}
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

    public static void main(String[] args) {

    }
}



class Solution {
    Node n =null;
    HashMap<Integer,ArrayList<Node>> h =new HashMap<>();
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        sol(A,0,0);
        ArrayList<Integer> l=new ArrayList<>(h.keySet());
        Collections.sort(l);
        int len =l.size();
        ArrayList<ArrayList<String>> res=new ArrayList<>();

        for(int x:l)
        {
            ArrayList<Node> t=h.get(x);
            Collections.sort(t, (a,b) -> Integer.compare (a.level ,b.level));
            ArrayList<String> no=new ArrayList<>();
            for(int k=0;k<len;k++)
            no.add("");
            for(Node n:t) {
                int val=n.val;
                int level=n.level;
                no.set(level,val+"");
            }
            res.add(new ArrayList<>(no));
        }
        return res;
    }
    public   void sol(TreeNode A,int i,int j){
        if(A == null)
        {
            return;
        }
        if(h.containsKey(i)){

            ArrayList<Node> C=h.get(i);
            C.add(new Node (A.val,j));

            h.put(i,new ArrayList<>(C));
        }
        else{
            ArrayList<Node> T=new ArrayList<>();
            T.add(new Node (A.val,j));
            h.put(i,new ArrayList<>(T));
        }
        sol(A.left,i-1,j+1);
        sol(A.right,i+1,j+1);
    }

}
