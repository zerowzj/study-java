package study.jvm.classloading.initialization;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SonTest {

    //通过子类引用父类的静态字段，不会触发子类初始化
    @Test
    public void test1() {
        log.info("{}", Son.ID);
    }

    @Test
    public void test() {
        new Son();
    }
}
