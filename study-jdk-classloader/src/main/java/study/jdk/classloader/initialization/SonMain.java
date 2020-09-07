package study.jdk.classloader.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SonMain extends Father {

    static {
        log.info(">>>>>> son init");
    }

    public SonMain() {
        log.info(">>>>>> son constructor");
    }

    public static void main(String[] args) {
        SonMain son = new SonMain();
    }
}
