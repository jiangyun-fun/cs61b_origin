package byog.lab6;


import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.Random;

public class TestStdDraw {

    private int round;
    private Random rand;
    private boolean gameOver;
    private boolean playerTurn;
    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
            "You got this!", "You're a star!", "Go Bears!",
            "Too easy for you!", "Wow, so impressive!"};

    public static void main(String[] args) {
         int width  = 80;
         int height = 40;

        StdDraw.setCanvasSize(width * 16, height * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.clear(Color.BLACK);
        //StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.WHITE);

        String text = "Hello";
        for (int i = 0; i < text.length(); i++) {
            StdDraw.text(40, 20, Character.toString(text.charAt(i)));
            StdDraw.show();
            StdDraw.pause(1000);
            StdDraw.clear(Color.BLACK);
            StdDraw.pause(500);
        }

        StdDraw.text(40, 20, "Input String in 10s");


        int xKey = 40;
        int yKey = 15;
        for (int i = 0; i < 1000; i++) {
            while (StdDraw.hasNextKeyTyped()) {
                StdDraw.text(xKey, yKey, Character.toString(StdDraw.nextKeyTyped()));
                xKey++;
            }
            StdDraw.pause(10);
        }



    }
}
