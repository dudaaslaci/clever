package clever.table;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PurpleTableTest {


    @Test
    public void isValid() {
        Table table = new PurpleTable();
        assertTrue(table.isValid(1,5));
        table.write(1, 5);
        assertFalse(table.isValid(2, 5));
        assertTrue(table.isValid(2, 6));
        table.write(2,6);
        assertTrue(table.isValid(3,1));
        table.write(3,1);
        assertFalse(table.isValid(5, 1));
    }
}