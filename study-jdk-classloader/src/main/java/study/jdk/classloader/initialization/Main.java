package study.jdk.classloader.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    static {
        log.info(">>>>>> main init");
    }

    public Main(){
        log.info(">>>>>> main constructor");
    }

    public static void main(String[] args) {
    }
}
