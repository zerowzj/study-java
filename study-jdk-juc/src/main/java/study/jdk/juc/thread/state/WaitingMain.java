package study.jdk.juc.thread.state;

import lombok.extern.slf4j.Slf4j;
import study.jdk.juc.Sleeps;

import java.util.concurrent.locks.LockSupport;

/**
 * （1）线程状态：WAITING
 * （2）jps jstack
 */
@Slf4j
public class WaitingMain {

    public static void main(String[] args) {
//        new WaitingMain().waitTest();
        new WaitingMain().joinTest();
    }

    public void waitTest() {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (Exception ex) {
                }
            }
        }, "t");
        t.start();
    }

    public void joinTest() {
        Thread t1 = new Thread(() -> {
            Sleeps.seconds(Integer.MAX_VALUE);
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException ex) {
            }
            log.info("");
        }, "t2");
        t1.start();
        t2.start();
    }

    public void parkTest() {
        Thread t = new Thread(() -> {
            LockSupport.park();
        }, "t");
        t.start();
    }
}
