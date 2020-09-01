package study.jdk.juc.thread.exception;


import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    static int PROCESSOR = Runtime.getRuntime().availableProcessors();

    class Task {
        public void doTask() {
            log.info("{} start", Thread.currentThread().getName());
            long start = System.currentTimeMillis();
            while (true) {
                double d = Math.tan(Math.atan(Math.atan(Math.atan(Math.atan(Math.atan(123456789.123456789))))));
                Math.cbrt(d);
                long end = System.currentTimeMillis();
                if (end - start > 50000) {
                    log.info("{} cost {} ms", Thread.currentThread().getName(), (System.currentTimeMillis() - start));
                    break;
                }
            }
            log.info("{} finish", Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Stopwatch stopWatch = Stopwatch.createStarted();
        int task = PROCESSOR + 2;
        CountDownLatch latch = new CountDownLatch(task);
        List<Thread> tLt = new ArrayList();
        for (int i = 0; i < task; i++) {
            tLt.add(new Thread(() -> {
                new Main().new Task().doTask();
                latch.countDown();
            }));
        }

        log.info("{}, {}", PROCESSOR, tLt.size());
        tLt.forEach(t -> {
            t.start();
        });

        try {
            latch.await();
        } catch (InterruptedException ex) {
        }
        log.info("{} s", stopWatch.elapsed(TimeUnit.SECONDS));
    }
}
