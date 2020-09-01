package study.jdk.juc.thread.state;

import study.jdk.juc.Sleeps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * （1）线程状态：BLOCKED
 */
public class BlockedMain {

    public static void main(String[] args) {
        new BlockedMain().test2();
    }

    public void test1() {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                Sleeps.deep();
            }
        }, "t1");
        t1.interrupt();
        t1.isInterrupted();
        Thread.interrupted();
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
            }
        }, "t2");

        //t1持有锁，t2阻塞于锁lock
        t1.start();
        t2.start();
    }

    /**
     *
     */
    public void test2() {
        Object lock = new Object();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        int taskNum = 5;
        for (int i = 0; i < taskNum; i++) {
            pool.execute(() -> {
                synchronized (lock) {
                    Sleeps.seconds(5);
                }
            });
        }
    }
}
