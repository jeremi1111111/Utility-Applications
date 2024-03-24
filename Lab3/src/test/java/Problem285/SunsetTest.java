package Problem285;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SunsetTest {

    @Test
    void sunset() {
        ArrayList<Integer> street = new ArrayList<>();
        Collections.addAll(street, 3, 7, 8, 3, 6, 1);
        int blocks = Sunset.sunset(street);
        assertEquals(3, blocks);
    }
}