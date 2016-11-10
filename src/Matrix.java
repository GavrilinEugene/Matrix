/*
 * класс, описывающий матрицу размера rows*columns
 */
public class Matrix {

    private int[][] matrix;

    public Matrix(int rowCount, int columnCount) {
        matrix = new int[rowCount][columnCount];
    }

    public Matrix() {
        this(0, 0);
    }

    public int getRowCount() {
        if (!checkMatrix()) {
            throw new NullPointerException();
        }
        return matrix.length;
    }

    public int getColumnCount() {
        if (!checkMatrix()) {
            throw new NullPointerException();
        }
        return matrix[0].length;
    }

    private boolean checkMatrix() {
        return this != null && matrix != null;
    }

    public int getElement(int row, int column) {
        if (!checkMatrix() || !checkColumnRange(column) || !checkRowRange(row)) {
            throw new IllegalArgumentException();
        }
        return matrix[row][column];
    }

    public void setElement(int row, int column, int element) {
        if (!checkMatrix() || !checkColumnRange(column) || !checkRowRange(row))
            throw new IllegalArgumentException();
        matrix[row][column] = element;
    }

    private boolean checkColumnRange(int row) {
        return row < getRowCount() || row >= 0;
    }

    private boolean checkRowRange(int column) {
        return column < getColumnCount() || column >= 0;
    }

    public Matrix add(Matrix other) {
        if (!checkMatrix() || !other.checkMatrix()) {
            throw new IllegalArgumentException();
        }
        if (other.getRowCount() != this.getRowCount() || other.getColumnCount() != this.getColumnCount()) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }

        Matrix ret = new Matrix(getRowCount(), getColumnCount());
        for (int row = 0; row < getColumnCount(); row++) {
            for (int column = 0; column < getRowCount(); column++) {
                ret.setElement(row, column, this.getElement(row, column) + other.getElement(row, column));
            }
        }
        return ret;
    }

    public Matrix multiplyMatrix(Matrix right) {
        Matrix left = this;
        if (!left.checkMatrix() || !right.checkMatrix()) {
            throw new IllegalArgumentException();
        }
        if (left.getColumnCount() != right.getColumnCount()) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }

        Matrix ret = new Matrix(left.getRowCount(), right.getColumnCount());
        for (int row = 0; row < left.getRowCount(); row++) {
            for (int column = 0; column < right.getColumnCount(); column++) {
                ret.setElement(row, column, left.getRow(row).multiply(right.getColumn(column)));
            }
        }
        return ret;
    }

    private Vector getColumn(int column) {
        Vector ret = new Vector(getRowCount());
        for (int row = 0; row < getRowCount(); row++) {
            ret.setElement(row, getElement(row, column));
        }
        return ret;
    }

    private Vector getRow(int rowNumber) {
        Vector ret = new Vector(getColumnCount());
        for (int column = 0; column < getColumnCount(); column++) {
            ret.setElement(column, getElement(rowNumber, column));
        }
        return ret;
    }

    public int calculateDeterminant() {
        if (!checkMatrix() || !isSquareMatrix()) {
            throw new RuntimeException();
        }
        MinorDeterminantMethod algorithm = new MinorDeterminantMethod();
        return algorithm.calculate(this);
    }

    private boolean isSquareMatrix() {
        return getColumnCount() == getRowCount();
    }
}
