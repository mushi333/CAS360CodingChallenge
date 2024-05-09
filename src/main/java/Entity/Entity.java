package Entity;

import Engine.Constants;
import Map.Map;
import java.util.Arrays;

/** The Entity class represents an abstract entity in the game. */
public abstract class Entity {
    private int xPosition;
    private int yPosition;
    private Map map;
    private int direction;
    private int speed;

    /**
     * Constructs a new Entity object.
     *
     * @param xPosition the initial x position of the entity.
     * @param yPosition the initial y position of the entity.
     * @param direction the initial direction of the entity (NORTH, EAST, SOUTH, or WEST).
     * @param map the map on which the entity exists.
     * @param speed the speed of the entity.
     */
    public Entity(int xPosition, int yPosition, String direction, Map map, int speed) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.map = map;
        this.direction = Arrays.asList(Constants.WORD_DIRECTION_LIST).indexOf(direction);
        this.speed = speed;
    }

    /**
     * Gets the direction of the entity.
     *
     * @return the direction of the entity.
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Sets the direction of the entity.
     *
     * @param direction the direction to set.
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * Gets the x position of the entity.
     *
     * @return the x position of the entity.
     */
    public int getxPosition() {
        return xPosition;
    }

    /**
     * Sets the x position of the entity.
     *
     * @param xPosition the x position to set.
     */
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * Gets the y position of the entity.
     *
     * @return the y position of the entity.
     */
    public int getyPosition() {
        return yPosition;
    }

    /**
     * Sets the y position of the entity.
     *
     * @param yPosition the y position to set.
     */
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    /**
     * Gets the map on which the entity exists.
     *
     * @return the map on which the entity exists.
     */
    public Map getMap() {
        return map;
    }

    /**
     * Sets the map on which the entity exists.
     *
     * @param map the map to set.
     */
    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * Gets the speed of the entity.
     *
     * @return the speed of the entity.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the entity.
     *
     * @param speed the speed to set.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Returns a string representing the current location of the entity.
     *
     * @return a string representing the current location of the entity.
     */
    public String returnLocation() {
        return ("("
                + getxPosition()
                + ","
                + getyPosition()
                + ") "
                + Constants.WORD_DIRECTION_LIST[getDirection()]);
    }
}
