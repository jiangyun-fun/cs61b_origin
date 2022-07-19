// DO: Make sure to make this class a part of the synthesizer package
package synthesizer;

//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // DO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // DO: Dequeue everything in the buffer, and replace it with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }

        int capacity = buffer.capacity();

        double[] items = new  double[capacity];
        for (int i = 0; i < capacity; i++) {
            items[i] = -1;
        }
        int lastElementPosition = 0;

        while (!buffer.isFull()) {
            double r = Math.random() - 0.5;
            int i = 0;
            for (; i < capacity; i ++) {
                if (Math.abs(r - items[i]) <= 1e-10) {      // 1e-3 is too big.
                    break;
                }
            }

            if (i >= capacity - 1) {
                items[lastElementPosition] = r;
                buffer.enqueue(r);
                lastElementPosition++;
            }
        }

    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        double deElement = buffer.dequeue();
        double enElement = DECAY * 0.5 * (deElement + buffer.peek());
        buffer.enqueue(enElement);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // DO: Return the correct thing.
        return buffer.peek();
    }

    /*
    public static void main(String[] args) {
        GuitarString demoGS = new GuitarString(13200.0);
        System.out.println(demoGS.buffer.peek());
        demoGS.pluck();
        while (!demoGS.buffer.isEmpty()) {
            System.out.println(demoGS.buffer.dequeue());
        }
        System.out.println(demoGS.buffer.capacity());
    }
    */

}
