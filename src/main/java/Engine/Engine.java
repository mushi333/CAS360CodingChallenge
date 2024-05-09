package Engine;

/** The Engine class provides a base for game engine functionality. */
public abstract class Engine {
    /** Starts the engine. */
    public void start() {}

    /**
     * Performs a game tick. This method should be implemented by subclasses to define the specific
     * behavior of the game engine.
     */
    public void tick() {}
}
