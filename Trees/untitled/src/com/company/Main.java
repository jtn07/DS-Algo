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
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }
}
public class Main
{
    public static TreeNode solve(ArrayList<Integer> A) {
        Queue <TreeNode> q=new LinkedList<>();
        int i=0;
        TreeNode root=new TreeNode(A.get(i++));
        q.add(root);
        TreeNode empty =null;
        while (!q.isEmpty()){
            int len =  q.size();
            while(len-- >0){
                TreeNode temp = q.remove();
                int a=A.get(i++);
                System.out.println(temp.val+","+a);
                if(a== -1){
                    temp.left=null;
                }
                else{
                    temp.left=new TreeNode(a);
                    q.add(temp.left);
                }
                a=A.get(i++);
                if(a==-1){
                    temp.right=null;
                }
                else {
                    temp.right = new TreeNode(a);
                    q.add(temp.right);
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {

        int [] A={1, 2, 6 ,-1 ,7 ,3 ,-1,  4 ,5, -1, -1, -1 ,-1, 8 ,-1, -1, -1};
        ArrayList<Integer> l=new ArrayList<>();
        for(int x:A)
            l.add(x);
        TreeNode  root = (solve(l));
        ArrayList<ArrayList<Integer>> R = verticalOrderTraversal(root);
        System.out.println(R);
    }

    static HashMap<Integer,ArrayList<Node>> h =new HashMap<>();
    static ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        sol(A,0,0);
        ArrayList<Integer> l=new ArrayList<>(h.keySet());
        Collections.sort(l);
        for(int x:l)
        {
            ArrayList<Node> t=h.get(x);
            Collections.sort(t,(a,b) -> Integer.compare (a.level ,b.level));
            ArrayList<Integer> no=new ArrayList<>();
            for(Node n:t)
                no.add(n.val);

            res.add(new ArrayList<>(no));
            //System.out.println(no);
        }
        return res;
    }


    public static  void sol(TreeNode A,int i,int j){
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
