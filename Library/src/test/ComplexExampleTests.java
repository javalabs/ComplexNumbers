import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


/**
 * Created by Yegorov Artem <yegorov0725@yandex.ru>
 */
public class ComplexExampleTests {
    @Test
    public void test1() {
        assertEquals(true, true);
    }

    @Test
    public void test2() {
        org.junit.Assert.assertTrue(true);
    }

    @Test
    public void test3() {
        assertEquals(9.2, 9.200001, 0.01);
    }
}
