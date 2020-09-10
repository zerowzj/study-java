package study.jvm.object;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.layouters.HotSpotLayouter;

@Slf4j
public class ObjTest {

    @Test
    public void object_test() {
        Obj obj = new Obj();
        ClassLayout classLayout = ClassLayout.parseInstance(obj);
        long headSize = classLayout.headerSize();

        log.info("head_size= {}", headSize);
        log.info("{}", classLayout.toPrintable());
    }

    @Test
    public void array_test() {
        Obj[] objArr = {new Obj(), new Obj(), new Obj()};
        ClassLayout classLayout = ClassLayout.parseInstance(objArr);
        long headSize = classLayout.headerSize();

        log.info("head_size= {}", headSize);
        log.info("{}", classLayout.toPrintable());
    }
}
