package clever.table;

import clever.game.Bonus;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class YellowTableTest {


    @Test
    public void game() {
        Table table = new YellowTable();
        assertTrue(table.isValid(1,3));
        table.write(1,3);
        assertTrue(table.isValid(5,1));
        table.write(5,1);
        assertTrue(table.isValid(8,2));
        table.write(8,2);
        assertTrue(table.isValid(10,3));
        table.write(10,3);
        assertTrue(table.isValid(11,4));
        table.write(11,4);
        assertTrue(table.isValid(12,6));
        Set<Bonus> bonuses = table.write(12,6);
        assertThat(bonuses.size(), is(2));
        table.write(4,2);
        table.write(7, 1);
        assertThat(table.score(),is(10));
        table.write(2,6);
        assertThat(table.score(), is(24));
    }

}