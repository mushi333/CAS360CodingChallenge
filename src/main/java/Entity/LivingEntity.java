package Entity;

import Engine.Constants;
import Map.Map;

/** The LivingEntity class represents a living entity in the game that can perform actions. */
public abstract class LivingEntity extends Entity implements Action {
    /**
     * Constructs a new LivingEntity object.
     *
     * @param xPosition the initial x position of the entity.
     * @param yPosition the initial y position of the entity.
     * @param direction the initial direction of the entity (NORTH, EAST, SOUTH, or WEST).
     * @param map the map on which the entity exists.
     * @param speed the speed of the entity.
     */
    public LivingEntity(int xPosition, int yPosition, String direction, Map map, int speed) {
        super(xPosition, yPosition, direction, map, speed);
    }

    /** Moves the entity forward in the current direction. */
    public void forward() {
        if (Constants.WORD_DIRECTION_LIST[getDirection()].equals(Constants.NORTH)) {
            if (getMap().isNotOutOfBounds(getxPosition(), getyPosition() + getSpeed())) {
                setyPosition(getyPosition() + getSpeed());
            }
        }
        if (Constants.WORD_DIRECTION_LIST[getDirection()].equals(Constants.EAST)) {
            if (getMap().isNotOutOfBounds(getxPosition() + getSpeed(), getyPosition())) {
                setxPosition(getxPosition() + getSpeed());
            }
        }
        if (Constants.WORD_DIRECTION_LIST[getDirection()].equals(Constants.SOUTH)) {
            if (getMap().isNotOutOfBounds(getxPosition(), getyPosition() - getSpeed())) {
                setyPosition(getyPosition() - getSpeed());
            }
        }
        if (Constants.WORD_DIRECTION_LIST[getDirection()].equals(Constants.WEST)) {
            if (getMap().isNotOutOfBounds(getxPosition() - getSpeed(), getyPosition())) {
                setxPosition(getxPosition() - getSpeed());
            }
        }
    }

    /** Turns the entity left by decrementing its direction. */
    public void turnLeft() {
        setDirection(
                Math.floorMod(getDirection() - Constants.TURNING_SPEED, Constants.DIRECTION_LIST.length));
    }

    /** Turns the entity right by incrementing its direction. */
    public void turnRight() {
        setDirection(
                Math.floorMod(getDirection() + Constants.TURNING_SPEED, Constants.DIRECTION_LIST.length));
    }
}
