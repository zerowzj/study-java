
package study.jdk.juc.thread.state;

import lombok.extern.slf4j.Slf4j;

/**
 * （1）线程状态：NEW
 */
@Slf4j
public class NewMain {

    public static void main(String[] args) {
        new NewMain().test1();
    }

    private void test1() {
        Thread t = new Thread(() -> {
            log.info("i am t thread");
        });
        log.info("after new(), state= {}", t.getState().name());
    }
}
