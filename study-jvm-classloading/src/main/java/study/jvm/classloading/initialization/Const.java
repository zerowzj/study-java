package study.jvm.classloading.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Const {

    public static final String ID = "100001";

    public static String name;

    public static int age;

    static {
        log.info("Const init");
    }

    public static void sayHi(){
        log.info("hello");
    }
}
