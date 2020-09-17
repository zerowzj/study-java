package study.jvm.vmoptions;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import study.jvm.memory.HeapObject;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HeapOptionsTest {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM options：
     * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -Xms30M -Xmx30M -Xmn10M -XX:+PrintGCDetails
     *
     * -Xms20M -Xmx20M -XX:NewRatio=1 -XX:+PrintGCDetails
     * -Xms40M -Xmx40M -XX:NewRatio=1 -XX:+PrintGCDetails
     *
     * -Xms40M -Xmx40M -Xmn10M -XX:SurvivorRatio=3 -XX:+PrintGCDetails
     *
     * -Xms40M -Xmx40M -Xmn10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath
     */
    @Test
    public void gc_test() {
        List<HeapObject> data = new ArrayList<>();

        int count = 50;
        for (int i = 0; i < count; i++) {
            data.add(new HeapObject());
        }
    }

    /**
     * 对象优先在Eden区分配
     * VM options：
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
     */
    @Test
    public void test() {
        byte[] b1, b2, b3, b4;
        b1 = new byte[2 * _1MB];
        //b2 = new byte[2 * _1MB];
        //b3 = new byte[2 * _1MB];

        //出现一次minor GC
        // b4 = new byte[4 * _1MB];
    }

    /**
     * 大对象直接进入老年代
     * VM options：
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:PretenureSizeThreshold=6145728
     */
    @Test
    public void PretenureSizeThreshold_test() {
        byte[] b = new byte[4 * _1MB];
        byte[] b2 = new byte[4 * _1MB];
        byte[] b3 = new byte[3 * _1MB];
        //System.gc();
    }
}
