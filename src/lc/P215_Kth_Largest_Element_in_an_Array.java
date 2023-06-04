package lc;

import java.util.Stack;

public class P215_Kth_Largest_Element_in_an_Array {
    // 方法1：排序整个数组，输出list[index]
    // 方法2：priorirt_queue小顶堆输出第k个。时间复杂度nlogn = 初次建堆n + 删除堆顶元素并向下调整klogn
    // 方法3：快排中枢节点的思路（从小到大排序）
    // 时间复杂度，最优：每次都是均分klogn；最差：n^2  平均：klogn
    // 空间复杂度：最优：每次都均分logn; 最差：n 平均logn

    int partition(int[] nums, int begin, int end) {
        int tmp = nums[begin];
        while(begin < end) {
            while(begin < end && nums[end] >= tmp) {
                end--;
            }
            if (begin < end ) {
                nums[begin] = nums[end];
                begin++;
            }
            while(begin < end && nums[begin] <= tmp) {
                begin++;
            }
            if (begin < end) {
                nums[end] = nums[begin];
                end--;
            }
        }
        nums[begin] = tmp;
        return begin;
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        int index = partition(nums, begin, end);
        while (index != nums.length - k) {
            if (index < nums.length - k) {
                begin = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(nums, begin, end);
        }
        return nums[index];
    }

}