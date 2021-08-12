package com.company;
import java.util.*;
class TrieNode {
    char val;
    TrieNode [] arr;
    boolean isEnd;
    int count;
    public TrieNode(char val,boolean End) {
        this.val=val;
        this.arr=new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            arr[i]=null;

        }
        this.isEnd=End;
        this.count=1;
    }
}
public class Main {

    public static TrieNode insert(TrieNode root, char ch,boolean end){
        if(root.arr[ch-'a'] == null)
            root.arr[ch-'a']=new TrieNode(ch,end);
        else root.arr[ch-'a'].count++;
        return root.arr[ch-'a'];
    }
    public static String search(TrieNode root,String s,int k){
        TrieNode temp=root.arr[s.charAt(k)-'a'];
        if(temp.count == 1 || temp.isEnd){
            System.out.println(temp.val+" "+temp.count+" "+temp.isEnd);
            String res=s.substring(0,k+1);
            if(temp.count != 1)
                return res+".";
            return res;
        }
        else return search(temp,s,k+1);
    }
    public static void main(String[] args) {
        TrieNode root =new TrieNode('/',false);
        String [] arr={"zebra", "dog", "duck", "dove"};
        for(String s:arr) {
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                boolean End=false;
                if (i == s.length() - 1) {
                    End = true;
                }
                temp = insert(temp, ch, End);
            }
        }
        ArrayList<String> prefix=new ArrayList<>();
        for(String s:arr){
            String tempstring=search(root,s,0);
            System.out.println(tempstring);
            prefix.add(tempstring);
        }
    }
}
