package study.jdk.classload.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    static {
        log.info(">>>>>> Main init");
    }

    public Main(){
        log.info(">>>>>> Main constructor");
    }

    public static void main(String[] args) {
    }
}
