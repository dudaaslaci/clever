package clever.table;

import clever.game.Bonus;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

import static clever.game.Bonus.*;
import static java.util.Collections.emptySet;

/**
 * Bonus: X-X-R-(X2)-Y-+1-(X2)-FOX-(X2)-P6-(X3)
 */
public class OrangeTable implements Table {

    private int[] values = new int[11];

    @Override
    public int score() {
        int score = 0;
        for (int value : values) {
            score += value;
        }
        score += values[3];
        score += values[6];
        score += values[10] * 2;
        return score;
    }

    @Override
    public boolean isValid(int position, int value) {
        if (position == 1 && values[0] == 0) return true;
        return values[position - 2] > 0 && values[position - 1] == 0;
    }

    @Override
    public Set<Bonus> write(int position, int value) {
        if (isValid(position, value)) {
            values[position - 1] = value;
            switch (position) {
                case 3: return ImmutableSet.of(REROLL);
                case 5: return ImmutableSet.of(YELLOW_JOKER);
                case 6: return ImmutableSet.of(PLUS_DIE);
                case 8: return ImmutableSet.of(FOX);
                case 10: return ImmutableSet.of(PURPLE_SIX);
                default: return emptySet();

            }
        }
        throw new RuntimeException(String.format("Invaild write! Orange table position: %d, value: %d", position, value));
    }
}
