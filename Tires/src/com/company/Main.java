package com.company;
import java.util.*;
class TrieNode {
    char val;
    TrieNode [] arr;
    boolean isEnd;
    int count;
    public TrieNode(char val) {
     this.val=val;
     this.arr=new TrieNode[26];
        for (int i = 0; i < 26; i++) {
        arr[i]=null;

     }
        this.isEnd=false;
        this.count=1;
    }
}
public class Main {
    public static TrieNode insert(TrieNode root, char ch){
        if(root.arr[ch-'a'] == null)
        root.arr[ch-'a']=new TrieNode(ch);
        else root.arr[ch-'a'].count++;
        return root.arr[ch-'a'];
    }
    public static boolean search(TrieNode root,String s,int k){
        if(k==s.length()) {
         System.out.println();
            return true;
        }
        if( root.arr[s.charAt(k) - 'a'] == null) {
            System.out.println();
            return false;
        }
        else {
            System.out.print(root.arr[s.charAt(k) - 'a'].count);
            return search(root.arr[s.charAt(k) - 'a'],s,k+1);
        }
    }
    public static void main(String[] args) {
	TrieNode root =new TrieNode('/');
        String s="jatin";
        TrieNode temp = root;
        for(int i=0;i<s.length();i++) {
            char ch =s.charAt(i);
            temp=insert(temp, ch);
        }
         temp = root;
        s="jat";
        for(int i=0;i<s.length();i++) {
            char ch =s.charAt(i);
            temp=insert(temp, ch);
        }
        System.out.println(search(root,"jatin",0));


    }
}
