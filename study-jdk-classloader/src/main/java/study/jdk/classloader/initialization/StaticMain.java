package study.jdk.classloader.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticMain {

    public static String name;

    public static int age;

//    public static final

    static {
        log.info(">>>>>> StaticMain init");
    }

    public StaticMain(){
        log.info(">>>>>> StaticMain");
    }

    public static void main(String[] args) {
//       String str =  StaticMain.name;
    }
}

