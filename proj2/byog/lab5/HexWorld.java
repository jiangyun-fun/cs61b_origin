package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    public static int initialDownXCoordinate(int xStart, int ithRow) {
        return xStart + ithRow - 1;
    }

    public static int initialDownYCoordinate(int yStart, int ithRow) {
        return yStart - ithRow + 1;
    }

    public static int initialUpYCoordinate(int yStart, int ithRow) {
        return yStart + ithRow;
    }

    public static int hexRowWidth(int size, int ithRow) {
        return 3 * size - ithRow  * 2;
    }


    /*
    public static char[][] addHexagon(int size, int xStart, int yStart) {
        char[][] hexagonWorld = new char[20][20];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++){
                hexagonWorld[i][j] = ' ';
            }
        }

        for (int ithRow = 1; ithRow <= size; ithRow++) {
            int xx = initialDownXCoordinate(xStart, ithRow);
            int downY = initialDownYCoordinate(yStart, ithRow);
            int upY = initialUpYCoordinate(yStart, ithRow);
            int width = hexRowWidth(size, ithRow);

            for (int ithCol = 1; ithCol <= width; ithCol++) {
                hexagonWorld[downY][xx] = 'a';
                hexagonWorld[upY][xx] = 'a';
                xx += 1;
            }
        }
        return hexagonWorld;
    }

    public static void main(String[] args) {
        char[][] demoHexagon = addHexagon(3, 6, 7);


        for (int i = 0; i < 20; i++) {
            for (int j = 19; j > -1; j--){
                System.out.print(demoHexagon[i][j]);
            }
            System.out.println();
        }
    }
    */
    public static void addHexagon(int size, int xStart, int yStart, TETile[][] world) {
        Random r = new Random(1000);

        for (int ithRow = 1; ithRow <= size; ithRow++) {
            int xx = initialDownXCoordinate(xStart, ithRow);
            int downY = initialDownYCoordinate(yStart, ithRow);
            int upY = initialUpYCoordinate(yStart, ithRow);
            int width = hexRowWidth(size, ithRow);

            for (int ithCol = 1; ithCol <= width; ithCol++) {
                world[xx][downY] = TETile.colorVariant(Tileset.TREE, 100, 100, 100, r);
                world[xx][upY] = TETile.colorVariant(Tileset.TREE, 100, 100, 100, r);;
                xx += 1;
            }
        }
    }
}