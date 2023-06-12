public class MedianOfRowWiseSortedMatrix {
    
}
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
