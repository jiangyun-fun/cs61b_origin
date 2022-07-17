package byog.lab5;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

/**
 *  Draws hexagons.
 */
public class DrawHexagons {


    /** adds a hexagon of side length s to a given position in the world */
    public static char[][] addHexagon(int size, int xStart, int yStart) {
        char[][] hexagonWorld = new char[100][100];
        int xx = xStart;
        int yy = yStart;

        int xLength = 3 * size - 2;
        int yMaxLength = 2 * size;

        int firstInitialPrintYPosition = yStart + size - 1;
        int lastFinalPrintYPosition = yStart + size;

        for (int x = xStart, indicator = 0; x <= xStart + size - 1; x += 1, indicator++) {
            int initialPrintYPosition = firstInitialPrintYPosition - indicator;
            int finalPrintYPosition = lastFinalPrintYPosition + indicator;

            for (int y = yStart; y <= size * 2; y += 1) {
                if (y >= initialPrintYPosition || y <= finalPrintYPosition) {
                    hexagonWorld[x][y] = 'a';
                }
            }
        }
        return hexagonWorld;
    }

    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        char[][] demoHexagoworld = DrawHexagons.addHexagon(5, 1, 1);
        int count = 1;
        // fills in a block 14 tiles wide by 4 tiles tall
        for (int x = 1; x < WIDTH; x += 1) {
            for (int y = 1; y < HEIGHT; y += 1) {
                if (demoHexagoworld[x][y] == 'a') {
                    // world[x][y] = Tileset.GRASS;
                    System.out.println(count + ' ');
                    count++;
                }
            }
        }

        // draws the world to the screen
        ter.renderFrame(world);
    }
}

