import java.util.Arrays;

public class FindPeakElemantII {
    public static int[] findGrid(int matrix[][]) {
        int i = 0, j = 0;
        while (i < matrix.length && j < matrix[0].length) {
            if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
                i--;
            } else if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
                j--;
            } else if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
                i++;
            } else if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
                j++;
            } else {
                int ans[] = { i, j };
                return ans;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 15 }, { 21, 30, 14 } };
        System.out.println(Arrays.toString(findGrid(matrix)));
    }
}
