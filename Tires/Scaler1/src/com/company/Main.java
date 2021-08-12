package com.company;
/*Given an array of words A (dictionary) and another array B (which contain some words).

You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if it is not.

Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.

Problem Constraints
1 <= |A| <= 1000

1 <= sum of all strings in A <= 50000

1 <= |B| <= 1000

Input Format
First argument is array of strings A.

First argument is array of strings B.



Output Format
Return the binary array of integers according to the given format.

Example Input
Input 1:

A = [ "hat", "cat", "rat" ]
B = [ "cat", "ball" ]
Input 2:

A = [ "tape", "bcci" ]
B = [ "table", "cci" ]

Example Output
Output 1:

[1, 0]
Output 2:

[0, 0]

Example Explanation
Explanation 1:

Only "cat" is present in the dictionary.
Explanation 2:

None of the words are present in the dictionary.
*/


import java.util.*;
class TrieNode{

    char val;
    int count;
    boolean isEnd;
    TrieNode [] arr;
    public TrieNode (char val,boolean End){
        this.val=val;
        this.isEnd=End;
        this.arr=new TrieNode [26];
        for(int i=0;i<26;i++){
            this.arr[i]=null;
        }
        this.count=1;
    }
}
public class Main {
    public static TrieNode insert(TrieNode root, char ch, boolean End){
        if(root.arr[ch-'a'] == null)
            root.arr[ch-'a']= new TrieNode(ch,End);
        else {
            root.arr[ch - 'a'].count++;
            if(End)
            root.arr[ch - 'a'].isEnd = End;
        }
        return root.arr[ch-'a'];
    }
    public static int search (TrieNode root, String s, int k){
        if(k == s.length()-1 ){
            if(root.arr[s.charAt(k)-'a'] != null && root.arr[s.charAt(k) - 'a'].isEnd)
                return 1 ;
            else {
                return 0;
            }
        }
        if(root.arr[s.charAt(k)-'a' ]== null  )
            return 0;
        else return search(root.arr[s.charAt(k) -'a'], s,k+1 );
    }
    public static void main(String[] args) {
        TrieNode root =new TrieNode ('/',false);
        String  []A={"ab", "abc", "abcd", "abcde", "abcdef", "abcdefg"};
        String [] B={"a", "b", "ab", "abcd"};
        for(String x:A){
            int len =x.length();
            TrieNode temp =root;
            for(int i=0;i<len;i++){
                char ch=x.charAt(i);
                boolean End=false;
                if (i == x.length() - 1) {
                    End = true;
                }
                temp = insert(temp, ch, End);
            }
        }
ArrayList<Integer> res =new ArrayList<>();
        for(String x: B){
            int val=(search(root,x,0));
            res.add(val);
        }
        for(int x:res)
            System.out.print(x+" ");
    }
}
