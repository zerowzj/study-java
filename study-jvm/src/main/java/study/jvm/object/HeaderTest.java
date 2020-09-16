package study.jvm.object;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;


@Slf4j
public class HeaderTest {

    /**
     * 关闭指针压缩：-XX:-UseCompressedOops
     */
    @Test
    public void test() {
        Obj obj = new Obj();
        ClassLayout classLayout = ClassLayout.parseInstance(obj);

        System.out.println(classLayout.toPrintable());
        log.info(">>>>>> header_size= {}bytes", classLayout.headerSize());
    }
}
