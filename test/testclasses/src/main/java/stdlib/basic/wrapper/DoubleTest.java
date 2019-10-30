package stdlib.basic.wrapper;

import helper.UnitTestRunner;
import static helper.MyAssert.*;

public class DoubleTest {
    
    public static void main(String[] args) {
        UnitTestRunner.run(DoubleTest.class);
    }
    
//    @Test
    public void doubleToRawLongBits() {
        assertEquals(4614253070214989087L, Double.doubleToRawLongBits(3.14));
    }
    
//    @Test
    public void longBitsToDouble() {
//        assertEquals(3.14, Double.longBitsToDouble(4614253070214989087L), 0);
    }
    
}
