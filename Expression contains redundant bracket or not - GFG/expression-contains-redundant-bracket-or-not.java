//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String s) {
       Stack<Character>st=new Stack<>(); 
        int n=s.length();
         for(int i=0;i<n;i++)
         {
             char ch=s.charAt(i);
             if(ch=='(' || operator(ch))
             {
                 st.push(ch);
             }
             else 
             {
                 if(ch==')')
                 {
                     boolean redundant=true;
                      while(st.peek()!='(')
                      {
                          char c=st.peek();
                          if(operator(c))
                          {
                              redundant=false;
                          }
                          st.pop();
                      }
                      st.pop();
                      if(redundant)
                       return 1;
                       
                 }
             }
         }
         return 0;
    }

  static boolean operator(char ch)
  {
      if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
      {
          return  true;
      }
      return false;
  }
}
