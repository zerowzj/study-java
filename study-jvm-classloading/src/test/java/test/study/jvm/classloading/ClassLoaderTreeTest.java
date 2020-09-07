package test.study.jvm.classloading;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ClassLoaderTreeTest {

    @Test
    public void test(){
        ClassLoader loader = ClassLoaderTreeTest.class.getClassLoader();
        while (loader != null) {
            log.info(">>>>>> {}", loader.toString());
            loader = loader.getParent();
        }
    }
}
