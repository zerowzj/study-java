package study.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOMTest {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> data = new ArrayList<>();
        while (true) {
            data.add(new OOMObject());
        }
    }
}
