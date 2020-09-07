package study.jdk.classloader.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    static {
        log.info(">>>>>> main");
    }

    public Main(){
        log.info(">>>>>> constructor");
    }

    public static void main(String[] args) {

    }
}
