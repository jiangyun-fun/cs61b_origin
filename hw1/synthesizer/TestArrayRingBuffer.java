package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testArrayRingBuffer() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        assertEquals(arb.capacity(),10);
        assertTrue(arb.isEmpty());
    }

    public void testEnqueue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(3);
        arb.enqueue(11);
        assertEquals(arb.fillCount,1);
        arb.enqueue(22);
        arb.enqueue(33);
        assertTrue(arb.isFull());
    }

    public void testDequeue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(3);
        arb.enqueue(11);
        arb.enqueue(22);
        arb.enqueue(33);
        assertEquals(11, arb.dequeue());
        assertEquals(22,arb.dequeue());
        assertEquals(33,arb.dequeue());
        assertTrue(arb.isEmpty());
        arb.enqueue(44);
        arb.enqueue(55);
        arb.enqueue(66);
        assertTrue(arb.isFull());
    }

    public void testPeek() {
        ArrayRingBuffer arb = new ArrayRingBuffer(3);
        arb.enqueue(11);
        assertEquals(11, arb.peek());
        arb.enqueue(22);
        arb.enqueue(33);
        assertEquals(11, arb.dequeue());
        assertEquals(22, arb.peek());
        assertEquals(22,arb.dequeue());
        assertEquals(33,arb.dequeue());
        assertTrue(arb.isEmpty());
        arb.enqueue(44);
        assertEquals(44, arb.peek());
        arb.enqueue(55);
        arb.enqueue(66);
        assertEquals(66, arb.peek());
        assertTrue(arb.isFull());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
