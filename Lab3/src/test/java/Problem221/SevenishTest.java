package Problem221;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SevenishTest {

    @Test
    void sevenish() {
        int sevenish = Sevenish.sevenish(6);
        assertEquals(57, sevenish);
    }
}