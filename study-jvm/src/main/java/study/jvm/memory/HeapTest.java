package study.jvm.memory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import study.jvm.object.Obj;

@Slf4j
public class HeapTest {

    @Test
    public void obj_test() throws Exception {
        Obj obj = new Obj();
        GraphLayout.parseInstance("ABC").toImage("d:\\t.jpg");
//        log.info(str);
    }
}
