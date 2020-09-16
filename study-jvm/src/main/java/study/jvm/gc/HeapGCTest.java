package study.jvm.gc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import study.jvm.memory.HeapObject;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HeapGCTest {

    /**
     * VM options：-Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError
     */
    @Test
    public void oom_test() {
        List<HeapObject> data = new ArrayList<>();
        while (true) {
            data.add(new HeapObject());
        }
    }
}
