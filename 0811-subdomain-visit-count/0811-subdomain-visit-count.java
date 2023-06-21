class Solution 
{
    public void putter(String s,HashMap<String,Integer> map,int p)
    {
        if(s.equals(""))
        {
            return;
        }
        int f=p;
        if(map.containsKey(s))
        {
            f+=map.get(s);
        }
        map.put(s,f);
        int dotp=s.indexOf(".");
        if(dotp==-1)
        {
            return;
        }
        putter(s.substring(dotp+1),map,p);
    }
    public List<String> subdomainVisits(String[] cpdomains) 
    {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        List<String> ans= new ArrayList<String>();
        int n=cpdomains.length;
        for(int i=0;i<n;i++)
        {
            String s=cpdomains[i];
            int wsp=s.indexOf(" ");
            int num=Integer.parseInt(s.substring(0,wsp));
            putter(s.substring(wsp+1),map,num);
            // System.out.println(map);
        }
        for(String s:map.keySet())
        {
            String put=Integer.toString(map.get(s));
            String temp=put+" "+s;
            ans.add(temp);
        }
        return ans;
    }
}