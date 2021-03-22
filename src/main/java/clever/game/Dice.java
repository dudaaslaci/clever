package clever.game;

import java.util.HashSet;
import java.util.Set;

import static clever.game.Color.*;

public class Dice {

    private final Set<Die> freeDice;
    private final Set<Die> usedDice;

    public Dice() {
        freeDice = new HashSet<>(6);
        freeDice.add(new Die(YELLOW));
        freeDice.add(new Die(BLUE));
        freeDice.add(new Die(GREEN));
        freeDice.add(new Die(ORANGE));
        freeDice.add(new Die(PURPLE));
        freeDice.add(new Die(WHITE));
        usedDice = new HashSet<>(6);
    }
}
