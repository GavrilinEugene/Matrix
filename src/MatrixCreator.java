public class MatrixCreator {

    public static Matrix createFromArray(int[][] matrix) {
        if (!checkMatrix(matrix))
            return null;

        Matrix ret = new Matrix(getRowCount(matrix), getColumnCount(matrix));
        for (int row = 0; row < getRowCount(matrix); row++) {
            for (int column = 0; column < getColumnCount(matrix); column++) {
                ret.setElement(row, column, matrix[row][column]);
            }
        }
        return ret;
    }

    private static int getRowCount(int[][] matrix) {
        return matrix.length;
    }

    private static int getColumnCount(int[][] matrix) {
        return matrix[0].length;
    }

    private static int getColumnCount(int[][] matrix, int row) {
        return matrix[row].length;
    }

    private static boolean checkMatrix(int[][] matrix) {
        if (matrix == null)
            return false;

        for (int row = 0; row < getRowCount(matrix) - 1; row++) {
            if (getColumnCount(matrix, row) != getColumnCount(matrix, row + 1))
                return false;
        }
        return true;
    }
}
