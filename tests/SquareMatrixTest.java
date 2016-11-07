import org.junit.Test;

import static org.junit.Assert.*;

public class SquareMatrixTest {
    @Test
    public void determinant() throws Exception {
        SquareMatrix first = new SquareMatrix(new int[][]{{1,2,3},{1,2,4},{5,7,2}});

        assertEquals(3,first.calculateDeterminant());
    }

}