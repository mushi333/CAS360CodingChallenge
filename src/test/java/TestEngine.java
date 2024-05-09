import static org.junit.jupiter.api.Assertions.assertEquals;

import Engine.GameEngine;
import java.io.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEngine {
    public GameEngine engine;
    public ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public ByteArrayOutputStream originalOutputStream = outputStream;

    @BeforeEach
    public void setup() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        engine = new GameEngine();
    }

    @AfterEach
    public void breakdown() {
        outputStream = originalOutputStream;
    }

    public String cleanNewLine(String previous) {
        return previous.replace("\r", "");
    }

    @Test
    public void testPlacement() throws FileNotFoundException {
        engine.start("src/test/resources/input01.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(0,0) NORTH\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testDoublePlacement() throws FileNotFoundException {
        engine.start("src/test/resources/input02.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(6,6) SOUTH\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testTurnLeft() throws FileNotFoundException {
        engine.start("src/test/resources/input03.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(0,0) WEST\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testTurnRight() throws FileNotFoundException {
        engine.start("src/test/resources/input04.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(0,0) EAST\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testForward() throws FileNotFoundException {
        engine.start("src/test/resources/input05.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(0,1) NORTH\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testNotForwardFromNorth() throws FileNotFoundException {
        engine.start("src/test/resources/input06.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(6,6) NORTH\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testForwardFromEast() throws FileNotFoundException {
        engine.start("src/test/resources/input07.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(6,6) EAST\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testCannotForwardFromEast() throws FileNotFoundException {
        engine.start("src/test/resources/input08.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(6,6) EAST\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testForwardFromSouth() throws FileNotFoundException {
        engine.start("src/test/resources/input09.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(0,0) SOUTH\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testCannotForwardFromSouth() throws FileNotFoundException {
        engine.start("src/test/resources/input10.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(0,0) SOUTH\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testForwardFromWest() throws FileNotFoundException {
        engine.start("src/test/resources/input11.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(0,0) WEST\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testCannotForwardFromWest() throws FileNotFoundException {
        engine.start("src/test/resources/input12.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(0,0) WEST\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testPlacingOutOfBounds() throws FileNotFoundException {
        engine.start("src/test/resources/input13.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(0,0) NORTH\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testMovingBeforePlacing() throws FileNotFoundException {
        engine.start("src/test/resources/input14.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("(0,0) NORTH\n", cleanNewLine(gpsStatus));
    }

    @Test
    public void testIncorrectCommand() throws FileNotFoundException {
        engine.start("src/test/resources/input15.txt");
        String gpsStatus = outputStream.toString();
        assertEquals("", cleanNewLine(gpsStatus));
    }

    @Test
    public void testEndTerminalInputs() {
        System.setIn(new ByteArrayInputStream("END".getBytes()));
        engine.start();
        String gpsStatus = outputStream.toString();
        assertEquals("", cleanNewLine(gpsStatus));
    }

    @Test
    public void testNonEndingTerminalInputs() {
        System.setIn(new ByteArrayInputStream("PLACE 0,0,NORTH\nGPS_REPORT\nEND\n".getBytes()));
        engine.start();
        String gpsStatus = outputStream.toString();
        assertEquals("(0,0) NORTH\n", cleanNewLine(gpsStatus));
    }
}
