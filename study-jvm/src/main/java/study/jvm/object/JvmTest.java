package study.jvm.object;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.vm.VM;

@Slf4j
public class JvmTest {

    @Test
    public void detail_test(){
        System.out.println(VM.current().details());
        log.info("header_size= {}bytes", VM.current().objectHeaderSize());
    }
}
