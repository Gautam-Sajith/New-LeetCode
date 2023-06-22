class Solution 
{
    public int maxProfit(int[] prices, int fee) 
    {
        // return f(0,prices,fee,0);
        int n=prices.length;
        int dp[][]= new int[n+1][2];
        for(int i=n-1;i>=0;i--)
        {
            dp[i][0]=Math.max(-prices[i]+dp[i+1][1],dp[i+1][0]);
            dp[i][1]=Math.max(prices[i]-fee+dp[i+1][0],dp[i+1][1]);
        }
        return dp[0][0];
    }
    // public int f(int i,int prices[],int fee,int b)
    // {
    //     if(i>=prices.length)
    //     {
    //         return 0;
    //     }
    //     if(b==0)//can buy
    //     {
    //         return Math.max(-prices[i]+f(i+1,prices,fee,1),f(i+1,prices,fee,0));
    //     }
    //     else//can sell
    //     {
    //         return Math.max(prices[i]-fee+f(i+1,prices,fee,0),f(i+1,prices,fee,1));
    //     }
    // }
}