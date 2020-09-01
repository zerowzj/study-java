
package study.jdk.juc.thread.state;

import lombok.extern.slf4j.Slf4j;

/**
 * （1）线程状态：RUNNABLE
 */
@Slf4j
public class RunnableMain {

    public static void main(String[] args) {
        new RunnableMain().test1();
    }

    private void test1() {
        Thread t = new Thread(() -> {
            log.info("i am t thread");
        });
        t.start();
        log.info("after start(), state= {}", t.getState().name());
    }
}
