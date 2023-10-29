package lc;

public class P678_Valid_Parenthesis_String {

    // 方法1:直观做法，回溯，即暴力求解
    // 方法2：贪心，记录左括号的最大值和最小值
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        int min = 0, max = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '(') {
                min++;
                max++;
            } else if (s.charAt(i) == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            if (max < 0) {
                return false;
            }
            if (min < 0) {
                min = 0; // 这种情况下说明只有一种情况，重新置0，从下一个直接开始
            }
        }
        return min == 0;
    }
}