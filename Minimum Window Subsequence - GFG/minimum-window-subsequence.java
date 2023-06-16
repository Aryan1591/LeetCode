//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String minWindow(String str1, String str2) {
        // code here
         int n=str1.length();
         int m=str2.length();
          int ptr1=0;
          int ptr2=0;
           while(ptr1<n && ptr2<m)
           {
               if(str1.charAt(ptr1)==str2.charAt(ptr2))
               {
                   ptr1++;
                   ptr2++;
               }
               else 
               {
                   ptr1++;
               }
           }
           if(ptr2!=m)
           {
               return "";
           }
           int end=ptr1;
           int start=-1;
           ptr1--;
           ptr2--;
            while(ptr1>=0 && ptr2>=0)
            {
                if(str1.charAt(ptr1)==str2.charAt(ptr2))
                {
                    ptr1--;
                    ptr2--;
                }
                else 
                {
                    ptr1--;
                }
                if(ptr2<0)
                {
                    start=ptr1;
                     break;
                }
            }
            return str1.substring(start+1,end);
    }
}
