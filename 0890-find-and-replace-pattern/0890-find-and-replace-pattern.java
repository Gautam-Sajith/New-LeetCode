class Solution 
{
    public boolean checker(String s,String p)
    {
        HashMap<Character,Character> map1 = new HashMap<Character,Character>();
        HashMap<Character,Character> map2 = new HashMap<Character,Character>();
        int l=s.length();
        for(int i=0;i<l;i++)
        {
            char c1=s.charAt(i);
            char c2=p.charAt(i);
            if(map1.containsKey(c1) && map1.get(c1)!=c2)
            {
                return false;
            }
            else
            {
                map1.put(c1,c2);
            }

            if(map2.containsKey(c2) && map2.get(c2)!=c1)
            {
                return false;
            }
            else
            {
                map2.put(c2,c1);
            }
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) 
    {
        int n=words.length;
        List<String> ans = new ArrayList<String>();
        for(int i=0;i<n;i++)
        {
            String word=words[i];
            if(checker(word,pattern))
            {
                ans.add(word);
            }
        }
        return ans;
    }
}