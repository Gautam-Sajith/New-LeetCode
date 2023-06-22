class Solution 
{
    public int rev(int n)
    {
        String s=Integer.toString(n);
        String r="";
        for(int i=0;i<s.length();i++)
        {
            r=s.charAt(i)+r;
        }
        return Integer.parseInt(r);
    }
    public int countDistinctIntegers(int[] nums) 
    {
        int ans=0;
        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums[i]))
            {
                
            }
            else
            {
                map.put(nums[i],1);
                ans++;
            }

            if(map.containsKey(rev(nums[i])))
            {
                
            }
            else
            {
                map.put(rev(nums[i]),1);
                ans++;
            }
        }
        return ans;
    }
}