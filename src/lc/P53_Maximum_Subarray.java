package lc;

public class P53_Maximum_Subarray {
    // dp[i]为以nums[i]结尾的最大和子串 dp[i] = max(nums[i], dp[i-1] + nums[i])
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int dp = nums[0];
        int result = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            result = Math.max(result, dp);
        }
        return result;
    }
}