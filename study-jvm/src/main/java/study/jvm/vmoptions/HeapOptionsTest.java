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
     * VM options：
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
     */
    @Test
    public void test() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        //allocation3 = new byte[2 * _1MB];
        //allocation4 = new byte[2 * _1MB];
        //出现一次minor GC
        //allocation4 = new byte[4 * _1MB];
    }
}
