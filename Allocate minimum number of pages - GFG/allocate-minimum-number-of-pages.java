//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
          long low=1L;
          long high=0L;
          
           if(M>N)
           return -1;
           for(Integer x:A)
           {
               high+=x;
             //  low=Math.min(low,x);
           }
           long ans=-1L;
            while(low<=high)
            {
                long pages=low+(high-low)/2;
                 if(possible(pages,A,N,M))
                 {
                    //  System.out.println("YES "+pages);
                     ans=pages;
                    high=pages-1;
                 }
                 else 
                 {  
                    //  System.out.println("NO "+pages);
                     low=pages+1;
                 }
            }
            return (int)ans;
    }
     static boolean possible(long pages,int a[],int n,int m)
     {
          int countStudents=0;
          long sum=0L;
           
            for(int i=0;i<n;i++)
            {
                if(a[i]>pages)
                 return false;
                sum+=a[i];
                 if(sum==pages)
                 {
                     countStudents++;
                     sum=0L;
                 }
                 else if(sum>pages)
                 {
                     countStudents++;
                     sum=a[i];
                 }
            }
             if(sum>0)
             {
                 countStudents++;
             }
            if(countStudents>m)
            {
                return false;
            }
            return true;
     }
};