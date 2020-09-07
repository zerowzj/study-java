package study.jvm.memory;

import org.junit.Test;

public class StackTest {


    @Test
    public void oom_test(){
        new StackTest().f();
    }

    public void f(){
        String str = new String();
        f();
    }
}
