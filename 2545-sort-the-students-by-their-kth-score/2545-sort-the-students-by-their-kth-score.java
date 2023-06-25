class comp implements Comparator<int[]>
{
    int k;
    public comp(int k)
    {
        this.k=k;
    }
    public int compare(int a[],int b[])
    {
        return b[k]-a[k];
    }
}
class Solution 
{
    public int[][] sortTheStudents(int[][] score, int k) 
    {
        int n=score.length;
        Arrays.sort(score,new comp(k));
        return score;
    }
}