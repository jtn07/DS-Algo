package com.company;
import java.util.*;
public class Main {
 static int[][] antiDiagonal(int [][] A ){
    int len =A.length;
    int [] []arr=new int[(2*len)-1][];
    int row=1;
    for(int l=1;l<=len;l++){
        arr[l-1] = new int[l];
        int I=0;       // row increment is done
        int J=l-1;
        for(int i=1;i<=l;i++)
            arr[l-1][i-1]=A[I++][J--];

    }
       //Column increment


     for(int l=1;l<len;l++){
         arr[len+l-1] = new int[len-l];

         int I=l;
         int J=len-1;

         for(int i=0;i<(len-l);i++){
           arr[len+l-1][i]=A[I++][J--];
             //System.out.print(len+l-1+" "+i +", = "+A[I++][J--]+" ");
         }

     }
return arr;
}
    public static void main(String[] args) {
	Scanner sc=new Scanner (System.in);
	int[][] A={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	int[][]B =antiDiagonal(A);
for(int i=0;i<B.length;i++){
    for(int j=0;j<(B[i]).length;j++)
    System.out.print(B[i][j]+" ");
    System.out.println();
}


    }
}
