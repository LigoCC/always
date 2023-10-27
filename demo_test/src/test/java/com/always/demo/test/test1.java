package com.always.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /*
     * 统计一段时间每个小时的分钟数
     */
    @Test
    public void test2() {
        Calendar start = Calendar.getInstance();
        start.set(2021, Calendar.JANUARY, 1, 0, 0, 0); // 设置开始时间，这里为2022年1月1日00:00:00
        Calendar end = Calendar.getInstance();
        end.set(2022, Calendar.JANUARY, 1, 1, 0, 0); // 设置结束时间，这里为2022年1月1日01:00:00
        Map<Integer, Integer> map = new HashMap<>(); // 用于存储每个小时的分钟数
        while (start.before(end)) {
            int hour = start.get(Calendar.HOUR_OF_DAY); // 获取当前小时数
            if (map.containsKey(hour)) {
                map.put(hour, map.get(hour) + 1); // 如果已经存在该小时数，则将对应的分钟数加1
            } else {
                map.put(hour, 1); // 如果不存在该小时数，则将该小时数对应的分钟数设置为1
            }
            start.add(Calendar.MINUTE, 1); // 将时间加1分钟
        }
        // 输出结果
        for (int hour : map.keySet()) {
            System.out.println(hour + "时有" + map.get(hour) + "分钟");
        }
    }

    /*
     * 两个Date之间的天数
     */
    @Test
    public void test3() {
        Date startTime = new Date(2023 - 1900, 10 - 1, 20, 0, 0, 0);
        Date endTime = new Date(2023 - 1900, 10 - 1, 24, 23, 59, 59);
        BigDecimal bigDecimal = BigDecimal.valueOf(endTime.getTime() - startTime.getTime());
        BigDecimal divide = bigDecimal.divide(BigDecimal.valueOf(1000 * 24 * 60 * 60), 0, RoundingMode.HALF_UP);
        System.out.println(divide);
    }

    @Test
    public void test4() {
        Map<Integer, Integer> map = new HashMap<>();
        // map初始化
        for (int i = 0; i <= 23; i++) {
            map.put(i, 0);
        }
        System.out.println(map.get(23));
    }
}
