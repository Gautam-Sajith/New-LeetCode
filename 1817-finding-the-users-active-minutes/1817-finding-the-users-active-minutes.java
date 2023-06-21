class ArrayComparator implements Comparator<int[]>
{
    public int compare(int a[],int b[])
    {
        if(a[0]==b[0])
        {
            return a[1]-b[1];
        }
        else
        {
            return a[0]-b[0];
        }
    }
}
class Solution 
{
    public int[] findingUsersActiveMinutes(int[][] logs, int k) 
    {
        int ans[] = new int[k];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        //find array of uam of users
        // uam is unique times whwere user performed action
        
        Arrays.sort(logs,new ArrayComparator());
        int n=logs.length;       
        map.put(logs[0][0],1);
        for(int i=1;i<n;i++)
        {
            int id=logs[i][0];
            int min=logs[i][1];
            int uam=0;
            if(map.containsKey(id))
            {
                uam=map.get(id);
            }
            if(min == logs[i-1][1] && id==logs[i-1][0])
            {

            }
            else
            {
                uam++;
            }
            map.put(id,uam);     
        }

        for(int id:map.keySet())
        {
            int uam=map.get(id);
            ans[uam-1]++;
        }

        return ans;
    }
}