import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {
    @Test
    public void multiply() throws Exception {
        Vector first = VectorCreator.createFromArray(new int[]{1, 2});
        Vector second = VectorCreator.createFromArray(new int[]{1, 3});
        assertNotNull(first);
        assertNotNull(second);
        assertEquals(7, first.multiply(second));
    }
}