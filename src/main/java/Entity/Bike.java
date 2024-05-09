package Entity;

import Map.Map;

/** The Bike class represents a bike entity in the game. */
public class Bike extends LivingEntity {
    /**
     * Constructs a new Bike object.
     *
     * @param xPosition the initial x position of the bike.
     * @param yPosition the initial y position of the bike.
     * @param direction the initial direction of the bike (NORTH, EAST, SOUTH, or WEST).
     * @param map the map on which the bike exists.
     * @param speed the speed of the bike.
     */
    public Bike(int xPosition, int yPosition, String direction, Map map, int speed) {
        super(xPosition, yPosition, direction, map, speed);
    }
}
