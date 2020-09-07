package study.jdk.jvm.classloading.class_inst.activeref;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ActiveRefTest {

    static {
        log.info("ActiveRefTest static initialization");
    }


    //（1）
    public static void main(String[] args) {

    }

    //（3）
    @Test
    public void extend_test() {
        new Son();
    }

    //（4）
    @Test
    public void reflect_test() {

    }

    //（2）new
    @Test
    public void new_test() {
        new Father();
    }

    //getstatic
    @Test
    public void getstatic_test() {
        String name = Father.name;
    }

    //putstatic
    @Test
    public void putstatic_test() {
        Father.name = "fadsfasd";
    }

    //nvokestatic
    @Test
    public void invokestatic_test() {
        Father.sayHi();
    }

}
