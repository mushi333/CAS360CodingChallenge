import static org.junit.jupiter.api.Assertions.*;

import Map.DefaultMap;
import Map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMap {
    public Map map;
    public int mapSize = 7;

    @BeforeEach
    public void setUpMap() {
        map = new DefaultMap(mapSize);
    }

    @Test
    public void testIsNotOutOfBounds() {
        int xPosition = 3;
        int yPosition = 3;
        assertTrue(map.isNotOutOfBounds(xPosition, yPosition));
    }

    @Test
    public void testIsNotOutOfBoundsFalse() {
        int xPosition = -1;
        int yPosition = -1;
        assertFalse(map.isNotOutOfBounds(xPosition, yPosition));
    }

    @Test
    public void testIsNotOutOfBoundsOnEdge() {
        int xPosition = 0;
        int yPosition = 0;
        assertTrue(map.isNotOutOfBounds(xPosition, yPosition));
        xPosition = 6;
        yPosition = 6;
        assertTrue(map.isNotOutOfBounds(xPosition, yPosition));
    }

    @Test
    public void testNegativeWorldSize() {
        int negativeMapSize = -1;
        map = new DefaultMap(negativeMapSize);
        assertEquals(mapSize, map.getHeight());
        assertEquals(mapSize, map.getWidth());
    }
}
