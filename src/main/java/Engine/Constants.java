package Engine;

/** The Constants class holds constant values used throughout the game engine. */
public final class Constants {
    private Constants() {}

    // World Constants
    public static final int WORLD_SIZE = 7;
    public static final int MINIMUM_WORLD_SIZE = 1;
    public static final int WORLD_BOUNDARY_SIZE = 0;

    // Movement Constants
    public static final int TURNING_SPEED = 1;
    public static final int BIKE_SPEED = 1;

    // Direction Constants
    public static final String NORTH = "NORTH";
    public static final String EAST = "EAST";
    public static final String SOUTH = "SOUTH";
    public static final String WEST = "WEST";
    public static final String[] WORD_DIRECTION_LIST = {NORTH, EAST, SOUTH, WEST};
    public static final int[] DIRECTION_LIST = {0, 1, 2, 3};

    // Command Constants
    public static final String PLACE_COMMAND = "PLACE";
    public static final String FORWARD_COMMAND = "FORWARD";
    public static final String TURN_LEFT_COMMAND = "TURN_LEFT";
    public static final String TURN_RIGHT_COMMAND = "TURN_RIGHT";
    public static final String GPS_REPORT_COMMAND = "GPS_REPORT";
    public static final String END_COMMAND = "END";

    // Command Parameter Constants
    public static final String TYPE = "TYPE";
    public static final String X = "X";
    public static final String Y = "Y";
    public static final String DIRECTION = "DIRECTION";

    // Regex Patterns
    public static final String EMPTY_SPACE_REGEX_PATTERN = "\\s";
    public static final String COMMA_REGEX_PATTERN = ",";
}
