package Problem71;

import java.util.Random;

public class Rand5 {
    public static int rand5() {
        Random randomizer = new Random();
        int roll = randomizer.nextInt(6) + 1;
        if (roll <= 5) {
            return roll;
        }
        return rand5();
    }
}
