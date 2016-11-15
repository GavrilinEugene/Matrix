import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void multiplyMatrix() throws Exception {
        Matrix first = MatrixCreator.createFromArray(new int[][]{{1, 2}, {1, 2}});
        Matrix second = MatrixCreator.createFromArray(new int[][]{{1, 3}, {1, 4}});
        Matrix expected = MatrixCreator.createFromArray(new int[][]{{3, 11}, {3, 11}});
        assertNotNull(first);
        assertNotNull(second);
        assertNotNull(expected);
        assertTrue(equals(expected, first.multiplyMatrix(second)));
    }

    @org.junit.Test
    public void add() throws Exception {
        Matrix first = MatrixCreator.createFromArray(new int[][]{{1, 2}, {1, 2}});
        Matrix second = MatrixCreator.createFromArray(new int[][]{{1, 3}, {1, 4}});
        Matrix expected = MatrixCreator.createFromArray(new int[][]{{2, 5}, {2, 6}});
        assertNotNull(first);
        assertNotNull(second);
        assertNotNull(expected);
        assertTrue(equals(expected, first.add(second)));
    }


    private boolean equals(Matrix first, Matrix second) {
        if (first.getColumnCount() != second.getColumnCount() || first.getRowCount() != second.getRowCount()) {
            return false;
        }
        for (int row = 0; row < first.getRowCount(); row++) {
            for (int column = 0; column < first.getColumnCount(); column++) {
                if (first.getElement(row, column) != second.getElement(row, column))
                    return false;
            }
        }
        return true;
    }
}