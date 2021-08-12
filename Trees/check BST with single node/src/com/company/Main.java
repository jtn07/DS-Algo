package com.company;
import java.util.*;
public class Main {

    public String solve(ArrayList<Integer> A) {
        int len =A.size();
        if(len <= 2)
            return "YES";
        int left =Integer.MIN_VALUE;
        int right =Integer.MAX_VALUE;
        return sol(A,1, left,right);
    }

    public String sol(ArrayList<Integer> A, int i, int left,int right ){
        if(i >= A.size())
            return "YES";
        int cur =A.get(i);
        if(cur <= A.get(i-1)){
            right =A.get(i-1);

            if(left <= cur && cur  <= right )
                return sol(A, i+1, left,right);
            else return "NO";
        }
        else {
            left =A.get(i-1);

            if(left <= cur && cur  <= right )
                return  sol(A, i+1, left,right);

            else return "NO";
        }

    }
    public static void main(String[] args) {
	Main m =new Main();
	int [] a={44, 49, 42, 25, 2};
	ArrayList<Integer> l= new ArrayList<>();
	for(int x:a)
	    l.add(x);
	System.out.println(m.solve(l));

    }
}
