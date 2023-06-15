//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int ans=-1;
         HashMap<Character,Integer>map=new HashMap<>();
          int j=0;
          int i=0;
           int n=s.length();
            while(j<n)
            {
                if(map.containsKey(s.charAt(j)))
                {
                    map.put(s.charAt(j),map.get(s.charAt(j))+1);
                }
                else 
                {
                    map.put(s.charAt(j),1);
                }
                
                 while(map.size()>k)
                 {
                      char c=s.charAt(i);
                       if(map.get(c)==1)
                       {
                           map.remove(c);
                       }
                       else 
                       {
                           map.put(c,map.get(c)-1);
                       }
                       i++;
                 }
                 if(map.size()==k)
                 {
                     ans=Math.max(ans,j-i+1);
                 }
                 
                 j++;
            }
            return ans;
    }
}