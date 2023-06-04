package lc;

public class P62_Unique_Paths {

    // 方法1：dfs 方法2：空间换时间，dfs开数组记住 方法3：dp[x][y] = dp[x-1][y] + dp[x][y-1] -> 方法4：对m*n的空间复杂度做优化
    public int uniquePaths(int m, int n) {
        if (m > n) {
            return uniquePaths(n, m);
        }
        int[] dp = new int[m];
        for (int i = 0 ; i < m ; i++) {
            dp[i] = 1;
        }
        for (int i = 1 ; i < n ; i++) {
            for (int j = 1 ; j < m ; j++) {
                if (j == 1) {
                    dp[j] += 1;
                } else {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[m-1];
    }

}