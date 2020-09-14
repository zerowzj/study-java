package study.jvm.object;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * 关闭指针压缩：-XX:-UseCompressedOops
 */
@Slf4j
public class MarkWordTest {

    //无锁
    @Test
    public void noLock_test() {
        Obj obj = new Obj();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        String hashCode = Integer.toHexString(obj.hashCode());
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        log.info("hash_code= {}", hashCode);
    }

    //偏向锁
    @Test
    public void biasedLock_test() {
        Obj obj = new Obj();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

//        synchronized (obj) {
//            log.info(ClassLayout.parseInstance(obj).toPrintable());
//        }
    }

    //轻量级锁
    @Test
    public void lightLock_test() {
        Obj obj = new Obj();
        log.info(ClassLayout.parseInstance(obj).toPrintable());

        synchronized (obj) {
            log.info(ClassLayout.parseInstance(obj).toPrintable());
        }
    }

    //重量级锁
    @Test
    public void heavyLock_test() {
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
