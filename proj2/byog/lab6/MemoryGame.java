package byog.lab6;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class MemoryGame {
    private int width;
    private int height;
    private int round;
    private Random rand;
    private boolean gameOver;
    private boolean playerTurn;
    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
                                                   "You got this!", "You're a star!", "Go Bears!",
                                                   "Too easy for you!", "Wow, so impressive!"};

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter a seed");
            return;
        }

        int seed = Integer.parseInt(args[0]);
        MemoryGame game = new MemoryGame(40, 40);
        game.setRand(seed);
        game.startGame();
    }

    public MemoryGame(int width, int height) {
        /* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
         * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
         */
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        StdDraw.clear(Color.BLACK);
        //StdDraw.enableDoubleBuffering();

        //TODO: Initialize random number generator
    }

    public void setRand(int seed) {
        this.rand = new Random(seed);
    }

    public String generateRandomString(int n) {
        //TODO: Generate random string of letters of length n
        char[] randomCharArray = new char[n];
        for (int i = 0; i < n; i++) {
            randomCharArray[i] = CHARACTERS[rand.nextInt(26)];
        }

        return new String(randomCharArray);
    }

    public void drawFrame(String s) {
        //TODO: Take the string and display it in the center of the screen
        StdDraw.clear(Color.BLACK);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.text(20, 20, s);
        //StdDraw.show();


        //TODO: If game is not over, display relevant game information at the top of the screen
    }

    public void flashSequence(String letters) {
        //TODO: Display each character in letters, making sure to blank the screen between letters


        for (int i = 0; i < letters.length(); i++) {
            //StdDraw.text(20, 20, Character.toString(letters.charAt(i)));
            drawFrame(Character.toString(letters.charAt(i)));
            StdDraw.pause(500);
            StdDraw.show();
            StdDraw.pause(1000);
            StdDraw.clear(Color.BLACK);
        }
    }

    public String solicitNCharsInput(int n) {
        //TODO: Read n letters of player input
        drawFrame("Input String in 5s");
        char[] letters = new char[n];


        int xKey = 20;
        int yKey = 15;
        int count = 0;
        for (int i = 0; i < 500; i++) {
            while (n > 0 && StdDraw.hasNextKeyTyped()) {
                letters[count] = StdDraw.nextKeyTyped();
                //StdDraw.text(xKey, yKey, Character.toString(letters[count]));
                drawFrame(new String(letters));
                count++;
                xKey++;
                n--;
            }
            StdDraw.pause(10);
        }
        return new String(letters);
    }

    public void startGame() {
        //TODO: Set any relevant variables before the game starts
        //TODO: Establish Game loop

        round = 3;
        while (round <= 10) {
            String randomString = generateRandomString(round);
            String roundN = "Round " + round + " !";
            drawFrame(roundN);

            StdDraw.pause(3000);

            flashSequence(randomString);

            solicitNCharsInput(round);


            round++;
        }


    }

}
