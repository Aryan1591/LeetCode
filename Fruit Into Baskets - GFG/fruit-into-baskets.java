//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
           HashMap<Integer,Integer>map=new HashMap<>();
           int end=0;
           int start=0;
           int ans=0;
           while(end<N)
           {
                
                if(!map.containsKey(fruits[end]))
                {
                    map.put(fruits[end],1);
                }
                else 
                {
                    map.put(fruits[end],map.get(fruits[end])+1);
                }
                 while(map.size()>2)
                {
                    
                   if(map.get(fruits[start])==1)
                   {
                       map.remove(fruits[start]);
                   }
                   else 
                   {
                       map.put(fruits[start],map.get(fruits[start])-1);   
                   }
                   start++;
                }
                  
                ans=Math.max(ans,end-start+1);
                end++;
                
           }
           return ans;
    }
}