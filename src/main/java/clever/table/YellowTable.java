package clever.table;

import clever.game.Bonus;

import java.util.Set;
import java.util.TreeSet;

import static clever.game.Bonus.*;
import static java.util.Arrays.asList;

/**
 * 3 - 6 - 5 - X - B  Positions: 1 --  2 --  3 -- X
 * |   |   |   |                 4 --  5 --  X -- 6
 * 2 - 1 - X - 5 - O4            7 --  X --  8 -- 9
 * |   |   |   |                X -- 10 -- 11 -- 12
 * 1 - X - 2 - 4 - G
 * |   |   |   |
 * X - 3 - 4 - 6 - Fox
 * |   |   |   | \
 * 10  14  16  20 +1
 */
public class YellowTable implements Table {

    private boolean[] positions = new boolean[12];

    @Override
    public int score() {
        int result = 0;
        if (positions[0] && positions[3] && positions[6]) result += 10;
        if (positions[1] && positions[4] && positions[9]) result += 14;
        if (positions[2] && positions[7] && positions[10]) result += 16;
        if (positions[5] && positions[8] && positions[11]) result += 20;
        return result;
    }

    @Override
    public boolean isValid(int position, int value) {
        if (positions[position - 1]) return false;
        if (position == 1 && value == 3) return true;
        if (position == 2 && value == 6) return true;
        if (position == 3 && value == 5) return true;
        if (position == 4 && value == 2) return true;
        if (position == 5 && value == 1) return true;
        if (position == 6 && value == 5) return true;
        if (position == 7 && value == 1) return true;
        if (position == 8 && value == 2) return true;
        if (position == 9 && value == 4) return true;
        if (position == 10 && value == 3) return true;
        if (position == 11 && value == 4) return true;
        return position == 12 && value == 6;
    }

    @Override
    public Set<Bonus> write(int position, int value) {
        positions[position - 1] = true;
        return calculateBonuses(position);
    }

    private Set<Bonus> calculateBonuses(int lastPosition) {
        Set<Bonus> result = new TreeSet<>();
        if (positions[0] && positions[1] && positions[2] && asList(1, 2, 3).contains(lastPosition)) {
            result.add(BLUE_JOKER);
        }
        if (positions[3] && positions[4] && positions[5] && asList(4, 5, 6).contains(lastPosition)) {
            result.add(ORANGE_FOUR);
        }
        if (positions[6] && positions[7] && positions[8] && asList(7, 8, 9).contains(lastPosition)) {
            result.add(GREEN_JOKER);
        }
        if (positions[9] && positions[10] && positions[11] && asList(10, 11, 12).contains(lastPosition)) {
            result.add(FOX);
        }
        if (positions[0] && positions[4] && positions[7] && positions[11]  && asList(1, 5, 8, 12).contains(lastPosition)) {
            result.add(PLUS_DIE);
        }
        return result;
    }
}
