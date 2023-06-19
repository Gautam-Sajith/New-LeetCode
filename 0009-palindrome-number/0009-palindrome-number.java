class Solution {
    public boolean isPalindrome(int x) 
    {
        
        String t=Integer.toString(x),r="";
        for(int i=0;i<t.length();i++)
        {
            r=t.charAt(i)+r;
        }
        // System.out.println(r);
        return r.equals(t);
    }
}