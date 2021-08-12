package com.company;
import java.util.*;
class TreeNode  {
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
    HashMap<Integer,ArrayList<Integer>> h =new HashMap<>();
    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public  ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        sol(A,0);

        ArrayList<Integer> l=new ArrayList<>(h.keySet());
        Collections.sort(l);
        for(int x:l)
        {
            ArrayList<Integer> t=new ArrayList<>(h.get(x));
            Collections.reverse(t);
            res.add(new ArrayList<>(t));
            System.out.println(x+" "+t);
        }
        return res;
    }
    public  void solve(TreeNode A,int i){
        if(A == null)
        {
            return;
        }
           solve(A.left,i-1);

            solve(A.right,i+1);
        if(h.containsKey(i)){

            ArrayList<Integer> C=new ArrayList<>(h.get(i));
            C.add(A.val);
            h.put(i,new ArrayList<Integer>(C));
        }
        else{
            ArrayList<Integer> T=new ArrayList<>();
            T.add(A.val);
            h.put(i,new ArrayList<Integer>(T));
        }

    }
    public  void sol(TreeNode A,int i){
        if(A == null)
        {
            return ;
        }


        sol(A.left,i-1);

        sol(A.right,i+1);
        if(h.containsKey(i)){

            ArrayList<Integer> C=h.get(i);
            C.add(A.val);
            h.put(i,C);
        }
        else{
            ArrayList<Integer> T=new ArrayList<>();
            T.add(A.val);
            h.put(i,new ArrayList<>(T));
        }
    }
    int x=0;
    public int solv(TreeNode A) {

        if(A==null)
            return 0;

        return ( Math.max(1+ solv(A.left),solv(A.right)));


    }

    public static void main(String[] args) {
        Main M=new Main();
	TreeNode root =null;
	root=new TreeNode (1);
	root.left=new TreeNode(2);
	root.left.left=new TreeNode (3);
	root.left.right=new TreeNode (4);
	root.right=new TreeNode(5);
	root.right.right=new TreeNode(7);
	root.right.left=new TreeNode(6);
    System.out.println(M.verticalOrderTraversal(root));
   // System.out.println(M.solv(root));
    //System.out.println(M.s(root));
    Solution s=new Solution();

    //s.printTree(root);

    }
    Queue<TreeNode> q=new LinkedList<>();
    ArrayList<Integer> temp=new ArrayList<>();
    public ArrayList<Integer> s(TreeNode A) {

        if (A == null)
            return temp;
        q.add(A);
        //ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        while (!q.isEmpty()) {
            int i = 0;
            int k = 0;
            int len = q.size();


            while (i < len) {


                TreeNode t = q.remove();
                if (t == null)
                    continue;
                if (k == 0)
                    temp.add(t.val);

                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
                k++;
                i++;
            }

        }
        return temp;
    }
}

class Solution {
    static class Node {
        int value;
        int level;
        public Node (int value,int level){
            this.value=value;
            this.level=level;
        }
    }
    int imin=0;
    int imax=0;

    List<List<String>> res=new ArrayList<>();
    HashMap<Integer,ArrayList<Node>>  h=new HashMap<>();
    public List<List<String>> printTree(TreeNode root) {

        solve(root,0,0);


        ArrayList<Integer> keys=new ArrayList<>(h.keySet());
        int len=keys.size();
        Collections.sort(keys);
        for (int i:keys ){
            List<String> temp=new ArrayList<>();
            for(int k=0;k<len;k++)
                temp.add("");System.out.println(temp);
            ArrayList<Node> t=h.get(i);
            for(Node n:t)
            System.out.print(n.value);
            Collections.sort(t, (a,b)-> Integer.compare(a.level,b.level)  );
            for(Node n:t ){
                int value=n.value;
               // System.out.println(value);
                int level=n.level;
                temp.set(level,value+"");
            }
            res.add(new ArrayList<>(temp));
            System.out.println(temp);

        }
        return res;

    }

    public void solve(TreeNode A, int i,int j) {

        if (A == null)
            return;
        if (j > imax)
            imax = j;
        if (j < imin)
            imin = j;

        if (h.containsKey(j)) {
            ArrayList<Node> temp = h.get(j);
            temp.add(new Node(A.val, i));
            h.put(j, new ArrayList<>(temp));
        } else {
            ArrayList<Node> temp = new ArrayList<>();
            temp.add(new Node(A.val, i));
            h.put(j, new ArrayList<>(temp));
        }

        solve(A.left, i++, j--);
        solve(A.right, i++, j++);
    }

    }