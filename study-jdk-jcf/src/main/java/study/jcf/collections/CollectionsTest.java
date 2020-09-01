package study.jcf.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class CollectionsTest {

    @Test
    public void sort_test() {
        List<Person> dataLt = new ArrayList<>();
        dataLt.add(new Person(1, "zhangs", 30));
        dataLt.add(new Person(2, "lis", 17));
        dataLt.add(new Person(3, "wangw", 62));

        Collections.sort(dataLt, (e1, e2) -> {
            int a1 = e1.getAge();
            int a2 = e2.getAge();
            int diff = a1 - a2;
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            }
            return 0;
        });

        dataLt.stream().forEach(e -> {
            log.info("{}", e);
        });
    }
}
