class Solution 
{
    public int[] pf(int nums[],int len)
    {
        int n=nums.length;
        int pre[] = new int[n+1];
        int i=0;
        int j=0;
        int p=0;
        while(i<=j && j<n)
        {
            p+=nums[j];
            if(j-i+1 == len)
            {
                pre[j+1]=Math.max(p,pre[j]);
                p-=nums[i];
                i++;
            }
            j++;
        }
        return pre;
    }
    public int[] sf(int nums[], int len) 
    {
        int n = nums.length;
        int suf[] = new int[n + 1];
        int i = n - 1;
        int j = n - 1;
        int s = 0;
        while (j >= 0) 
        {
            s += nums[j];
            if (i - j +1 == len) 
            {
                suf[j] = Math.max(s, suf[j + 1]);
                s -= nums[i];
                i--;
            }
            j--;
        }
        return suf;
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) 
    {

        int n=nums.length;
        int pref[]=pf(nums,firstLen);//prefix array of len firstLen
        int suff[]=sf(nums,firstLen);//suffix array of len firstLen
        int pres[]=pf(nums,secondLen);//prefix array of len secondtLen
        int sufs[]=sf(nums,secondLen);//suffix array of len secondLen
        int max=0;

        for(int i=0;i<=n;i++)
        {
            max=Math.max(pref[i]+sufs[i],max);
        }

        for(int i=0;i<=n;i++)
        {
            max=Math.max(pres[i]+suff[i],max);
        }
        return max;

        
    }

}