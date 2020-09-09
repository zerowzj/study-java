package study.jvm.classloading.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Father {

    public static String ID = "100001";

    static {
        log.info(">>>>>> Father init");
    }

    public Father() {
        log.info(">>>>>> Father constructor");
    }
}
