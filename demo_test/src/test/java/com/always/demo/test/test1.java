package com.always.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@SpringBootTest(classes = test1.class)
public class test1 {

    @Test
    public void test1() {
        List<String> str = new ArrayList<>();
        str.add("123");
        str.add("5");
        str.add("10086");
        str.add("5");
        str.add("0");

        str.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.valueOf(o1) < Integer.valueOf(o2)) {
                    return -1;
                } else if (Integer.valueOf(o1) > Integer.valueOf(o2)) {
                    return 1;
                }
                return 0;
            }
        });

        System.out.println(str);    // [0, 5, 5, 123, 10086]
    }
}
