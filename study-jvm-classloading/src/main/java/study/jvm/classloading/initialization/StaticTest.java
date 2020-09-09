package study.jvm.classloading.initialization;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class StaticTest {

    @Test
    public void setstatic_test() {
        Const.name = "wangzhj";
    }

    @Test
    public void getstatic_test() {
        //       int age = Const.age;
        String id = Const.ID;
    }

    @Test
    public void invokestatic_test() {
        Const.sayHi();
    }
}

