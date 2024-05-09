package Entity;

/** The Action interface defines actions that entities can perform. */
public interface Action {
    /** Moves the entity forward. */
    void forward();

    /** Turns the entity left. */
    void turnLeft();

    /** Turns the entity right. */
    void turnRight();
}
