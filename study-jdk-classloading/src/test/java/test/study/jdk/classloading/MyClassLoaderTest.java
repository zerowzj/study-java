package test.study.jdk.classloading;

import org.junit.Test;
import study.jdk.classloading.loading.MyClassLoader;

import java.lang.reflect.Method;

public class MyClassLoaderTest {

    @Test
    public void test(){
        String classDataRootPath = "C:\\workspace\\Classloader\\classData";
        MyClassLoader fscl1 = new MyClassLoader(classDataRootPath);
        MyClassLoader fscl2 = new MyClassLoader(classDataRootPath);
        String className = "com.example.Sample";
        try {
            Class<?> class1 = fscl1.loadClass(className);
            Object obj1 = class1.newInstance();
            Class<?> class2 = fscl2.loadClass(className);
            Object obj2 = class2.newInstance();
            Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
