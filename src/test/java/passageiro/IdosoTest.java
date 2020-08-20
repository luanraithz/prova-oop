package passageiro;

import furb.passageiro.Idoso;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IdosoTest extends TestCase {

    @Test
    public void TestIdosoException() {
        try {
            new Idoso("123", "123123", 43, "123");
            fail();
        } catch (Exception ignored) { }
    }

    @Test
    public void TestIdosoHappyWay() {
        try {
            new Idoso("123", "123123", 61, "123");
        } catch (Exception ignored) {
            fail();
        }
    }

}
