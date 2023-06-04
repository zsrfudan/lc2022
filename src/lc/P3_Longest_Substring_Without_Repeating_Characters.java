package lc;

import java.util.HashMap;
import java.util.Map;

public class P3_Longest_Substring_Without_Repeating_Characters {
    /*
    * 方法1：暴力n^2
    * 方法2：记录每个字母最新出现的位置 时间复杂度O(n)，空间复杂度O(n)
    * */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLenth = 0;
        int beginIndex = 0;
        Map<Character, Integer> characterIndexDict = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
            Integer index =  characterIndexDict.get(s.charAt(i));
            if (index != null) {
                // abba的情况
                beginIndex = Math.max(index + 1, beginIndex);
            }
            maxLenth = Math.max(maxLenth, i - beginIndex + 1);
            characterIndexDict.put(s.charAt(i), i);

        }
        return maxLenth;
    }

    public static void main(String[] args) {
        System.out.println(new P3_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("abba"));
    }
}