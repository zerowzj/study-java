package study.jvm.classloading.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Son extends Father {

    static {
        log.info(">>>>>> Son init");
    }

    public Son() {
        log.info(">>>>>> Son constructor");
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}
