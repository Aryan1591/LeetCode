class Solution {
    public int minSwapsCouples(int[] row) {
        HashMap<Integer,Integer>h=new HashMap<>();
          int n=row.length;
          for(int i=0;i<n;i++)
          {
              h.put(row[i],i);
          }
          int swaps=0;
            for(int i=0;i<n;i=i+2)
            {
                int first=row[i];
                int second=0;
                  if(first%2==0)
                  {
                     second=first+1;
                  }
                  else {
                     second=first-1;
                  }
                  if(row[i+1]!=second)
                  {
                      swaps++;
                       //need to swap
                       swap(row,h,i+1,h.get(second));
                  }
            }
            return swaps;
    }
    static void swap(int row[],HashMap<Integer,Integer>h,int i,int j)
    {
        int temp=row[i];
        row[i]=row[j];
        row[j]=temp;
        h.put(row[i],i);
        h.put(row[j],j);
    }
}