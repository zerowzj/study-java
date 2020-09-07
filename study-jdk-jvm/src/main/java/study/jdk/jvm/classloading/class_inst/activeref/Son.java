package study.jdk.jvm.classloading.class_inst.activeref;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Son  extends Father{

    static {
        log.info("Son static initialization");
    }
}
