//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
       Node zeroDummy=new Node(0);
       Node oneDummy=new Node(1);
       Node twoDummy=new Node(2);
       Node zero=zeroDummy;
        Node one=oneDummy;
         Node two=twoDummy;
         Node temp=head;
          while(temp!=null)
          {
              int data=temp.data;
              if(data==0)
              {
                  zero.next=temp;
                  zero=zero.next;
              }
              else if(data==1)
              {
              one.next=temp;
                  one=one.next;
                  
              }
              else if(data==2)
              {
                  two.next=temp;
                  two=two.next;
              
              }
              temp=temp.next;
              
          }
          if(one==oneDummy)
          {
              //there's no one node
              zero.next=twoDummy.next;
          }
          else{
              //there's one node 
              zero.next=oneDummy.next;
          }
          one.next=twoDummy.next;
          two.next=null;
          return zeroDummy.next;
    }
}


