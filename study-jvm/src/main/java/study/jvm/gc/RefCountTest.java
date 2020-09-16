package study.jvm.gc;

import org.junit.Test;

public class RefCountTest {

    private static final int _1MB = 1024 * 1024;

    public Object instance = null;

    private byte[] bigSize = new byte[2 * _1MB];

    /**
     * VM options: -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
     */
    @Test
    public void test(){
        RefCountTest objA  = new RefCountTest();
        RefCountTest objB  = new RefCountTest();

        objA.instance = objB;
        objB.instance = objA;

        System.gc();
    }
}
