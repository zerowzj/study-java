package study.jvm.memory;

import org.junit.Test;

public class StackTest {

    /**
     * VM options: -Xss 1M
     */
    @Test
    public void sof_test(){
        new StackObject().stackLeak();
    }

    @Test
    public void oom_test(){
        new StackObject().stackLeakByThread();
    }
}
