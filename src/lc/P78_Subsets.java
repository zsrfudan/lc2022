package lc;

import java.util.ArrayList;
import java.util.List;

public class P78_Subsets {

    // 题目前提，无重复元素

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> now = new ArrayList<>();
        result.add(now);
        backTrace(nums, 0, now);
        return result;
    }

    private void backTrace(int[] nums, int index, List<Integer> now) {
        if (index >= nums.length) {
            return;
        }
        for (int i = index ; i < nums.length ; i++) {
            List<Integer> newNow = new ArrayList<>(now);
            newNow.add(nums[i]);
            result.add(newNow);
            backTrace(nums, i + 1, newNow);
        }
    }
}