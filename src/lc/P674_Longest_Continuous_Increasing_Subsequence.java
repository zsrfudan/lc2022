package lc;

public class P674_Longest_Continuous_Increasing_Subsequence {
    // 题意:最长连续递增子序列，贪心。
    // 如果出现倒序了，就重置start重新计算
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int start = 0;
        int result = 1;
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] > nums[i-1]) {
                result = Math.max( i - start + 1, result);
            } else {
                start = i;
            }
        }
        return result;
    }
}