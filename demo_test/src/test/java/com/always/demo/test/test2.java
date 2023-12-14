package com.always.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest(classes = test2.class)
public class test2 {

    /*
     * 统计一段时间每个小时的分钟数
     */
    @Test
    public void test2() {
        long sm = System.currentTimeMillis();
        Calendar start = Calendar.getInstance();
        start.set(2023, Calendar.JANUARY, 1, 5, 42, 0); // 设置开始时间，这里为2022年1月1日00:00:00
        Calendar end = Calendar.getInstance();
        end.set(2023, Calendar.JANUARY, 1, 5, 55, 59); // 设置结束时间，这里为2022年1月1日01:00:00
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
        long em = System.currentTimeMillis();
        System.out.println("耗时：" + (em - sm) + "毫秒");
        // 输出结果
        for (int hour : map.keySet()) {
            System.out.println(hour + "时有" + map.get(hour) + "分钟");
        }
    }

    @Test
    public void test2_2() {
        long sm = System.currentTimeMillis();
        // 统计每个小时的分钟数
        Map<Integer, Integer> hourMinuteCount = new HashMap<>();
        // 设置时间范围
        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 10, 20, 30);

        if ((startTime.getYear() == endTime.getYear()
                && startTime.getMonthValue() == endTime.getMonthValue()
                && startTime.getDayOfMonth() == endTime.getDayOfMonth()
                && startTime.getHour() == endTime.getHour())
        ) {
            hourMinuteCount.put(startTime.getHour(), ((endTime.getSecond() > 30 ? 1 : 0) + endTime.getMinute()) - ((startTime.getSecond() > 30 ? 1 : 0) + startTime.getMinute()));
        } else {
            // 掐头
            int startTimeHour = startTime.getHour();
            int startTimeMinute = startTime.getMinute();
            int startTimeSecond = startTime.getSecond();
            if (startTimeSecond > 30) {
                startTimeMinute += 1;
            }
            hourMinuteCount.put(startTimeHour, 60 - startTimeMinute);
            startTime = startTime.plusHours(1);
            startTime = startTime.withMinute(0);
            startTime = startTime.withSecond(0);
            // 去尾
            int endTimeHour = endTime.getHour();
            int endTimeMinute = endTime.getMinute();
            int endTimeSecond = endTime.getSecond();
            if (endTimeSecond > 30) {
                endTimeMinute += 1;
            }
            hourMinuteCount.put(endTimeHour, hourMinuteCount.get(endTimeHour) == null ? endTimeMinute : hourMinuteCount.get(endTimeHour) + endTimeMinute);
            endTime = endTime.plusHours(-1);
            endTime = endTime.withMinute(0);
            endTime = endTime.withSecond(0);
            // 循环中间
            for (LocalDateTime dateTime = startTime; !dateTime.isAfter(endTime); dateTime = dateTime.plusHours(1)) {
                int hour = dateTime.getHour();
                hourMinuteCount.put(hour, hourMinuteCount.get(hour) == null ? 60 : hourMinuteCount.get(hour) + 60);
            }
        }

        long em = System.currentTimeMillis();
        System.out.println("耗时：" + (em - sm) + "毫秒");

        // 输出结果
        for (Map.Entry<Integer, Integer> entry : hourMinuteCount.entrySet()) {
            System.out.println("Hour: " + entry.getKey() + ", Minutes: " + entry.getValue());
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
    public void test10() {
        String str1 = "dec";
        String str2 = "fab";

        StringBuffer bff = new StringBuffer();
        bff.append(str1);
        bff.append(str2);

        System.out.println(bff);    // decfab

        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        for (int i = 0; i < bff.length(); i++) {
            char charAt = bff.charAt(i);
            if (i % 2 == 0) {
                list1.add(charAt);
            } else {
                list2.add(charAt);
            }
        }

        System.out.println(list1);
        System.out.println(list2);

        list1.sort(new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                return c1 - c2;
            }
        });
        list2.sort(new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                return c1 - c2;
            }
        });

        System.out.println(list1);
        System.out.println(list2);

        StringBuffer bff2 = new StringBuffer();
        for (int i = 0; i < Math.max(list1.size(), list2.size()); i++) {
            if (list1.size() >= i) {
                bff2.append(list1.get(i));
            }
            if (list2.size() >= i) {
                bff2.append(list2.get(i));
            }
        }
        System.out.println(bff2);   // abcedf

        StringBuffer bff3 = new StringBuffer();
        for (int i = 0; i < bff2.length(); i++) {
            String str = String.valueOf(bff2.charAt(i));
            if (str.matches("[0-9a-fA-F]")) {
                // 16进制转10进制
                int anInt = Integer.parseInt(str, 16);
                // 10进制转2进制
                String binaryString = Integer.toBinaryString(anInt);
                StringBuffer reverse = new StringBuffer(binaryString).reverse();
                while (reverse.length() < 4) {
                    reverse.append(0);
                }
                String hexString = Integer.toHexString(Integer.parseInt(reverse.toString(), 2)).toUpperCase();
                bff3.append(hexString);
            }
        }
        System.out.println(bff3);
    }

    @Test
    public void test14() {
        String line = "Eqr v9oEb12U2ur4xu7rd931G1f50qDo";
        line = line.replace(" ", "");
        List<Character> c1 = new ArrayList<>();
        List<Character> c2 = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (i % 2 == 0) {
                c1.add(line.charAt(i));
            } else {
                c2.add(line.charAt(i));
            }
        }
        c1.sort(new Comparator<Character>() {
            public int compare(Character char1, Character char2) {
                return char1 - char2;
            }
        });
        c2.sort(new Comparator<Character>() {
            public int compare(Character char1, Character char2) {
                return char1 - char2;
            }
        });
        int max = Math.max(c1.size(), c2.size());
        StringBuffer bff = new StringBuffer();
        for (int j = 0; j <= max; j++) {
            if (c1.size() > j) {
                bff.append(c1.get(j));
            }
            if (c2.size() > j) {
                bff.append(c2.get(j));
            }
        }

        System.out.println(bff);

        StringBuffer result = new StringBuffer();
        for (int k = 0; k < bff.length(); k++) {
            String charAt = String.valueOf(bff.charAt(k));
            if (charAt.matches("[0-9a-fA-F]")) {
                // 十六转十
                int x = Integer.parseInt(charAt, 16);
                // 十转二
                String er = Integer.toBinaryString(x);
                // 翻转
                StringBuffer erbff = new StringBuffer(er).reverse();
                // 补位
                while (erbff.length() < 4) {
                    erbff.append("0");
                }
                // 二转十；十转十六
                String shiliu = Integer.toHexString(Integer.parseInt(erbff.toString(),
                        2)).toUpperCase();
                result.append(shiliu);
            }
        }
        System.out.print(result);
    }

    @Test
    public void test15() {
        List<Character> charList = new ArrayList<>();
        charList.add('b');
        charList.add('d');
        charList.add('f');
        charList.add('k');

        charList.sort(Comparator.comparing(Character::getNumericValue));

        charList.forEach(t -> System.out.println(t));
    }

    @Test
    public void test16() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);
    }

    @Test
    public void test17() {
        // 1左移4位
        String binaryString = Integer.toBinaryString(1 << 4);
        System.out.println(binaryString);
        Integer integer = Integer.valueOf(binaryString, 2);
        System.out.println(integer);
        // 10右移2位
        String binaryString1 = Integer.toBinaryString(10);
        System.out.println(binaryString1);
        System.out.println(10 >> 2);
        System.out.println(Integer.parseInt("10", 2));
    }
}
