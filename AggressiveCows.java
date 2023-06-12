public class Solution {
    public static int solve(int n, int k, int[] stalls) {
         int low=1;
         int high=(int)1e9;
         Arrays.sort(stalls);
         int ans=1;
         while(low<=high)
         {
             int mid=low+(high-low)/2;
              if(canIPlaceInMidDistance(mid,n,k,stalls))
              {
                  ans=mid;
                  low=mid+1;
              }
              else 
              {
                  high=mid-1;
              }
         }
         return ans;
    }
    static boolean canIPlaceInMidDistance(int mid,int n,int k,int stalls[])
    {
         int cowsPlaced=1;
         int lastPos=0;
          for(int i=1;i<n;i++)
          {
              if(stalls[i]-stalls[lastPos]>=mid)
              {
                  cowsPlaced++;
                  lastPos=i;
              }
          }
          if(cowsPlaced>=k)
          {
               return true;
          }
          return false;
         
    }
} 