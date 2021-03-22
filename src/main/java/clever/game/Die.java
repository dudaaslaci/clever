package clever.game;

import java.util.Random;

public class Die {

    private final Random random = new Random();
    private final Color color;
    private boolean onTray;
    private int value = -1;

    public Die(Color color) {
        this.color = color;
    }

    int roll() {
        value = random.nextInt(6) + 1;
        return value;
    }

    int value() {
        if (value == -1) {
            throw new RuntimeException("Roll first!");
        }
        return value;
    }

    Color color() {
        return color;
    }

    boolean onTray() {
        return onTray;
    }

    void choose() {
        onTray = true;
    }

    void reset() {
        value = -1;
        onTray = false;
    }

}
