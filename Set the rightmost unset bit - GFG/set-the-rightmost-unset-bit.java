//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int ans  = ob.setBit(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int setBit(int N){
        int temp=N;
        int pos0=-1;
        int count=0;
        while(temp>1)
        {
            if(temp%2==0)
            {
               pos0=count;
               break;
            }
            count++;
            temp=temp/2;
        }
        if(pos0==-1)
         return N;
        return ((N) | (1<<pos0));
        
}
}