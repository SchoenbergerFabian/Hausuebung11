import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void testGetDifferences() {
        LocalDateTime start = LocalDateTime.of(2004,1,23,6,30,20);
        LocalDateTime end = LocalDateTime.of(2020,1,23,6,30,20);
        long[] expected = new long[]{5844,834,192,16,140256,8415360,504921600};
        long[] actual = Main.getDifferences(start,end);
        assertEquals(expected[0],actual[0]);
        assertEquals(expected[1],actual[1]);
        assertEquals(expected[2],actual[2]);
        assertEquals(expected[3],actual[3]);
        assertEquals(expected[4],actual[4]);
        assertEquals(expected[5],actual[5]);
    }
}