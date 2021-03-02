package leet.code;


class NumMatrix {

    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1;i<=row2;i++){
            for(int j = col1;j<=col2;j++){
                sum+=matrix[i][j];
            }
        }
        return sum;
    }
}

public class Solution304 {

    public static void main(String[] args) {
        NumMatrix obj = new NumMatrix(null);

    }
}
