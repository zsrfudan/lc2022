package lc;

import java.util.ArrayList;
import java.util.List;

public class P54_Spiral_Matrix {
    // 大循环 totalNum 作为条件，内部4块表示4个方向。 定义rowBegin,rowEnd,colBegin,colEnd
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        int totalNum = matrix.length * matrix[0].length;
        while(totalNum > 0) {
            for(int i = colBegin ; i <= colEnd ; i++) {
                result.add(matrix[rowBegin][i]);
                totalNum--;
            }
            rowBegin++;
            for(int i = rowBegin; i <= rowEnd && totalNum > 0; i++) { // totalnum > 0 条件别忘
                result.add(matrix[i][colEnd]);
                totalNum--;
            }
            colEnd--;
            for(int i = colEnd; i >= colBegin && totalNum > 0;i--) {
                result.add(matrix[rowEnd][i]);
                totalNum--;
            }
            rowEnd--;
            for(int i = rowEnd ; i >= rowBegin && totalNum > 0; i--) {
                result.add(matrix[i][colBegin]);
                totalNum--;
            }
            colBegin++;
        }
        return result;
    }
}