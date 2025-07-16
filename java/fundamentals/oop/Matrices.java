package fundamentals.oop;

public class Matrices {
    public int[][] a = {{3,4},
                        {1,2}};
    public int[][] b = {{1,2},
                        {3,4}};

    public boolean compareMatrices(int[][] n, int[][] m) {
        // compare dimensions of matrices
        int maxColumnsA = 0;
        for (int[] row : a) {
            if (row.length > maxColumnsA) {
                maxColumnsA = row.length;
            }
        }

        int maxColumnsB = 0;
        for (int[] row : b) {
            if (row.length > maxColumnsB) {
                maxColumnsB = row.length;
            }
        }
        if (maxColumnsA != maxColumnsB) {
            return false;
        }
        return true;
    }

    public void matrixSum(int[][] a, int[][] b) {
        int[][] sum = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* row times column
        (a[0][0] * b[0][0] + a[0][1] * b[1][0]) & (a[0][0] * b[0][1] + a[0][1] * b[1][1])
        (a[1][0] * b[0][0] + a[1][1] * b[1][0]) & (a[1][0] * b[0][1] + a[1][1] * b[1][1])
    */

    public void matrixQuotient(int[][] a, int[][] b) {
        int[][] quotient = new int[2][2];
        int rows = 2;
        int cols = 2;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                quotient[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(quotient[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrices matrices = new Matrices();
        System.out.println("The validity of both matrices' equality is: " + matrices.compareMatrices(matrices.a, matrices.b));

        System.out.println("The sum of a and b is:");
        matrices.matrixSum(matrices.a, matrices.b);

        System.out.println("The quotient of a and b is:");
        matrices.matrixQuotient(matrices.a, matrices.b);
    }
}
