package study.jvm;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

@Slf4j
public class HashUtils {

    public static String hashCode(Object obj) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        long hashCode = 0;
        for (long index = 7; index > 0; index--) {
            hashCode |= (unsafe.getByte(obj, index) & 0xFF) << ((index - 1) * 8);
        }
        String code = Long.toHexString(hashCode);
        //log.info("util  0x====" + code);
        return code;
    }
}
