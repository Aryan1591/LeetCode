class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
         int n=nums1.length;
         int a[]=new int[n+1];
         int b[]=new int[n+1];
          a[0]=-1;
          b[0]=-1;
           for(int i=0;i<n;i++)
           {
               a[i+1]=nums1[i];
           }
           for(int i=0;i<n;i++)
           {
               b[i+1]=nums2[i];
           }
           int dp[][]=new int[n+1][2];
             for(int i=0;i<=n;i++)
             {
                 for(int j=0;j<2;j++)
                 {
                     dp[i][j]=-1;
                 }
             }
        return solve(a,b,1,0,dp);     
    }
     int solve(int a[],int b[],int index,int swapped,int dp[][])
     {
         if(index>=a.length)
           return 0;
            if(dp[index][swapped]!=-1)
              return dp[index][swapped];
          int prev1=a[index-1];
          int prev2=b[index-1];
            if(swapped==1)
            {
                int temp=prev1;
                prev1=prev2;
                prev2=temp;
            } 
            int ans=Integer.MAX_VALUE;
            int no_swap=Integer.MAX_VALUE;
            int swap=Integer.MAX_VALUE;
            if(a[index]>prev1 && b[index]>prev2)
            {
                no_swap=solve(a,b,index+1,0,dp);
            }
            if(a[index]>prev2 && b[index]>prev1)
            {
                swap=1+solve(a,b,index+1,1,dp);
            }
            return dp[index][swapped]=Math.min(swap,no_swap);
     }
}