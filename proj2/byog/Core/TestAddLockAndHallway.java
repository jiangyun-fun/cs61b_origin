package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;


import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;


public class TestAddLockAndHallway {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 60;

    //private static final long SEED = 2873122;
    //private static final Random RANDOM = new Random(SEED);
    private static  long SEED;
    private static  Random RANDOM;

    public static void main(String[] args) throws IOException {
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

        Scanner scanner = new Scanner(new File("./test-output-txt.txt"));
        int [] seedAndCoordinate = new int [100];
        int i = 0;
        while(scanner.hasNextInt())
        {
            seedAndCoordinate[i++] = scanner.nextInt();
        }

        PlayWithString string = new PlayWithString(args[0]);
        if (string.isNew()) {
             SEED = string.setSeed();
        } else if (string.isLoad()) {
            SEED = seedAndCoordinate[0];
        }

        final Random RANDOM = new Random(SEED);

        Coordinate firstCrd = new Coordinate(RANDOM.nextInt(5), 27 + RANDOM.nextInt(5));
        Room.addRoomWithLockedDoor(firstCrd, world, RANDOM);

        int xPlayer = firstCrd.getX() + RANDOM.nextInt(firstCrd.getxLen() - 1) + 1;
        int yPlayer = firstCrd.getY() + RANDOM.nextInt(firstCrd.getyLen() - 1) + 1;
        Coordinate player = new Coordinate(xPlayer, yPlayer);
        if (string.isLoad()) {
            player.setX(seedAndCoordinate[1]);
            player.setY(seedAndCoordinate[2]);
        }
        world[player.getX()][player.getY()] = Tileset.PLAYER;



        Coordinate secondCrd = new Coordinate(firstCrd.xOffset(), firstCrd.getY() + RANDOM.nextInt(firstCrd.getyLen() - 1) + 1);
        Hallway.addHawayToRigth(secondCrd, world, RANDOM);

        while (secondCrd.getX() <= 80 && firstCrd.getY() <= 50 && firstCrd.getY() >= 10) {
            firstCrd.setX(secondCrd.xOffset());
            firstCrd.setY(secondCrd.getY());
            Room.addRoom(firstCrd, world, RANDOM);

            secondCrd.setX(firstCrd.xOffset());
            secondCrd.setY(firstCrd.getY() + RANDOM.nextInt(firstCrd.getyLen() - 1) + 1);
            Hallway.addHawayToRigth(secondCrd, world, RANDOM);
        }

        // TODO support playWithString


        string.move(world, player);


        Path path = Paths.get("./test-output-txt.txt");
        String output = String.valueOf(SEED) + " " + String.valueOf(player.getX()) + " " + String.valueOf(player.getY());
        Files.write(path, output.getBytes(StandardCharsets.UTF_8));




        // draws the world to the screen
        ter.renderFrame(world);

    }
}
