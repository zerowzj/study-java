package study.jdk.juc.thread.future;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import study.jdk.juc.Sleeps;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 演示：返回值的异步执行
 */
@Slf4j
public class Runnable1_Main {

    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
         FutureTask<Integer> task1 = new FutureTask(() -> {
            Sleeps.seconds(3);
            log.info("i am task1");
        }, 21);
        FutureTask<Integer> task2 = new FutureTask(() -> {
            Sleeps.seconds(10);
            log.info("i am task2");
        }, 31);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();

        try {
            //（★）get方法阻塞
            Integer sum = task1.get() + task2.get();
            log.info("sum= {}, cost time= {} ms", sum, stopwatch.elapsed(TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        log.info("main thread end");
    }
}
