package test.study.bytecode.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;
import study.bytecode.cglib.proxy.HelloImpl;
import study.bytecode.cglib.proxy.HelloMethodInterceptor;

public class HelloTest {

    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloImpl.class);
        enhancer.setCallback(new HelloMethodInterceptor());

        HelloImpl hello = (HelloImpl) enhancer.create();
        hello.sayHi();
    }
}
