import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooTest {

    @Test
    @DisplayName("Bar test for pipeline testing purpose")
    public void bar() {
        boolean a = true;
        boolean b = true;
        assertEquals(a, b, "A is not equals to B");
    }
}
