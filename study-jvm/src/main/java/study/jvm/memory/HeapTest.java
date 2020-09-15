package study.jvm.memory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HeapTest {

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
