package study.jdk.juc.thread.join;

import lombok.extern.slf4j.Slf4j;
import study.jdk.juc.Sleeps;

/**
 * （1）join()使用
 */
@Slf4j
public class Join1Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Sleeps.seconds(2);
            log.info("i am thread t1");
        });
        Thread t2 = new Thread(() -> {
            try {
                //阻塞调用线程（主线程或父线程都不准确）
                t1.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            log.info("i am thread t2");
        });
        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        log.info("i am thread main");
    }
}
