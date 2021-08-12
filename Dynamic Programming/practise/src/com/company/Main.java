package com.company;
import java.util.*;
public class Main {
        public int  solve(int A, int [][] B){
            int len =B.length;
            List<Integer> l[]=new List[A+1];
            for(int i=0;i<=A;i++){
                l[i]=new ArrayList<Integer>();
            }
            for(int i=0;i<B.length;i++){
                l[B[i][0]].add(B[i][1]);
                l[B[i][1]].add(B[i][0]);
            }
            int count=0;
            int [] colour =new int [A+1];
            Arrays.fill(colour,-1);
            for(int i=0;i<=A;i++){
                if(colour[i]== -1){
                    if(! bfs(i,0,l,colour))
                        count++;// useless in this case
                }
            }
            long a =0;
            long b=0;
            for(int i=1;i<A+1;i++){
                if(colour[i]==0)
                    a++;
                else b++;
            }
            int r= (int) (a*b)%1000000007;
            return (r - (A))+1;
        }

        public boolean bfs(int i,int c,List<Integer> l[],int []colour){

            Queue <Integer> q=new LinkedList<>();
            q.add(i);
            colour[i]=1;

            while (! q.isEmpty() ){
                int x=q.remove();
                // System.out.println(x);
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
        int A=2;
        int [][] B={{2,1}};
        System.out.println(m.solve(A,B));
    }
}