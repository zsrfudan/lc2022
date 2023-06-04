package lc;

public class Quick_Sort {

    int partition(int[] nums, int begin, int end) {
        int tmp = nums[begin];
        while(begin < end) {
            while(begin < end && nums[end] >= tmp) {
                end--;
            }
            if (begin < end) {
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

    void quickSort(int[] nums, int begin, int end) {
        if (nums == null || begin >= end) {
            return;
        }
        int index = partition(nums, begin, end);
        quickSort(nums, begin, index - 1);
        quickSort(nums, index + 1, end);
    }
}