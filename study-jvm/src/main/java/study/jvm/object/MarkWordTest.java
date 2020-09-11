package study.jvm.object;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class MarkWordTest {

    //无锁
    @Test
    public void test() {
        Obj obj = new Obj();
        log.info(ClassLayout.parseInstance(obj).toPrintable());

        obj.hashCode();
        log.info(ClassLayout.parseInstance(obj).toPrintable());
    }

    //偏向锁
    @Test
    public void biasedLock_test() {
        Obj obj = new Obj();
        log.info(ClassLayout.parseInstance(obj).toPrintable());

        synchronized (obj) {
            log.info(ClassLayout.parseInstance(obj).toPrintable());
        }
    }

    //轻量级锁
    @Test
    public void light_test() {
        Obj obj = new Obj();
        log.info(ClassLayout.parseInstance(obj).toPrintable());

        synchronized (obj) {
            log.info(ClassLayout.parseInstance(obj).toPrintable());
        }
    }

    //级锁
    @Test
    public void heavy_test() {
        Obj obj = new Obj();
        log.info(ClassLayout.parseInstance(obj).toPrintable());

        log.info(ClassLayout.parseInstance(obj).toPrintable());
//        synchronized (obj) {
//            layout = ClassLayout.parseInstance(obj)
//                    .toPrintable();
//            log.info(layout);
//        }
    }
}
