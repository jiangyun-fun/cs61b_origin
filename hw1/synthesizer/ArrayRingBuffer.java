package synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {

        first = 0;
        last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
        rb = (T []) new Object[capacity];
    }

    public void lastPlusOne() {
        if (last == capacity - 1) {
            last = 0;
        } else {
            last++;
        }
    }

    public void firstPlusOne() {
        if (first == capacity - 1) {
            first = 0;
        } else {
            first++;
        }
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // DO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        fillCount++;
        lastPlusOne();
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // DO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T deElement = (T) rb[first];
        firstPlusOne();
        fillCount--;
        return deElement;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }



    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        return rb[first];
    }

    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int count;
        private int wizPos;

        ArrayRingBufferIterator() {
            count = 0;
        }

        public boolean hasNext() {
            return count < fillCount;
        }

        public T next() {
            T returnItem = rb[wizPos];
            count += 1;
            wizPos = nextWizPos(wizPos);
            return returnItem;
        }

        public int nextWizPos(int wizPos) {
            if (wizPos == capacity - 1) {
                wizPos = 0;
            } else {
                wizPos++;
            }
            return wizPos;
        }
    }
}
