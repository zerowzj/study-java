package study.jvm.vmoptions;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import study.jvm.memory.HeapObject;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HeapOptionsTest {

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
}
