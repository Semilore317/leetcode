public class problem_74 {
    public boolean searchMatrix(int[][] nMatrix, int target) {
        if (nMatrix == null || nMatrix.length == 0 || nMatrix[0].length == 0) return false;

        int row = 0;
        int col = nMatrix[0].length - 1;

        while (row < nMatrix.length && col >= 0) {
            if (nMatrix[row][col] == target) {
                return true;
            } else if (nMatrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the method
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        problem_74 solution = new problem_74();
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Target found: " + result);
    }
}