package com.company;

import java.util.*;
public class Main {
    public int solve(int[] arr,int b,int c) {
        int len =arr.length;
        List<Integer> [] l=new List [len+1];
        for(int i=0;i<=len;i++){
            l[i]=new ArrayList<>();
        }
        for(int i=0;i<len;i++){
            l[arr[i]].add(i+1);
        }
        boolean [] vis=new boolean [len+1];
        if(b >= vis.length || c >= vis.length )
            return 0;
        dfs(arr,c,l,vis,b,c);
        return vis[b]? 1:0;
    }
    public void dfs(int [] arr, int i,List<Integer> []l, boolean [] vis,int b,int c ){
        if(i >= vis.length )
            return;
        if(vis[i])
            return ;
        vis[i]=true;
        if(i==b){
            vis[b]=true;return;}
        for(int j=0;j< (l[i].size());j++ ){
            dfs(arr,l[i].get(j),l,vis,b,c);
        }
    }
    public static void main(String[] args) {
        Main m=new Main();
        int [] arr={1,1,2};
        System.out.println(m.solve(arr,1,3));
    }
}

