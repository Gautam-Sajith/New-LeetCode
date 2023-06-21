class Solution 
{
    public int[] findThePrefixCommonArray(int[] A, int[] B)
    {
        HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        int n=A.length;
        int a[] = new int[n];

        for(int i=0;i<n;i++)
        {

            int f1=1;
            if(map1.containsKey(A[i]))
            {
                f1+=map1.get(A[i]);
            }
            map1.put(A[i],f1);

            int f2=1;
            if(map2.containsKey(B[i]))
            {
                f2+=map2.get(B[i]);
            }
            map2.put(B[i],f2);
            // System.out.println(map1);
            // System.out.println(map2);
            int ans=0;
            if(A[i]==B[i])
            {
                if(map1.containsKey(A[i]) && map2.containsKey(A[i]))
                {
                    ans+=Math.min(map1.get(A[i]),map2.get(A[i]));
                }
            }
            else
            {
                if(map1.containsKey(A[i]) && map2.containsKey(A[i]))
                {
                    ans+=Math.min(map1.get(A[i]),map2.get(A[i]));
                }
                if(map1.containsKey(B[i]) && map2.containsKey(B[i]))
                {
                    ans+=Math.min(map1.get(B[i]),map2.get(B[i]));
                }
            }
            if(i>0)
            a[i]=a[i-1]+ans;
            else
            a[i]=ans;

        }
        return a;
    }
}