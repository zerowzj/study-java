package study.jvm.memory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PermTest {

    /**
     * VM options: -XX:MaxMetaspaceSize=512K
     */
    @Test
    public void oom_test() {
        List<String> data = new ArrayList<>();
        int i = 0;
        while (true) {
            data.add(String.valueOf(i++).intern());
        }
    }
}
