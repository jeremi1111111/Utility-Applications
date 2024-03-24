package Problem71;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rand5Test {

    @Test
    void rand5() {
        for (int i = 0; i < 100; i++) {
            int res = Rand5.rand5();
            assertTrue(res > 0);
            assertTrue(res <= 5);
        }
    }
}