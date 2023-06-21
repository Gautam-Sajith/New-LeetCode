class Solution 
{
    public List<List<Integer>> groupThePeople(int[] groupSizes) 
    {
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        int n= groupSizes.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(groupSizes[i]))
            {
                int size=map.get(groupSizes[i]).size();
                
                ArrayList<Integer> temp=new ArrayList<Integer>();
                if(size==groupSizes[i])
                {
                    // System.out.println("yo");
                    a.add(new ArrayList<Integer>(map.get(groupSizes[i])));
                    temp.add(i);
                    map.put(groupSizes[i],temp);
                }
                else
                {
                    temp.addAll(map.get(groupSizes[i]));
                    temp.add(i);
                    map.put(groupSizes[i],temp);
                }
            }
            else
            {
                ArrayList<Integer> temp= new ArrayList<Integer>();
                temp.add(i);
                map.put(groupSizes[i],temp);
            }
        }
        for(int k: map.keySet())
        {
            if(map.get(k).size()>0)
            {
                a.add(new ArrayList<Integer>(map.get(k)));
            }
        }
        return a;

    }
}