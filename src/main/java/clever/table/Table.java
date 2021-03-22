package clever.table;

import clever.game.Bonus;

import java.util.Set;

public interface Table {

    int score();
    boolean isValid(int position, int value);
    Set<Bonus> write(int position, int value);

}
