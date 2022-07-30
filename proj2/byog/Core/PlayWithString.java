package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class PlayWithString {
    private String input;
    private char firstChar;
    private int seedLen = 0;

    PlayWithString(String arg0) {
        this.input = arg0;
        firstChar = input.charAt(0);
    }

    public boolean isNew() {
        return this.firstChar == 'n' || this.firstChar == 'N';
    }

    public boolean isLoad() {
        return this.firstChar == 'l' || this.firstChar == 'L';
    }

    public long setSeed() {
        int[] seedArray = new int[20];
        long seed = 0;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == 's' || input.charAt(i) == 'S') {
                break;
            }
            seedArray[i-1] = Character.getNumericValue(input.charAt(i));
            seedLen += 1;
        }
        for (int i = 0; i < seedLen; i++) {
            seed = seed + seedArray[i] * (long)Math.pow(10, seedLen - 1 - i);
        }
        return seed;
    }

    public void move(TETile[][] world, Coordinate player) {
        String inputRemainder;
         if (isNew()) {
             inputRemainder = input.substring(seedLen + 2);
         } else if (isLoad()) {
             inputRemainder = input.substring(1);
         } else {
             inputRemainder = input;
         }
        int strLen = inputRemainder.length();
        for (int i = 0; i < strLen; i++) {
            char chr = inputRemainder.charAt(i);
            if (chr == ':' && inputRemainder.charAt(i+1) == 'q') {
                break;
            }

            switch (chr) {
                case 'a': if (!world[player.getX() - 1][player.getY()].equals(Tileset.WALL)) {
                    world[player.getX()][player.getY()] = Tileset.FLOOR;
                    player.setX(player.getX() - 1);
                    world[player.getX()][player.getY()] = Tileset.PLAYER;
                }
                    break;
                case 'd': if (!world[player.getX() + 1][player.getY()].equals(Tileset.WALL)) {
                    world[player.getX()][player.getY()] = Tileset.FLOOR;
                    player.setX(player.getX() + 1);
                    world[player.getX()][player.getY()] = Tileset.PLAYER;
                }
                    break;
                case 's': if (!world[player.getX()][player.getY() - 1].equals(Tileset.WALL)) {
                    world[player.getX()][player.getY()] = Tileset.FLOOR;
                    player.setY(player.getY() - 1);
                    world[player.getX()][player.getY()] = Tileset.PLAYER;
                }
                    break;
                case 'w': if (!world[player.getX()][player.getY() + 1].equals(Tileset.WALL)) {
                    world[player.getX()][player.getY()] = Tileset.FLOOR;
                    player.setY(player.getY() + 1);
                    world[player.getX()][player.getY()] = Tileset.PLAYER;
                }
                    break;
                default:
            }
        }
    }

}
