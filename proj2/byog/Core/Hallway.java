package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

public class Hallway {

    private static final long SEED = 1;
    // private static final Random RANDOM = new Random(SEED);
    // private static final Random RANDOM = new Random();

    public static void addHawayToRigth(Coordinate crd, TETile[][] world, Random RANDOM) {
        int hallwayLen = 4 + RANDOM.nextInt(3);
        crd.setxLen(hallwayLen);
        crd.setyLen(0);

        world[crd.getX()][crd.getY()] = Tileset.FLOOR;

        for (int xIndicator = crd.getX(); xIndicator <= crd.xOffset(hallwayLen); xIndicator++) {
            world[xIndicator][crd.yOffset(1)] = Tileset.WALL;
            world[xIndicator][crd.yOffset(-1)] = Tileset.WALL;
            world[xIndicator][crd.getY()] = Tileset.FLOOR;
        }
        world[crd.xOffset(hallwayLen)][crd.getY()] = Tileset.WALL;
    }

}
