package lc;

public class P69_Sqrt {
    // 取整，如sqrt(8) 2.8284，答案：2
    // 思路：二分法
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0, right = x;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (mid == left) {
                break;
            }
            int value = x / mid;
            if (value < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}