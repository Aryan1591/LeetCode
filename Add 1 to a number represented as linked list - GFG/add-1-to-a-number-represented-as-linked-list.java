//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
       head=reverse(head);
       int carry=1;
        Node newHead=null;
        Node current=null;
        while(head!=null)
        {
            int sum=head.data+carry;
            Node newNode=new Node(sum%10);
            if(newHead==null)
            {
                newHead=newNode;
                current=newNode;
            }
            else 
            {
                 current.next=newNode;
                 current=newNode;
            }
            carry=sum/10;
            head=head.next;
        }
        if(carry>0)
        {
           Node newNode=new Node(1);  
             current.next=newNode;
             current=newNode;
        }
        return reverse(newHead);
    }
    static Node reverse(Node head)
    {
        Node prevNode=null;
        Node current=head;
        Node nextNode = null;
         while(current!=null)
         {
             nextNode=current.next;
             current.next=prevNode;
             prevNode=current;
             current=nextNode;
         }
         return prevNode;
    }
}
 
