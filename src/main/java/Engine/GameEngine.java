package Engine;

import Entity.Bike;
import Map.DefaultMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/** The GameEngine class controls the game logic and execution. */
public class GameEngine extends Engine {
    private Scanner scanner;
    private final DefaultMap map = new Map.DefaultMap(Constants.WORLD_SIZE);
    private Bike bike;
    private boolean bikeIsPlaced = false;
    HashMap<String, String> commands;
    private static GameEngine engine;

    /** Constructs a new GameEngine object. */
    private GameEngine() {}

    public static GameEngine getInstance() {
        if (engine == null) {
            engine = new GameEngine();
        }
        return engine;
    }

    /**
     * Starts the game using commands from a file.
     *
     * @param fileName the name of the file containing commands.
     * @throws FileNotFoundException if the specified file is not found.
     */
    public void start(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            commands = parseInput(scanner.nextLine());
            tick();
        }
    }

    /** Starts the game using commands from the console. */
    public void start() {
        scanner = new Scanner(System.in);
        do {
            commands = parseInput(scanner.nextLine());
            tick();
        } while (!commands.get(Constants.TYPE).equals(Constants.END_COMMAND));
    }

    /**
     * Parses the input command into a HashMap of command parameters.
     *
     * @param input the input command string.
     * @return a HashMap containing command parameters.
     */
    private HashMap<String, String> parseInput(String input) {
        HashMap<String, String> commands = new HashMap<>();
        // Only PLACE has extra arguments
        if (input.contains(Constants.PLACE_COMMAND)) {
            String[] splitInputs = input.split(Constants.EMPTY_SPACE_REGEX_PATTERN);
            String[] splitArguments = splitInputs[1].split(Constants.COMMA_REGEX_PATTERN);
            commands.put(Constants.TYPE, splitInputs[0]);
            commands.put(Constants.X, splitArguments[0]);
            commands.put(Constants.Y, splitArguments[1]);
            commands.put(Constants.DIRECTION, splitArguments[2]);
        } else {
            commands.put(Constants.TYPE, input);
        }

        return commands;
    }

    /** Executes the next game action based on the current command. */
    public void tick() {
        if (commands.get(Constants.TYPE).equals(Constants.PLACE_COMMAND)) {
            int x = Integer.parseInt(commands.get(Constants.X));
            int y = Integer.parseInt(commands.get(Constants.Y));
            String direction = commands.get(Constants.DIRECTION);
            if (map.isNotOutOfBounds(x, y)) {
                bike = new Bike(x, y, direction, map, Constants.BIKE_SPEED);
                bikeIsPlaced = true;
            }
        } else if (bikeIsPlaced) {
            switch (commands.get(Constants.TYPE)) {
                case Constants.FORWARD_COMMAND:
                    bike.forward();
                    break;
                case Constants.TURN_LEFT_COMMAND:
                    bike.turnLeft();
                    break;
                case Constants.TURN_RIGHT_COMMAND:
                    bike.turnRight();
                    break;
                case Constants.GPS_REPORT_COMMAND:
                    System.out.println(bike.returnLocation());
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Main method to start the game engine.
     *
     * @param args the command-line arguments. The first argument can be a file name.
     * @throws FileNotFoundException if the specified file is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        GameEngine engine = new GameEngine();
        try {
            if (args.length > 0) {
                engine.start(args[0]);
            } else {
                engine.start();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            System.exit(1);
        }
    }
}
