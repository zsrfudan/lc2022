package lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P46_Permutations {
    // case1.没有重复元素的
    // case2.有重复元素，set去重

    List<List<Integer>> result = new ArrayList<>();

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
//
//    void backTrace(int[] nums, int index) {
//        // 回溯（递归），定返回条件
//        if (index == nums.length) {
//            List<Integer> subResult = new ArrayList<>();
//            for (int i : nums) {
//                subResult.add(i);
//            }
//            result.add(subResult);
//            return;
//        }
//        for (int i = index ; i < nums.length ; i++) {
//            swap(nums, i, index);
//            backTrace(nums, index + 1);
//            swap(nums, i, index);
//        }
//    }
//
//    public List<List<Integer>> permute(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return result;
//        }
//        backTrace(nums, 0);
//        return result;
//    }

    void backTraceUnique(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> subResult = new ArrayList<>();
            for (int i : nums) {
                subResult.add(i);
            }
            result.add(subResult);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index ; i < nums.length ; i++) {
            if (!set.add(nums[i])) {
                continue;
            }
            swap(nums, i, index);
            backTraceUnique(nums, index+1);
            swap(nums, i, index);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length < 1) {
            return result;
        }
        backTraceUnique(nums, 0);
        return result;
    }
}