import java.util.*;
public class MergeAllOverlappingIntervals {
   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
        int a[][]=new int[n][2];

         for(int i=0;i<n;i++)
         {
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
         }

         Arrays.sort(a,(one,two)->{
              if(one[0]==two[0])
              {
                 return one[1]-two[1];
              }
              else 
              {
                return one[0]-two[0];
              }
         });

        brute(a,n); 
   } 
   static void brute(int a[][],int n)
   {
      ArrayList<Pair>list=new ArrayList<>();
       for(int i=0;i<n;i++)
       {
          int start=a[i][0];
          int end=a[i][1];
           
           if(list.size()>0 && list.get(list.size()-1).y>=end)
              continue;

           for(int j=i+1;j<n;j++)
           {
              if(a[j][0]<=end)
              {
                 end=Math.max(end,a[j][1]);
              }
              else 
              {
                 break;
              }
           } 
            list.add(new Pair(start, end))  ;
       }

       for(Pair p:list)
       {
          System.out.println(p.x+" "+p.y);
       }
   }
}

class Pair 
{
    int x;
    int y;
     Pair(int x,int y)
     {
        this.x=x;
        this.y=y;
     }
     
}