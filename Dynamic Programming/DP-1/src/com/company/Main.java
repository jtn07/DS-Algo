package com.company;
// Find no. od square numbers requrired whose sum is equal to A
import java.util.*;
public class Main {

    static HashMap<Integer,Integer> h=new HashMap<>();
    public static int MNR(int val){

        if(val <= 1)
            return 1;
        if(val==2)
            return 2;
        if(val ==3)
            return 3;


        if(h.containsKey(val) )
            return h.get(val);
       // System.out.print("val = "+val+" ");
        double d=(double) val;
        int sq=(int)Math.sqrt(d);
        if(sq*sq == val )
            return 1;
      // System.out.print("not square root  ");
        int min=Integer.MAX_VALUE;
        for(int i=1;i <= sq ;i++){
            int t=MNR((val- (i*i)));
           //h.put((val- (i*i)),t+1);
            if(t < min)
                min=t;
        }
        h.put(val,min+1);
       // System.out.print(val+"+");
        return 1+min;
    }
    public static void main(String[] args) {
	int a=467;
	System.out.println(MNR(a) );
    }
}
