package clever.table;

import clever.game.Bonus;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

import static clever.game.Bonus.*;
import static java.util.Collections.emptySet;

/**
 * Bonus: X-X-R-B-+1-Y-FOX-R-G-O6-+1
 */
public class PurpleTable implements Table {

    private int[] values = new int[11];

    @Override
    public int score() {
        int score = 0;
        for (int value : values) {
            score += value;
        }
        return score;
    }

    @Override
    public boolean isValid(int position, int value) {
        if (position == 1 && values[0] == 0) return true;
        if (values[position - 2] == 0 || values[position - 1] != 0) {
            return false;
        }
        return values[position - 2] == 6 || values[position - 2] < value;
    }

    @Override
    public Set<Bonus> write(int position, int value) {
        values[position - 1] = value;
        switch (position) {
            case 3:
                return ImmutableSet.of(REROLL);
            case 4:
                return ImmutableSet.of(BLUE_JOKER);
            case 5:
                return ImmutableSet.of(PLUS_DIE);
            case 6:
                return ImmutableSet.of(YELLOW_JOKER);
            case 7:
                return ImmutableSet.of(FOX);
            case 8:
                return ImmutableSet.of(REROLL);
            case 9:
                return ImmutableSet.of(GREEN_JOKER);
            case 10:
                return ImmutableSet.of(ORANGE_SIX);
            case 11:
                return ImmutableSet.of(PLUS_DIE);
            default:
                return emptySet();

        }
    }
}
