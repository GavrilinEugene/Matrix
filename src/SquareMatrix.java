/*
 * класс, реализующий квадратную матрицу
 */
public class SquareMatrix extends Matrix {

    public SquareMatrix(int[][] matrix) {
        if (!checkSquareMatrix(matrix))
            matrix = new int[0][0];

        rows = getRowCount(matrix);
        columns = getColumnCount(matrix);
        this.matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++)
                this.matrix[row][column] = matrix[row][column];
    }

    private static int getRowCount(int[][] matrix) {
        return matrix.length;
    }

    private static int getColumnCount(int[][] matrix) {
        return matrix[0].length;
    }

    private static boolean checkSquareMatrix(int[][] matrix) {
        if (matrix == null)
            matrix = new int[0][0];
        return getRowCount(matrix) == getColumnCount(matrix);
    }

    public SquareMatrix(int rowCount) {
        rows = rowCount;
        columns = rowCount;
        matrix = new int[rowCount][rowCount];
    }

    public int calculateDeterminant() {
        return calculateDeterminant(this, rows);
    }

    private SquareMatrix generateSubMatrix(int rows, int splitterColumn){
        SquareMatrix subMatrix = new SquareMatrix(rows - 1);

        for (int rowNumber = 1; rowNumber < rows; rowNumber++) {
            int newColumnNumber = 0;
            for (int columnNumber = 0; columnNumber < rows; columnNumber++) {
                if(columnNumber == splitterColumn)
                    continue;
                subMatrix.setElement(rowNumber - 1, newColumnNumber, getElement(rowNumber, columnNumber));
                newColumnNumber++;
            }
        }
        return subMatrix;
    }

    public int calculateDeterminant(SquareMatrix subMatrix, int subMatrixRowCount) {
        int res;
        if (subMatrixRowCount == 1)
            res = subMatrix.getElement(0,0);
        else if (subMatrixRowCount == 2)
            res = subMatrix.getElement(0,0) * subMatrix.getElement(1,1) -
                    subMatrix.getElement(1,0) * subMatrix.getElement(0,1);
        else {
            res = 0;
            for (int columnNumber = 0; columnNumber < subMatrixRowCount; columnNumber++) {
                SquareMatrix newSubMatrix = generateSubMatrix(subMatrixRowCount, columnNumber);
                res += Math.pow(-1.0, 2.0 + columnNumber) * getElement(0, columnNumber) * calculateDeterminant(newSubMatrix, subMatrixRowCount - 1);
            }
        }
        return res;
    }
}
