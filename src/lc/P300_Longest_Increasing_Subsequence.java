package lc;

public class P300_Longest_Increasing_Subsequence {
    // 定义dp[i]以i结尾的最长递增子序列长度
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int result = 1; // 一定要定义在这里并初始化1，否则 7 7 7 7这种case结果会为0
        int[] dp = new int[nums.length];
        for (int i = 0 ; i < dp.length ; i++) {
            dp[i] = 1;
        }
        for (int i = 1 ; i < dp.length ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}