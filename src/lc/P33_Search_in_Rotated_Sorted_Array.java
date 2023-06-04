package lc;

public class P33_Search_in_Rotated_Sorted_Array {
    // 例子： 4 5 6 7 1 2 3
    // 画图看一下，1.先看Mid在哪一段 2.再看Mid和taeget的关系
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) { // 等号一定要加
                if (nums[left] <= target && target <= nums[mid]) { // 等号一定要加
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) { // 等号一定要加
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
}