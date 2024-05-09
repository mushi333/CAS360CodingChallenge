import static org.junit.jupiter.api.Assertions.assertEquals;

import Engine.Constants;
import Entity.Bike;
import Entity.LivingEntity;
import Map.DefaultMap;
import Map.Map;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEntity {
    public LivingEntity bike;
    public int mapSize;
    public Map map;
    public int xPosition;
    public int yPosition;
    public String direction;
    public int speed;

    @BeforeEach
    public void setUpEntity() {
        mapSize = 7;
        xPosition = 0;
        yPosition = 0;
        direction = Constants.NORTH;
        speed = Constants.BIKE_SPEED;
        map = new DefaultMap(mapSize);
        bike = new Bike(xPosition, yPosition, direction, map, Constants.BIKE_SPEED);
    }

    @Test
    public void testGetDirection() {
        assertEquals(
                Arrays.asList(Constants.WORD_DIRECTION_LIST).indexOf(Constants.NORTH), bike.getDirection());
    }

    @Test
    public void testTurnLeft() {
        bike.turnLeft();
        assertEquals(
                Arrays.asList(Constants.WORD_DIRECTION_LIST).indexOf(Constants.WEST), bike.getDirection());
    }

    @Test
    public void testTurnRight() {
        bike.turnRight();
        assertEquals(
                Arrays.asList(Constants.WORD_DIRECTION_LIST).indexOf(Constants.EAST), bike.getDirection());
    }

    @Test
    public void testForward() {
        bike.forward();
        assertEquals(
                Arrays.asList(Constants.WORD_DIRECTION_LIST).indexOf(Constants.NORTH), bike.getDirection());
        assertEquals(0, bike.getxPosition());
        assertEquals(1, bike.getyPosition());
    }

    @Test
    public void testReturnLocation() {
        assertEquals("(0,0) NORTH", bike.returnLocation());
    }

    @Test
    public void testUpdateMap() {
        int newMapSize = 1;
        Map newMap = new DefaultMap(newMapSize);
        bike.setMap(newMap);
        assertEquals(newMapSize, bike.getMap().getWidth());
        assertEquals(newMapSize, bike.getMap().getHeight());
    }

    @Test
    public void testUpdateSpeed() {
        int newSpeed = 10;
        bike.setSpeed(newSpeed);
        assertEquals(newSpeed, bike.getSpeed());
    }
}
