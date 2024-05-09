package Map;

import Engine.Constants;

/** The Map class represents the map on which entities can exist. */
public abstract class Map {
    private final int width;
    private final int height;

    /**
     * Constructs a new Map object with the specified world size.
     *
     * @param worldSize the size of the world.
     */
    public Map(int worldSize) {
        // Negative world sizes will break the system
        if (worldSize < Constants.MINIMUM_WORLD_SIZE) {
            worldSize = Constants.WORLD_SIZE;
        }
        this.width = worldSize;
        this.height = worldSize;
    }

    /**
     * Gets the width of the map.
     *
     * @return the width of the map.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the map.
     *
     * @return the height of the map.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Checks if the given coordinates are within the bounds of the map.
     *
     * @param x the x-coordinate to check.
     * @param y the y-coordinate to check.
     * @return true if the coordinates are within bounds, false otherwise.
     */
    public boolean isNotOutOfBounds(int x, int y) {
        return (x < getWidth() && x >= Constants.WORLD_BOUNDARY_SIZE)
                && (y < getHeight() && y >= Constants.WORLD_BOUNDARY_SIZE);
    }
}
