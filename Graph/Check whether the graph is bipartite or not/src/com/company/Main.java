package com.company;
import java.util.*;
public class Main {

    public int  solve(int A, int [][] B){
        int len =B.length;
        List<Integer> l[]=new List[A];
        for(int i=0;i<A;i++){
            l[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<B.length;i++){
            l[B[i][0]].add(B[i][1]);
        }
        int [] colour =new int [A];
        Arrays.fill(colour,-1);
        for(int i=0;i<A;i++){
            if(colour[i]==-1){
                if(! bfs(i,0,l,colour))
                    return 0;
            }
        }
        return 1;
    }
    public boolean bfs(int i,int c,List<Integer> l[],int []colour){

        Queue <Integer> q=new LinkedList<>();
        q.add(i);
        colour[i]=1;

        while (! q.isEmpty() ){
            int x=q.remove();

            for(int j:l[x]) {
                if (colour[j] == colour[x])
                    return false;
                if (colour[j] == -1) {
                    q.add(j);
                    colour[j]=1-colour[x];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
	Main m =new Main();
	int A=10;
	int [][] B={{7, 8},
            {1, 2},
            {0, 9},
            {1, 3},
            {6, 7},
            {0, 3},
            {2, 5},
            {3, 8},
            {4, 8}};
	System.out.println(m.solve(A,B));
    }
}
