package study.jdk.juc.thread.interrupt;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.jdk.juc.Sleeps;

/**
 * 演示：中断普通方法
 */
@Slf4j
public class Interrupt2_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                log.info("loop");
            }
        });
        t.start();

        Sleeps.seconds(2);
        log.info("before interrupt= {}", t.isInterrupted());
        t.interrupt();
        log.info(" after interrupt= {}", t.isInterrupted());
    }
}
