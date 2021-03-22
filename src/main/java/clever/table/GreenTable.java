package clever.table;

import clever.game.Bonus;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

import static clever.game.Bonus.*;
import static java.util.Collections.emptySet;

/**
 * Score:       1 - 3 - 6 - 10 - 15 - 21 - 28 - 36 - 45 - 55 - 66
 * Condition:  >=1 >=2 >=3 >=4  >=5  >=1  >=2  >=3  >=4  >=5  >=6
 * Bonus                    +1        B   FOX        P    R
 */


public class GreenTable implements Table {

    private int lastFilled = 0;


    @Override
    public int score() {
        return (lastFilled * (1 + lastFilled))/ 2;
    }

    @Override
    public boolean isValid(int position, int value) {
        if (position != lastFilled + 1) return false;
        if (position < 6) {
            return value >= position;
        } else {
            return value > position - 6;
        }
    }

    @Override
    public Set<Bonus> write(int position, int value) {
        if (isValid(position, value)) {
            ++lastFilled;
            switch (lastFilled) {
                case 4: return ImmutableSet.of(PLUS_DIE);
                case 6: return ImmutableSet.of(BLUE_JOKER);
                case 7: return ImmutableSet.of(FOX);
                case 9: return ImmutableSet.of(PURPLE_SIX);
                case 10: return ImmutableSet.of(REROLL);
                default: return emptySet();

            }
        }
        throw new RuntimeException(String.format("Invaild write! Green table position: %d, value: %d", position, value));
    }
}
