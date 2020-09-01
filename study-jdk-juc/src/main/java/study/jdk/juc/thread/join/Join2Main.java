package study.jdk.juc.thread.join;

import lombok.extern.slf4j.Slf4j;
import study.jdk.juc.Sleeps;

/**
 * （1）join()控制线程执行顺序
 */
@Slf4j
public class Join2Main {

    class MyThread extends Thread {

        private Thread t;

        MyThread(Thread t) {
            this.t = t;
        }

        @Override
        public void run() {
            try {
                t.join();
                log.info("i am thread t3");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void test() {
        Thread t1 = new Thread(() -> {
            log.info("i am thread t1 start");
            Sleeps.seconds(5);
            log.info("i am thread t1 end");
        });
        Thread t2 = new Thread(() -> {
            log.info("i am thread t2");
        });
        //t3必须等t1执行完才可执行，即t1阻塞了t3
        Thread t3 = new MyThread(t1);

        t3.start();
        t2.start();
        t1.start();
    }

    public static void main(String[] args) {
        new Join2Main().test();
    }
}
