package flik;
import org.junit.Test;
import static org.junit.Assert.*;


public class FlikTest {
    @Test
    public void sameTest(){
        int a = 128,b=128;
        int c = 8;
        assertTrue(Flik.isSameNumber(a, b));
        assertFalse(Flik.isSameNumber(b,c));
    }
}
