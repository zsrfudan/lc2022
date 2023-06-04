package lc;

public class P70_Climbing_Stairs {
    // 有几种方式
    // f(x) = f(x-1) + f(x-2)
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1, b = 2;
        for (int i = 3 ; i <= n ; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }
}