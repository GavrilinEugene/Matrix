/*
 * класс, описывающий матрицу размера rows*columns
 */
final public class Matrix {

    private final int[][] matrix;
    private final int rows;
    private final int columns;

    public Matrix(int rowCount, int columnCount) {
        rows = rowCount;
        columns = columnCount;
        matrix = new int[rowCount][columnCount];

    }

    public Matrix(int[][] matrix) {
        // todo check

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

    private boolean checkInputMatrix(int[][] matrix){
        return false;
    }

    public int getElement(int row, int column){
        return matrix[row][column];
    }

    public void setElement(int row, int column, int element){
        matrix[row][column] = element;
    }

    public Matrix add(Matrix other) {
        if (other.rows != this.rows || other.columns != this.columns)
            throw new RuntimeException("Illegal matrix dimensions.");

        Matrix ret = new Matrix(rows,columns);
        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++)
                ret.setElement(row,column, this.getElement(row,column) + other.getElement(row,column));
        return ret;
    }

    public boolean equals(Matrix other){
        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++)
                if(this.matrix[row][column] != matrix[row][column])
                    return false;
        return true;
    }


}
