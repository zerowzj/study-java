package study.jvm.object;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.vm.VM;

@Slf4j
public class JvmTest {

    @Test
    public void detail_test(){
        log.info(VM.current().details());
    }
}
