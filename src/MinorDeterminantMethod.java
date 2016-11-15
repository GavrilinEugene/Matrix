/*
 * поиск детермината по методу миноров
 */
public class MinorDeterminantMethod implements DeterminantCalc {
    private Matrix origin;

    @Override
    public int calculate(Matrix matrix) {
        origin = matrix;
        return calculateDeterminant(matrix, matrix.getRowCount());
    }

    private int calculateDeterminant(Matrix minor, int subMatrixRowCount) {
        int ret;
        if (subMatrixRowCount == 1) {
            ret = minor.getElement(0, 0);
        } else if (subMatrixRowCount == 2) {
            ret = minor.getElement(0, 0) * minor.getElement(1, 1) -
                    minor.getElement(1, 0) * minor.getElement(0, 1);
        } else {
            ret = 0;
            for (int columnNumber = 0; columnNumber < subMatrixRowCount; columnNumber++) {
                Matrix newMinor = generateMinor(subMatrixRowCount, columnNumber);
                ret += Math.pow(-1.0, 2.0 + columnNumber) * origin.getElement(0, columnNumber) * calculateDeterminant(newMinor, subMatrixRowCount - 1);
            }
        }
        return ret;
    }

    private Matrix generateMinor(int rows, int splitterColumn) {
        Matrix minor = new Matrix(rows - 1, rows - 1);

        for (int rowNumber = 1; rowNumber < rows; rowNumber++) {
            int newColumnNumber = 0;
            for (int columnNumber = 0; columnNumber < rows; columnNumber++) {
                if (columnNumber == splitterColumn)
                    continue;
                minor.setElement(rowNumber - 1, newColumnNumber, origin.getElement(rowNumber, columnNumber));
                newColumnNumber++;
            }
        }
        return minor;
    }
}
