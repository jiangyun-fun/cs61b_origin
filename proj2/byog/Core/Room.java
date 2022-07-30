package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

public class Room {

    private static final long SEED = 1;
    // private static final Random RANDOM = new Random(SEED);
    // private static final Random RANDOM = new Random();


    public static void addRoom(Coordinate crd, TETile[][] world, Random RANDOM) {
        int xLen = 4 + RANDOM.nextInt(3);
        int yLen = 6 + RANDOM.nextInt(3);

        crd.setxLen(xLen);
        crd.setyLen(yLen);
        int oldY = crd.getY();
        crd.setY(crd.getY()- 1 - RANDOM.nextInt(yLen - 1));

        for (int yIndicator = crd.getY(); yIndicator <= crd.yOffset(yLen); yIndicator++) {
            for (int xIndicator = crd.getX(); xIndicator <= crd.xOffset(xLen); xIndicator++) {
                if (xIndicator == crd.getX() || yIndicator == crd.getY() ||
                        xIndicator == crd.xOffset(xLen) || yIndicator == crd.yOffset(yLen)) {
                    world[xIndicator][yIndicator] = Tileset.WALL;
                } else {
                    world[xIndicator][yIndicator] = Tileset.FLOOR;
                }
            }
        }
        for (int yIdicator = crd.getY(); yIdicator <= crd.yOffset(yLen); yIdicator++) {
            if (world[crd.getX() - 1][yIdicator].equals(Tileset.FLOOR)) {
                world[crd.getX()][yIdicator] = Tileset.FLOOR;
            }
        }
    }

    public static void addRoomWithLockedDoor(Coordinate crd, TETile[][] world, Random RANDOM) {
        /* @source https://www.educative.io/answers/how-to-generate-random-numbers-in-java */
        int xLen = 4 + RANDOM.nextInt(5);
        int yLen = 6 + RANDOM.nextInt(5);

        crd.setxLen(xLen);
        crd.setyLen(yLen);


        for (int yIndicator = crd.getY(); yIndicator <= crd.yOffset(yLen); yIndicator++) {
            for (int xIndicator = crd.getX(); xIndicator <= crd.xOffset(xLen); xIndicator++) {
                if (xIndicator == crd.getX() || yIndicator == crd.getY() ||
                        xIndicator == crd.xOffset(xLen) || yIndicator == crd.yOffset(yLen)) {
                    world[xIndicator][yIndicator] = Tileset.WALL;
                } else {
                    world[xIndicator][yIndicator] = Tileset.FLOOR;
                }
            }
        }

        int yOfDoor = crd.getY() + yLen/2 ;
        world[crd.getX()][yOfDoor] = Tileset.LOCKED_DOOR;
    }
}


