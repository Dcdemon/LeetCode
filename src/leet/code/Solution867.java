package leet.code;

public class Solution867 {


    public int[][] transpose(int[][] matrix) {
        int[][] rev = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                rev[j][i] = matrix[i][j];
            }
        }
        return rev;
    }
}
