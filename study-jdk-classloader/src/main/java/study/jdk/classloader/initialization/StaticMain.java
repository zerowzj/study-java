package study.jdk.classloader.initialization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticMain {


    public static final String ID = "100001";

    public static String name;

    public static int age;


    static {
        log.info(">>>>>> StaticMain init");
    }

    public StaticMain(){
        log.info(">>>>>> StaticMain constructor");
    }

    public static void sayHi(){
        log.info("hello");
    }

    public static void main(String[] args) {
        //setstatic
//       StaticMain.name = "wangzhj";

       //getstatic
//       int age = StaticMain.age;
//        String id = StaticMain.ID;
        //invokestatic
        StaticMain.sayHi();

    }
}

