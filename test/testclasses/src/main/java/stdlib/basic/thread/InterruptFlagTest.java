package stdlib.basic.thread;

import helper.UnitTestRunner;
import static helper.MyAssert.*;

public class InterruptFlagTest {
    
    public static void main(String[] args) {
        UnitTestRunner.run(InterruptFlagTest.class);
    }
    
//    @Test
    public void interruptFlag() {
        Thread t = Thread.currentThread();
        assertFalse(t.isInterrupted());
        
        t.interrupt();
        assertTrue(t.isInterrupted());
        assertTrue(t.isInterrupted());
        
        assertTrue(Thread.interrupted());
        assertFalse(Thread.interrupted());
        assertFalse(t.isInterrupted());
    }
    
}
