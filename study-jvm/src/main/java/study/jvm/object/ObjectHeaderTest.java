package study.jvm.object;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class ObjectHeaderTest {

    public Object lock = new Object();

    @Test
    public void obj_test() {
        String str = ClassLayout.parseInstance(lock)
                .toPrintable();
        log.info(str);
        synchronized (lock) {
            str = ClassLayout.parseInstance(lock)
                    .toPrintable();
            log.info(str);
        }

        str = ClassLayout.parseInstance(lock)
                .toPrintable();
        log.info(str);
    }

    @Test
    public void array_test() {
        Obj[] array = new Obj[]{new Obj(), new Obj()};
        String str = ClassLayout.parseInstance(array).toPrintable();
        log.info(str);
    }

    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        Obj obj = new Obj();
        log.info(ClassLayout.parseInstance(obj).toPrintable());
    }
}
