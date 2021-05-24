import java.io.*;
import java.util.*;
public class Main {
    public static int newMethods(int len,int k,String s){
        
        
        int i=0; int j =len-1;
        int count=0;
        while (i<j){
            if(s.charAt(i) != s.charAt(j))
            count++;
            i++;
            j--;
        }
        if(count==k)
        return 0;
        
        return Math.abs(count-k); 
        
        
    }
    public static void main(String args[] ) throws Exception {
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    while (t-->0){
        int len =sc.nextInt();
        int k=sc.nextInt();
         sc.nextLine();
        String s=sc.nextLine();
         //System.out.println(s);
        System.out.println(newMethods(len,k,s));
    }
    
   }
}