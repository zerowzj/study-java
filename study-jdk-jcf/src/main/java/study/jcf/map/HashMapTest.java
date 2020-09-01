package study.jcf.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HashMapTest {

    @Test
    public void sort_test() {
        HashMap<String, String> map = new HashMap();
        map.put("a", "123");
        map.put("a", "234");

        log.info("{}", map.get("a"));
    }
}
