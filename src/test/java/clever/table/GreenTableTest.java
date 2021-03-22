package clever.table;

import clever.game.Bonus;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static clever.game.Bonus.*;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GreenTableTest {

    private GreenTable table;

    @Before
    public void setUp(){
        table = new GreenTable();
    }

    @Test
    public void emptyTableScoresZero() {
        assertThat(table.score(), is(0));
    }

    @Test
    public void writeFirst() {
        assertThat(table.isValid(1,1), is(true));
        assertThat(table.isValid(2,1), is(false));
    }

    @Test
    public void fullGame() {
        Set<Bonus> bonus;
        table.write(1,1);
        table.write(2,2);
        table.write(3,3);
        bonus = table.write(4,4);
        assertThat(bonus, hasItem(is(PLUS_DIE)));
        table.write(5,5);
        bonus = table.write(6,1);
        assertThat(bonus, hasItem(is(BLUE_JOKER)));
        bonus = table.write(7,2);
        assertThat(bonus, hasItem(is(FOX)));
        table.write(8,3);
        bonus = table.write(9,4);
        assertThat(bonus, hasItem(is(PURPLE_SIX)));
        bonus = table.write(10,5);
        assertThat(bonus, hasItem(is(REROLL)));
        table.write(11, 6);
        assertThat(table.score(), is(66));
    }



}