package lc;

public class P88_Merge_Sorted_Array {

    // num1空间开够了，从后往前放
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int now = m + n - 1;
        while(p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[now--] = nums1[p1--];
            } else {
                nums1[now--] = nums2[p2--];
            }
        }
        while(p1 >= 0) {
            nums1[now--] = nums1[p1--];
        }
        while (p2 >= 0) {
            nums1[now--] = nums2[p2--];
        }
    }
}