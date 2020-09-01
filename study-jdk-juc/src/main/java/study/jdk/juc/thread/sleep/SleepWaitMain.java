package study.jdk.juc.thread.sleep;

import lombok.extern.slf4j.Slf4j;
import study.jdk.juc.Sleeps;

/**
 * （1）wait()与sleep()区别：两者都不消耗cpu时间片；前者释放锁，后者不释放锁
 */
@Slf4j
public class SleepWaitMain {

    public static void main(String[] args) {
        new SleepWaitMain().test1();
//        new SleepWaitMain().test2();
    }

    public void test1() {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                log.info("i am thread t1");
                //不释放锁，t2阻塞于锁lock无法获取
                Sleeps.deep();
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                log.info("i am thread t2");
            }
        });

        //t1执行后，sleep 1s保证其获取锁
        t1.start();
        Sleeps.seconds(1);
        t2.start();
    }

    public void test2() {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    log.info("i am thread t1");
                    //t1释放锁，t2获取锁并执行
                    lock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                log.info("i am thread t2");
            }
        });

        t1.start();
        Sleeps.seconds(1);
        t2.start();
    }
}
