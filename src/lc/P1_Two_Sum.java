package lc;

import java.util.HashMap;
import java.util.Map;

public class P1_Two_Sum {

    // 题目条件：有且仅有1个结果

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        Map<Integer, Integer> need = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            Integer index = need.get(nums[i]);
            if (index != null) {
                result[0] = index;
                result[1] = i;
                return result;
            }
            need.put(target - nums[i], i);
        }
        return result;
    }
}