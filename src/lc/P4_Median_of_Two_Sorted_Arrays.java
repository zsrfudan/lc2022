package lc;

public class P4_Median_of_Two_Sorted_Arrays {
    // 方法1.两个有序数组合并，取中位数。 时间复杂度O(m+n)
    // 方法2：O(logmin(m,n))
    // 假设中位线的值归右边
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (nums1.length == 0) {
            // 是-1
            return nums2.length % 2 == 0 ? (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0
                    : nums2[nums2.length / 2];
        }
        int begin = 0, end = nums1.length;
        int cut1, cut2, left1, left2, right1, right2;
        while(true) {
            cut1 = begin + (end - begin) / 2;
            cut2 = (nums1.length + nums2.length) / 2 - cut1;
            left1 = (cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1]);
            right1 = (cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1]);
            left2 = (cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1]);
            right2 = (cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2]);
            if (left1 <= right2 && left2 <= right1) { // 一定要有等于
                break;
            }
            if (left1 > right2) {
                end = cut1 - 1;
            } else {
                begin = cut1 + 1;
            }
        }
        return (nums1.length + nums2.length ) % 2 == 0 ? (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0
                :Math.min(right1, right2);
    }
}