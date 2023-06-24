class comp implements Comparator<int[]>
{
    public int compare(int a[],int b[])
    {
        return b[0]*b[1]*b[2]-a[0]*a[1]*a[2];
    }
}
class Solution 
{
    public boolean check(int a[],int b[])
    {
        return a[0]>=b[0] && a[1]>=b[1] && a[2]>=b[2];
    }

    public int maxHeight(int[][] cuboids) 
    {
        int n=cuboids.length;
        for(int i=0;i<n;i++)
        {
            Arrays.sort(cuboids[i]);
        }
        
        Arrays.sort(cuboids,new comp());

        // return f(0,cuboids,-1);
        //TABULATED SOLUTION
        
        int ans=0;
        int dp[][] = new int[n+2][n+2];
        for (int i = n; i >= 0; i--) 
        {
            for (int prev = i - 1; prev >= 0; prev--) 
            {
                int h1 = 0;
                if (prev == 0 || check(cuboids[prev-1], cuboids[i-1])) 
                {
                    h1 = cuboids[i-1][2] + dp[i + 1][i];
                }
                int h2 = dp[i + 1][prev];
                dp[i][prev] = Math.max(h1, h2);
                ans=Math.max(dp[i][prev],ans);
            }
    
        }
        return ans;
    }

    //below is the recursive solution

    // public int f(int i,int cuboids[][],int prev)
    // {
    //     if(i==cuboids.length)
    //     {
    //         return 0;
    //     }

    //     int h1=0;
    //     if(prev==-1 || check(cuboids[prev],cuboids[i]))
    //     {
    //         h1=cuboids[i][2]+f(i+1,cuboids,i);
    //     }
    //     int h2=f(i+1,cuboids,prev);
    //     return Math.max(h1,h2);
    // }
}