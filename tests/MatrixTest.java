import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void multiplyMatrix() throws Exception {
        Matrix first = new Matrix(new int[][]{{1,2},{1,2}});
        Matrix second = new Matrix(new int[][]{{1,3},{1,4}});
        Matrix expected = new Matrix(new int[][]{{3,11},{3,11}});
        assertTrue(expected.equals(first.multiplyMatrix(second)));
    }

    @org.junit.Test
    public void add() throws Exception {
        Matrix first = new Matrix(new int[][]{{1,2},{1,2}});
        Matrix second = new Matrix(new int[][]{{1,3},{1,4}});
        Matrix expected = new Matrix(new int[][]{{2,5},{2,6}});
        assertTrue(expected.equals(first.add((second))));
    }

}