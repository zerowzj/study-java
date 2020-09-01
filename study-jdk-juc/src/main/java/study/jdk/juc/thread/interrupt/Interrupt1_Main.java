package study.jdk.juc.thread.interrupt;

import lombok.extern.slf4j.Slf4j;
import study.jdk.juc.Sleeps;

/**
 * （1）中断
 */
@Slf4j
public class Interrupt1_Main {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            try {
                synchronized (lock) {
                    log.info("i am thread t, wait");
                    lock.wait();
                }
            } catch (InterruptedException ex) {
                log.info("i am interrupted");
            }
            log.info("after interrupt");
        });
        t.start();

        Sleeps.seconds(5);
        t.interrupt();
        log.info("interrupt over");
    }
}
