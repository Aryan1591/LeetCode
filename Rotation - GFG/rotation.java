//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
         return findMin(arr);
    }
    int findMin(int a[])
    {
        int n=a.length;
        int low=0;
        int high=n-1;
        int ans=Integer.MAX_VALUE;
        int pos=-1;
         while(low<=high)
         {
             int mid=low+(high-low)/2;
              if(a[low]<=a[mid])
              {
                  if(a[low]<ans)
                  {
                      pos=low;
                      ans=a[low];
                  }
                  low=mid+1;
              }
              else 
              {
                  if(a[mid]<ans)
                  {
                      ans=a[mid];
                      pos=mid;
                  }
                  high=mid-1;
              }
         }
         return pos;
    }
}