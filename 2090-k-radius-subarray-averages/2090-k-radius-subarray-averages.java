class Solution 
{
    public int[] getAverages(int[] nums, int k) 
    {
        int n=nums.length;
        int ans[]= new int[n];
        Arrays.fill(ans,-1);
        int i=0,j=0;
        long sum=0;
        int ind=k;
        
        while(i<=j &&j<n)
        {
            sum+=nums[j];
            if(j-i+1<2*k+1)
            {
                j++;
            }
            else if(j-i+1==2*k+1)
            {
                ans[ind]=(int)(sum/(2*k+1));
                j++;
                sum-=nums[i];
                i++;
                ind++;
            }
        }
        return ans;
    }
}