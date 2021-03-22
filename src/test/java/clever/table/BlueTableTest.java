package clever.table;

import clever.game.Bonus;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BlueTableTest {

    @Test
    public void noScore() {
        BlueTable table = new BlueTable();
        assertThat(table.score(), is(0));
    }

    @Test
    public void oneScore() {
        BlueTable table = new BlueTable();
        table.write(2,2);
        assertThat(table.score(), is(1));
    }

    @Test
    public void twoFilledScore() {
        BlueTable table = new BlueTable();
        table.write(2,2);
        table.write(3,3);
        assertThat(table.score(), is(2));
    }

    @Test
    public void threeFilledScore() {
        BlueTable table = new BlueTable();
        table.write(2, 2);
        table.write(3, 3);
        Set<Bonus> bonus = table.write(4, 4);
        assertThat(table.score(), is(4));
        assertThat(bonus, hasItem(Bonus.ORANGE_FIVE));
        bonus = table.write(5, 5);
        assertTrue(bonus.isEmpty());
    }

    @Test
    public void multipleBonus() {
        BlueTable table = new BlueTable();
        table.write(3,3);
        table.write(4,4);
        table.write(6,6);
        table.write(10,10);
        Set<Bonus> bonuses = table.write(2,2);
        assertThat(bonuses.size(), is(2));
    }

}