package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15_3Sum {
    // 题目条件三元组不得重复，所以找出一组以后相同元素的可以去重。 思路：排序 + two pointers
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
         if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length - 2 ; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int p1 = i + 1;
            int p2 = nums.length - 1;
            while (p1 < p2) {
                if (nums[i] + nums[p1] + nums[p2] == 0) {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(nums[i]);
                    subResult.add(nums[p1]);
                    subResult.add(nums[p2]);
                    result.add(subResult);
                    p1++;
                    p2--;
                    while(p1 < p2 && nums[p1] == nums[p1-1]) {
                        p1++;
                    }
                    while(p1 < p2 && nums[p2] == nums[p2+1]) {
                        p2--;
                    }
                } else if (nums[i] + nums[p1] + nums[p2] < 0){
                    p1++;
                    while(p1 < p2 && nums[p1] == nums[p1-1]) {
                        p1++;
                    }
                } else {
                    p2--;
                    while(p1 < p2 && nums[p2] == nums[p2 + 1]) {
                        p2--;
                    }
                }
            }
        }
        return result;
    }
}