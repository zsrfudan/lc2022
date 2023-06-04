package lc;

public class P42_Trapping_Rain_Water {

    // 方法1：对于每一个index，找出左右最大高度，取左右最大高度与当前index比能积起来的。 n^2
//    int findMax(int[] height, int left, int right) {
//        int result = height[left];
//        for(int i = left ; i <= right ; i++) {
//            result = Math.max(result, height[i]);
//        }
//        return result;
//    }
//    public int trap1(int[] height) {
//        int result = 0;
//        for(int i = 0 ; i < height.length ; i++) {
//            int maxLeft = findMax(height, 0, i-1);
//            int maxRight = findMax(height, i, height.length - 1);
//            if(maxLeft > height[i] && maxRight > height[i]) { // 左右都比当前木板高时才能蓄水
//                result += (Math.min(maxLeft, maxRight) - height[i]);
//            }
//        }
//        return result;
//    }

    // 方法2. 先找到最高峰，再左右两边遍历（变算变找最高峰）
    public int trap(int[] height) {
        int result = 0;
        if (height == null || height.length < 3) {
            return result;
        }
        // step1.找到山峰
        int maxIndex = 0;
        for (int i = 1 ; i < height.length ; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }
        // step2.左遍历
        int leftMaxHeight = height[0];
        for (int i = 1 ; i < maxIndex ; i++) {
            if (height[i] < leftMaxHeight) {
                result += (leftMaxHeight - height[i]);
            } else {
                leftMaxHeight = height[i];
            }
        }
        // step3.右遍历
        int rightMaxHeight = height[height.length - 1];
        for (int i = height.length - 2 ; i > maxIndex ; i--) {
            if (height[i] < rightMaxHeight) {
                result += (rightMaxHeight - height[i]);
            } else {
                rightMaxHeight = height[i];
            }
        }
        return result;
    }
}