package com.company;
import java.util.*;
class TreeNode{
    int val;
    TreeNode left= null;
    TreeNode right =null;
    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }

}
 class Solution {
    ArrayList<Integer> res=new ArrayList<>();
    int prev=0;
    int curr=0;
    int n1=-100;
    int n2=-100;
    public ArrayList<Integer> recoverTree(TreeNode A) {
        solve(A);
        res.add(n1);
        res.add(n2);
        return res;
    }
    public void solve(TreeNode root){
        if(root == null)
            return ;
        solve(root.left);
        prev=curr;
        curr=root.val;
        System.out.println(prev +" "+curr);
        if(prev > curr){
            if(n1 == -100){
                n1=prev;
                n2=curr;
            }
            else n2=curr;
        }
        solve(root.right);
    }

     Queue<TreeNode> q=new LinkedList<>();
     public TreeNode flatten(TreeNode a) {
         TreeNode head = null;
         TreeNode Q=head;
         sol(a);
         Queue <TreeNode > h=new LinkedList<>();
         while (!q.isEmpty()){
             head=q.remove();
             h.add(head);
             head.right =null;

         }

         return h.remove();
     }

     public void sol(TreeNode a){
         if(a== null)
             return ;

         sol(a.left);

         q.add(a);

         sol(a.right);

     }

}

public class Main {

    public static void main(String[] args) {
	int [] arr={5,3,8,1,4,7,9};
	Main m =new Main();
	Solution s=new Solution();
	TreeNode root=new TreeNode(5);
	root.left=new TreeNode(3);
	root.right=new TreeNode(8);
	root.left.left=new TreeNode(1);
	root.left.right=new TreeNode(7);
	root.right.left=new TreeNode(4);
	root.right.right=new TreeNode(9);
	//System.out.println(s.recoverTree(root));
    // TreeNode l=s.flatten (root);
   // while(l != null){
     //   System.out.println(l.val);
       // l=l.right;
    //}

        int x =m.so(root);
        System.out.println(x);
    }

    int sum=0;
    boolean x=true;
    public int so(TreeNode root) {
        boolean v=true;
        solv(root,v);
        if( x== true)
            return 1;
        return 0;

    }
    public void solv (TreeNode root, boolean v){

        if(root == null)
            return ;

        if( x == false )
            return ;

        solv(root.left,v);
        solv(root.right,v);

        if(root.left != null || root.right != null ){
            System.out.println(root.val+" "+sum);
            if(sum != root.val )
                x= false;
        }
        sum=sum+root.val;
    }

}
