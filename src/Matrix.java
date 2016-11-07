/*
 * класс, описывающий матрицу размера rows*columns
 */
public class Matrix {

    protected int[][] matrix;
    protected int rows;
    protected int columns;

    public Matrix(int rowCount, int columnCount) {
        rows = rowCount;
        columns = columnCount;
        matrix = new int[rowCount][columnCount];
    }

    public Matrix(){
        this(0,0);
    }

    public Matrix(int[][] matrix) {
        if (matrix == null)
            matrix = new int[0][0];

        rows = matrix.length;
        columns = matrix[0].length;
        this.matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++)
                this.matrix[row][column] = matrix[row][column];
    }


    private Matrix(Matrix other) {
        this(other.matrix);
    }

    private boolean checkMatrix() {
        if (matrix == null)
            return false;
        else
            return true;
    }

    public int getElement(int row, int column) {
        return matrix[row][column];
    }

    public void setElement(int row, int column, int element) {
        matrix[row][column] = element;
    }

    public Matrix add(Matrix other) {
        if (other.rows != this.rows || other.columns != this.columns)
            throw new RuntimeException("Illegal matrix dimensions.");

        Matrix ret = new Matrix(rows, columns);
        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++)
                ret.setElement(row, column, this.getElement(row, column) + other.getElement(row, column));
        return ret;
    }

    public Matrix multiplyMatrix(Matrix right) {
        Matrix left = this;
        if (!left.checkMatrix() || !right.checkMatrix()) {
            throw new IllegalArgumentException();
        }
        if (left.columns != right.rows) {
            throw new IllegalArgumentException();
        }

        Matrix ret = new Matrix(left.rows, right.columns);
        for (int row = 0; row < left.rows; row++) {
            for (int column = 0; column < right.columns; column++) {
                ret.setElement(row, column, multiplyVector(left.getRow(row), right.getColumn(column)));
            }
        }
        return ret;
    }

    private static int multiplyVector(int[] row, int[] column) {
        int ret = 0;
        for(int index = 0; index < row.length; index++)
            ret += row[index]*column[index];
        return ret;
    }

    private int[] getColumn(int column) {
        int[] ret = new int[rows];
        for (int row = 0; row < rows; row++) {
            ret[row] = matrix[row][column];
        }
        return ret;
    }

    private int[] getRow(int rowNumber) {
        return matrix[rowNumber];
    }

    public boolean equals(Matrix other) {
        if (columns != other.columns || rows != other.rows) {
            return false;
        }
        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++)
                if (other.matrix[row][column] != matrix[row][column])
                    return false;
        return true;
    }

}
