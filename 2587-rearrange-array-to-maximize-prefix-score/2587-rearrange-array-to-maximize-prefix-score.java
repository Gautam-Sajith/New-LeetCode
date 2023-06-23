import java.util.Arrays;

class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long prefix = 0;
        int cnt = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefix += nums[i];
            if (prefix > 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
