//{ Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}
// } Driver Code Ends


/*You are required to complete this method */
class Node
{
    Node links[]= new Node[26];
    
    boolean contains(char ch)
    {
        return links[ch-'a']!=null;
    }
    
    Node get(char ch)
    {
        return links[ch-'a'];
    }
    
    void put(char ch,Node node)
    {
        links[ch-'a']=node;
    }
}
class GfG
{
   public static int countDistinctSubstring(String s)
   {
       //your code here
      
        Node root= new Node();
        int ans=1;
        for(int i=0;i<s.length();i++)
        {
            Node node=root;
            for(int j=i;j<s.length();j++)
            {
                if(node.contains(s.charAt(j))==false)
                {
                    ans++;
                    node.put(s.charAt(j),new Node());
                }
                node =node.get(s.charAt(j));
            }
        }
        return ans;
   }
}