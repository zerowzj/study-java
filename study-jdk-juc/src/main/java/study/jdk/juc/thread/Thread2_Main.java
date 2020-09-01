package study.jdk.juc.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 演示：
 */
@Slf4j
public class Thread2_Main {

    class Task implements Runnable {

        //共享变量
        private int no;

        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                //临界区
                synchronized (this) {
                    log.info("当前号：{}", ++no);
                }
            }
        }
    }

    void test() {
        Task task = new Task();
        new Thread(task, "一号窗口").start();
        new Thread(task, "二号窗口").start();
        new Thread(task, "三号窗口").start();
    }

    public static void main(String[] args) {
        new Thread2_Main().test();
    }
}
