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
        int n=str1.length();
        int m=str2.length();
        int ans[]={-1,0,0};
         for(int i=0;i<n;i++)
         {
             if(str1.charAt(i)==str2.charAt(0))
             {
                 int ptr1=i;
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
                  if(ptr2==m)
                  {
                      //valid 
                      if(ans[0]==-1 || ans[0]>(ptr1-i))
                      {
                          ans[0]=(ptr1-i);
                          ans[1]=i;
                          ans[2]=ptr1;
                      }
                  }
             }
         }
         return ans[0]==-1 ? "":str1.substring(ans[1],ans[2]);
    }
}
