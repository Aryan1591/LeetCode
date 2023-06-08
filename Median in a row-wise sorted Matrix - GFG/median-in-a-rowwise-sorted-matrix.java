//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        int low=1;
        int high=2001;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int count=0;
             for(int i=0;i<R;i++)
             {
                 int row[]=matrix[i];
                 count+=numberSmallerThanOrEqualTo(row,mid);
             }
            if(count<=(R*C)/2)
            {
                low=mid+1;
            }
            else 
            {
                high=mid-1;
            }
        }
        return low;
    }
    int numberSmallerThanOrEqualTo(int a[],int target)
    {
        int n=a.length;
         int low=0;
         int high=n-1;
         int ans=n;
         while(low<=high)
         {
             int mid=(low+high)/2;
             if(a[mid]<=target)
             {
                 low=mid+1;
             }
             else 
             {
                ans=mid;
                high=mid-1;
             }
         }
         return ans;
    }
}