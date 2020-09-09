package study.jvm.classloading.loading;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class MyClassLoader extends ClassLoader {

    private String classpath;

    public MyClassLoader(String classpath) {
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }
        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            InputStream ins = new FileInputStream(path);

            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return baos.toByteArray();
    }

    private String classNameToPath(String className) {
        return "" + File.separatorChar+ className.replace('.', File.separatorChar) + ".class";
    }
}
