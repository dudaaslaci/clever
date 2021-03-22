package clever.table;

import clever.game.Bonus;

import java.util.Set;
import java.util.TreeSet;

import static clever.game.Bonus.*;
import static java.util.Arrays.asList;

/*
         2 -- 3 -- 4 ==> O5
         |    |    |
    5 -- 6 -- 7 -- 8 ==> Y
    |    |    |    |
    9 - 10 - 11 - 12 ==> FOX
    |    |    |    |
    R    G    P   +1
 */
public class BlueTable implements Table {

    private boolean[] positions = new boolean[11];

    @Override
    public int score() {
        int count = 0;
        for (boolean filled : positions) {
            if (filled) ++count;
        }
        int score = count > 0 ? 1 : 0;
        for (int i = 0; i < count; ++i) {
            score += i;
        }
        return score;
    }

    @Override
    public boolean isValid(int position, int value) {
        return position == value && !positions[position + 1];
    }

    @Override
    public Set<Bonus> write(int position, int value) {
        positions[position - 2] = true;
        return calculateBonuses(position);
    }

    private Set<Bonus> calculateBonuses(int lastPosition) {
        Set<Bonus> result = new TreeSet<>();
        if (positions[0] && positions[1] && positions[2] && asList(2, 3, 4).contains(lastPosition)) {
            result.add(ORANGE_FIVE);
        }
        if (positions[3] && positions[4] && positions[5] && positions[6]  && asList(5, 6, 7, 8).contains(lastPosition)) {
            result.add(YELLOW_JOKER);
        }
        if (positions[7] && positions[8] && positions[9] && positions[10]  && asList(9, 10, 11, 12).contains(lastPosition)) {
            result.add(FOX);
        }
        if (positions[3] && positions[7] && asList(5, 9).contains(lastPosition)) {
            result.add(REROLL);
        }
        if (positions[0] && positions[4] && positions[8] && asList(2, 6, 10).contains(lastPosition)) {
            result.add(GREEN_JOKER);
        }
        if (positions[1] && positions[5] && positions[9] && asList(3, 7, 11).contains(lastPosition)) {
            result.add(PURPLE_SIX);
        }
        if (positions[2] && positions[6] && positions[10] && asList(4, 8, 12).contains(lastPosition)) {
            result.add(PLUS_DIE);
        }
        return result;
    }
}
