package study.jdk.classload.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SonMain extends Father {

    static {
        log.info(">>>>>> Son init");
    }

    public SonMain() {
        log.info(">>>>>> Son constructor");
    }

    public static void main(String[] args) {
        SonMain son = new SonMain();
    }
}
