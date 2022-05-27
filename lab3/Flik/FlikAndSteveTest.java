import static org.junit.Assert.*;
import org.junit.Test;

public class FlikAndSteveTest {

    @Test
    public void testFlik() {
        Integer a = 129;
        Integer b = 2;
        Integer c = 129;

        assertTrue(Flik.isSameNumber(a, c));
        assertFalse("hello",Flik.isSameNumber(a, b));
    }

}
