package lc;

public class P5_Longest_Palindromic_Substring {

    // 必须设空串，不然空指针
    String result = "";

    void core(String s, int c1, int c2) {
        while (c1 >= 0 && c2 < s.length()) {
            if (s.charAt(c1) != s.charAt(c2)) {
                break;
            }
            if (c2 - c1 + 1 > result.length()) {
                result = s.substring(c1 ,c2 + 1);
            }
            c1--;
            c2++;
        }
        return;
    }

    // 用双中心的方式来解决奇偶的问题
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        for (int i = 0 ; i < s.length() ; i++) {
            if (i != 0) {
                core(s, i-1, i);
            }
            core(s, i, i);
        }
        return result;
    }
}