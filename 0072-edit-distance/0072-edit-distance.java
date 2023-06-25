class Solution
{
    public int minDistance(String word1, String word2) 
    {
        int l1=word1.length();
        int l2=word2.length();
        int dp[][]= new int[l1+1][l2+1];
        
        // return f(word1.length()-1,word2.length()-1,word1,word2);

        //TABULATION
        for(int i=0;i<=l1;i++)
        {
            dp[i][0]=i;
        }
        for(int j=0;j<=l2;j++)
        {
            dp[0][j]=j;
        }
        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l2;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    int del=1+dp[i-1][j];
                    int ins=1+dp[i][j-1];
                    int rep=1+dp[i-1][j-1];
                    int ans=Math.min(del,ins);
                    ans=Math.min(ans,rep);
                    dp[i][j]=ans;
                }
            }
        }
        return dp[l1][l2];
    }
    
    //RECURSION
    int f(int i,int j,String s,String t)
    {
        if(i==-1)
        {
            return j+1;
        }
        if(j==-1)
        {
            return i+1;
        }
        if(s.charAt(i)==t.charAt(j))
        {
            return f(i-1,j-1,s,t);
        }
        else
        {
            int del=1+f(i-1,j,s,t);
            int ins=1+f(i,j-1,s,t);
            int rep=1+f(i-1,j-1,s,t);
            int ans=Math.min(del,ins);
            ans=Math.min(ans,rep);
            return ans;
        }
    }
}