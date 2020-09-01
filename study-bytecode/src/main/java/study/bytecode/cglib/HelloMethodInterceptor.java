package study.bytecode.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class HelloMethodInterceptor implements MethodInterceptor {

    public Object intercept(Object sub, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        log.info("advice start");
        log.info("{}", method.getName());
        Object result = methodProxy.invokeSuper(sub, args);
        log.info("advice end");
        return result;
    }
}
