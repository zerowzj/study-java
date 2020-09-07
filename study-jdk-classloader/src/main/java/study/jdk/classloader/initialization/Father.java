package study.jdk.classloader.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Father {

    static {
        log.info(">>>>>> father init");
    }

    public Father() {
        log.info(">>>>>> father constructor");
    }

}
