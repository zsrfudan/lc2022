package lc;

import java.util.Arrays;

public class P976_Largest_Perimeter_Triangle {

    // 三角形最大的周长
    // 思路：贪心，取最大的三条试，如果不行，最大边肯定不是候选项
    public int largestPerimeter(int[] nums) {
        int result = 0;
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1 ; i >= 2 ; i--) {
            if (nums[i] < nums[i-1] + nums[i-2]) {
                result = nums[i] + nums[i-1] + nums[i-2];
                break;
            }
        }
        return result;
    }
}