public class comp implements Comparator<int[]>
{
    public int compare(int a[] ,int b[])
    {
        int am=Math.min(a[0],a[1]);
        int bm=Math.min(b[0],b[1]);
        return am-bm;
    }
}
class Solution 
{
public int twoCitySchedCost(int[][] costs) 
{
    int n = costs.length / 2;
    int[][][] dp = new int[2 * n + 1][n + 1][n + 1];

    for (int i = 2 * n-1; i >= 0; i--) 
    {
        for (int a = n; a >= 0; a--) 
        {
            for (int b = n; b >= 0; b--) 
            {
                int opt1 = Integer.MAX_VALUE, opt2 = Integer.MAX_VALUE;
                if (a < n) 
                {
                    opt1 = dp[i + 1][a + 1][b] + costs[i][0];
                }
                if (b < n) 
                {
                    opt2 = dp[i + 1][a][b + 1] + costs[i][1];
                }
                dp[i][a][b] = Math.min(opt1, opt2);   
            }
        }
    }

    return dp[0][0][0];
}

    public int f(int ar[][], int i,int a,int b,int n)
    {
        // System.out.println(i);
        if(i==2*n)
        {
            // System.out.println(a+" "+b);
            return 0;
        }
        int opt1=Integer.MAX_VALUE,opt2=Integer.MAX_VALUE;
        if(a<n)
        {
            opt1=f(ar,i+1,a+1,b,n)+ar[i][0];
        }
        if(b<n)
        {
            opt2=f(ar,i+1,a,b+1,n)+ar[i][1];
        }
        return Math.min(opt1,opt2);
    }
}