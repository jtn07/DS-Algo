package com.company;

public class Main {
public static int [][] solve(int [][] arr){
    int [] []ar= new int[arr.length][arr.length];
    int len =arr.length;
    ar[0][0]=arr[0][0];

    for(int i=1;i<len;i++){
        ar[0][i]=ar[0][i-1]+arr[0][i];
    }
    for(int i=1;i<len;i++){
        ar[i][0]=ar[i-1][0]+arr[i][0];
    }
    for(int i=1;i<len;i++){
        int[] column=new int[len];

        for(int j=1;j<len;j++){
            column[0]=arr[i][0];
            ar[i][j]=ar[i-1][j]+column[j-1]+arr[i][j];
            column[j]=column[j-1]+arr[i][j];
        }
    }
    return ar;
}
    public static void main(String[] args) {
	int [] []arr={{1,2,3},{4,5,6},{7,8,9}};
	int [][] result=solve(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
	for(int i=0;i<arr.length;i++){
	    for(int j=0;j<arr.length;j++){
            System.out.print(result[i][j]+" ");
        }
	    System.out.println();
    }


    }
}
