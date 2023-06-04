package lc;

import java.util.ArrayList;
import java.util.List;

public class P39_Combination_Sum {

    // 题目前提：数组数字都是正式且各不同

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrace(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backTrace(int[] candidates, int target, int index, ArrayList<Integer> nowResult) {
        if (target == 0) {
            result.add(new ArrayList<>(nowResult));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index ; i < candidates.length ; i++) {
            nowResult.add(candidates[i]);
            // 这边是i,不是Index,index的话结果会重复
            backTrace(candidates, target - candidates[i], i, nowResult);
            nowResult.remove(nowResult.size() - 1);
        }
    }
}