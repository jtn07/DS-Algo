package com.company;

public class Main {
    public static void solve(int[][] A) {
        int n = A.length;

        int i = 0;
        int j = 0;
        int k = n-1;
        // Solution s=new Solution();
        while (i < n / 2) {
            A = performAction(i, j, A, k--);
            i++;
            j++;

        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                System.out.print(A[x][y] + " ");
            }
            System.out.println();
        }

    }

    static int[][] performAction(int i, int j, int[][] A, int n) {
        int topLi = i, topLj = j, topRi = i, topRj = n;
        int botLi = n, botLj = j, botRi = n, botRj = n;
        int x = i;
      //  System.out.println("i value " + i + "j value " + j + "n value " + n);
        while ((x++) < (n)) {
            //  System.out.println(A[topRi][2]);
            int temp1 = A[topRi][topRj];
            //System.out.println("temp1="+A[topRi][topRj]);
            A[topRi][topRj] = A[topLi][topLj];
            //   System.out.println("  A[topRi][topRj]="+A[topLi][topLj]);

            int temp2 = A[botRi][botRj];
            //      System.out.println("temp2="+A[botRi][botRj]);

            A[botRi][botRj] = temp1;
            //       System.out.println("A[botRi][botRj]="+temp1);
             temp1 = A[botLi][botLj];
            //         System.out.println("temp1="+A[botLi][botLj]);

            A[botLi][botLj] = temp2;
            // System.out.println(" A[botLi][botLj]="+temp2);
            A[topLi][topLj] = temp1;
            // System.out.println("A[topLi][topLj]="+temp1);
            topLj++;
            topRi++;
            botLi--;
            botRj--;

        }


        return A;

    }

    public static void main(String[] args) {
        int A[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};   //{1,2,3},{4,5,6},{7,8,9}
        solve(A);


    }

}