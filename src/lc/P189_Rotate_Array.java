package lc;

public class P189_Rotate_Array {

    // 思路，1.先整个数组反转，2.前k个翻转 3.后几个反转
    // * k大于数组长度时取余
    public void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int t = nums[begin];
            nums[begin] = nums[end];
            nums[end] = t;
            begin++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }
}