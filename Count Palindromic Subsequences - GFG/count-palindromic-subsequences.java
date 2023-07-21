//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    long mod=(long)1e9+7;
    long countPS(String s)
    {
         int len=s.length();
        long dp[][]=new long[len][len];
        for(int i=0;i<len;i++)
        {
            Arrays.fill(dp[i],-1L);
        }
        return solve(0,len-1,s,dp);
    }
   long solve(int start,int end,String s,long dp[][])
    {
         if(start==end)
         {
             return 1L;
         }
         if(start>end)
            return 0L;
         if(end==start+1)
         {
             if(s.charAt(start)==s.charAt(end))
             {
                 return 3L;
             }
             return 2L;
         }   
         if(dp[start][end]!=-1L)
            return dp[start][end];

            long first=solve(start+1,end,s,dp)%mod;
            long second=solve(start,end-1,s,dp)%mod;
            long third=solve(start+1,end-1,s,dp)%mod;
        if(s.charAt(start)!=s.charAt(end))
        {
           

            return dp[start][end] = ((first%mod) + (second%mod) - (third%mod) + mod )%mod;
        }

        long fourth= (1 + solve(start+1,end-1,s,dp)%mod)%mod;

        return dp[start][end]=((fourth%mod)+(first%mod)+(second%mod) - (third%mod) + mod )%mod;



    }
}