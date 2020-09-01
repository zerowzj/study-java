package study.jdk.juc.thread.interrupt;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.jdk.juc.Sleeps;

import java.util.concurrent.TimeUnit;

/**
 * 演示：中断阻塞方法
 */
@Slf4j
public class Interrupt3_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                log.info("middle interrupt= {}", Thread.currentThread().isInterrupted());
            }
        });
        t.start();

        log.info("before interrupt= {}", t.isInterrupted());
        Sleeps.seconds(1);
        t.interrupt();
//        Sleeps.seconds(1);
        log.info(" after interrupt= {}", t.isInterrupted());
    }
}
