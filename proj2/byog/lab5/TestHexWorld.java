package byog.lab5;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestHexWorld {

    @Test
    public void testInitialDownXCoordinate() {
        int xStart = 2;
        int input1 = HexWorld.initialDownXCoordinate(xStart, 1);
        int expect1 = 2;
        int input2 = HexWorld.initialDownXCoordinate(xStart, 2);
        int expect2 = 3;
        int input3 = HexWorld.initialDownXCoordinate(xStart, 3);
        int expect3 = 4;
        int input4 = HexWorld.initialDownXCoordinate(xStart, 4);
        int expect4 = 5;

        assertEquals(input1,expect1);
        assertEquals(input2,expect2);
        assertEquals(input3,expect3);
        assertEquals(input4,expect4);
    }

    @Test
    public void testInitialUpYCoordinate() {
        int yStart = 2;
        int input1 = HexWorld.initialUpYCoordinate(yStart, 1);
        int expect1 = 3;
        int input2 = HexWorld.initialUpYCoordinate(yStart, 2);
        int expect2 = 4;
        int input3 = HexWorld.initialUpYCoordinate(yStart, 3);
        int expect3 = 5;
        int input4 = HexWorld.initialUpYCoordinate(yStart, 4);
        int expect4 = 6;

        assertEquals(input1,expect1);
        assertEquals(input2,expect2);
        assertEquals(input3,expect3);
        assertEquals(input4,expect4);
    }
}
