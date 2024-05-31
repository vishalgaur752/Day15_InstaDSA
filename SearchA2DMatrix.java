public class SearchA2DMatrix {
    public static boolean searchMatrix(int matrix[][], int target) {
        int rowIdx = searchPotentialRow(matrix, target);
        if (rowIdx != -1) {
            return binarySearchRow(rowIdx, matrix, target);
        } else {
            return false;
        }
    }

    public static int searchPotentialRow(int matrix[][], int target) {
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                return mid;
            } else if (matrix[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static boolean binarySearchRow(int rowIdx, int matrix[][], int target) {
        int low = 0;
        int high = matrix[rowIdx].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[rowIdx][mid] == target) {
                return true;
            } else if (matrix[rowIdx][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 3, 5, 7 }, { 10, 12, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(matrix, 20));
    }
}