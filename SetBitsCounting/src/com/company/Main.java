package com.company;
import java.util.Scanner;
import java.lang.*;
public class Main {

    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int count=0;

	for(int i=1;i<=n;i++){
	    int temp=i;
	    while (temp>0){
	          temp&=(temp-1);
	          count++;            //count += temp&1;
	                              //temp>>=1;
        }
    }
	System.out.println(count);
    }
}
