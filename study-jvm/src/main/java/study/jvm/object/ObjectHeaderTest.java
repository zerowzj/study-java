package study.jvm.object;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class ObjectHeaderTest {

    @Test
    public void obj_test() {
        Obj obj = new Obj();
        String str = ClassLayout.parseInstance("ABC").toPrintable();
        log.info(str);
    }

    @Test
    public void array_test() {
        Obj[] array = new Obj[]{new Obj(), new Obj(), new Obj()};
        String str = ClassLayout.parseInstance(array).toPrintable();
        log.info(str);
    }
}
