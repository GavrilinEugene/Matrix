import org.junit.Test;

import static org.junit.Assert.*;

public class MinorDeterminantMethodTest {
    @Test
    public void calculate() throws Exception {
        Matrix first = MatrixCreator.createFromArray(new int[][]{{1,2,3},{1,2,4},{5,7,2}});

        assertEquals(3,first.calculateDeterminant());
        assertEquals(3, first.getRowCount());
        assertEquals(3, first.getColumnCount());
        assertEquals(7, first.getElement(2,1));
    }

}