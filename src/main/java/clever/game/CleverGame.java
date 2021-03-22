package clever.game;

import clever.table.*;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;

import java.util.Map;
import java.util.Set;

import static clever.game.Color.*;

/**
 * R - +1 - R - J
 */
public class CleverGame {

    private final Multiset<Bonus> bonuses;
    private final Map<Color, Table> tables;
    int lastGreenPosition;
    int lastOrangePosition;
    int lastPurplePosition;

    private CleverGame() {
        bonuses = HashMultiset.create();
        bonuses.add(Bonus.REROLL);
        tables = ImmutableMap.of(
                YELLOW, new YellowTable(),
                BLUE, new BlueTable(),
                GREEN, new GreenTable(),
                ORANGE, new OrangeTable(),
                PURPLE, new PurpleTable()
        );
    }

    public static void main(String[] args) {
        CleverGame game = new CleverGame();
        Set<Die> dice = game.roll();
        game.reroll();
        game.write(PURPLE, PURPLE);
        game.reuse(PURPLE, PURPLE);
        game.write(YELLOW, YELLOW, 10);
        game.reuse(YELLOW, YELLOW, 10);
        int score = game.score();
        System.out.println(score);
    }

    private int score() {
        return 0;
    }

    private void write(Color die, Color tableColor) {
    }

    private void write(Color die, Color table, int position) {
        if (table != YELLOW) {
            throw new RuntimeException("Not a positional table");
        }
    }

    private void reuse(Color die, Color table) {
    }

    private void reuse(Color die, Color table, int position) {
        if (table != YELLOW) {
            throw new RuntimeException("Not a positional table!");
        }
    }


    private Set<Die> roll() {
        return null;
    }

    private void reroll() {
    }

}
