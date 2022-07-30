package byog.Core;


import java.util.Random;

public class TestPlayWithString {
    private static long SEED;
    private static Random RANDOM;

    public void setSEED(long SEED) {
        this.SEED = SEED;
    }

    public void setRANDOM(Random RANDOM) {
        this.RANDOM = RANDOM;
    }

    public static void main(String[] args) {

        PlayWithString string = new PlayWithString(args[0]);

        if (string.isNew()) {
            SEED = string.setSeed();
        }
        final Random RANDOM = new Random(SEED);

        System.out.println("seed is " + SEED);


    }
}
