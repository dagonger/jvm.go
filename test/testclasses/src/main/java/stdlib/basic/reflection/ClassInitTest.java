package stdlib.basic.reflection;

import helper.UnitTestRunner;
import static helper.MyAssert.*;

public class ClassInitTest {
    
    static class A {
        public static int a = 100;
    }
    
    public static void main(String[] args) {
        UnitTestRunner.run(ClassInitTest.class);
    }
    
//    @Test
    public void getStatic() throws Exception {
        assertEquals(100, A.class.getField("a").get(null));
    }
    
}
