//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
       ArrayList<String>ans=new ArrayList<>();
            if(m[0][0]==0 || m[n-1][n-1]==0)
               return ans;
         boolean vis[][]=new boolean[n][n];
          solve(0,0,m,n,ans,vis,"");
           return ans;
    }
     static void solve(int cr,int cc,int a[][],int n,  ArrayList<String>ans,boolean vis[][],String s)
     {
           if(cr==n-1 && cc==n-1)  
           {
               ans.add(s);
                return;
           }
         if(cr<0 || cr>=n || cc<0 || cc>=n || vis[cr][cc] || a[cr][cc]==0)
            return;
            
           vis[cr][cc]=true;
           solve(cr+1,cc,a,n,ans,vis,s+'D');
           solve(cr,cc-1,a,n,ans,vis,s+'L');
           solve(cr,cc+1,a,n,ans,vis,s+'R');
           solve(cr-1,cc,a,n,ans,vis,s+'U');
           vis[cr][cc]=false;
           
     }
}