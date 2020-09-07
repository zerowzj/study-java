package study.jdk.jvm.classloading.class_inst.activeref;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Father {

    static String name;

    static {
        log.info("Father static initialization");
    }

    public static void sayHi() {
        log.info("father say hi");
    }
}
