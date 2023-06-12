
import java.util.*;

class CountSubArrayWithXorAsK 
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

         int a[]=new int[n];
         for(int i=0;i<n;i++)
         {
            a[i]=sc.nextInt();
         }
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        map.put(0,1);
        int prexor=0;

         for(int i=0;i<n;i++)
         {
            prexor=prexor ^ a[i];

            int x=prexor^k;

            if(map.containsKey(x))
            {
                ans+=map.get(x);
            }

             map.put(prexor,map.getOrDefault(prexor, 0) + 1);
         }
        System.out.println(ans);
    }
}