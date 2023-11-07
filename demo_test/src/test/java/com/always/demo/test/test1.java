package com.always.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    @Test
    public void test5() {
        char a = 'a';
        int intA = a;
        System.out.println(intA);   // 97

        int i = 65;
        char charI = (char)i;
        System.out.println(charI);  // A
    }

    @Test
    public void test7() {
        // HashMap，无序
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("bbb", "9");
        hashMap.put("ccc", "10");
        hashMap.put("dddd", "11");
        hashMap.put("aaa", "10");
        for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());    // aaa 10 ccc 10 bbb 9 dddd 11
        }

        // TreeMap，自定义排序(只能控制key排序)
        Map<String, String> testMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        testMap.put("bbb", "9");
        testMap.put("ccc", "10");
        testMap.put("dddd", "11");
        testMap.put("aaa", "10");
        for (Map.Entry<String, String> stringStringEntry : testMap.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());    // dddd 11 ccc 10 bbb 9 aaa 10
        }
    }

    /**
     * HashMap自定义排序
     */
    @Test
    public void test8() {
        Map<String, String> testMap = new HashMap<>();

        testMap.put("bbb", "9");
        testMap.put("ccc", "10");
        testMap.put("dddd", "11");
        testMap.put("aaa", "10");

        // Set<Map.Entry<String, String>> entries = testMap.entrySet();
        List<Map.Entry<String, String>> list = new ArrayList<>(testMap.entrySet());
        list.sort(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return Integer.valueOf(o2.getValue()).compareTo(Integer.valueOf(o1.getValue()));
            }
        });

        for (Map.Entry<String, String> stringStringEntry : list) {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
        }
    }

    @Test
    public void test9() {
        Map<String, String> testMap = new HashMap<>();

        testMap.put("bbb", "9");
        testMap.put("ccc", "10");
        testMap.put("dddd", "11");
        testMap.put("aaa", "10");

        // Set<Map.Entry<String, String>> entries = testMap.entrySet();
        List<Map.Entry<String, String>> list = new ArrayList<>(testMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return Integer.valueOf(o2.getValue()).compareTo(Integer.valueOf(o1.getValue()));
            }
        });

        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
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
    public void test11() {
        String binaryString = Integer.toBinaryString(3);
        System.out.println(binaryString);
    }

    @Test
    public void test12() {
        Date date = new Date();
        long time = date.getTime();

        System.out.println(date);
        System.out.println(time);

        long l = date.getTime() - 10000L;
        Date date1 = new Date(l);
        System.out.println(date1);  //
    }

    @Test
    public void test13() {
        List<String> lotsns = new ArrayList<>();
        lotsns.add("123");
        lotsns.add("456");
        System.out.println(lotsns.toString().replaceAll("\\[", "").replaceAll("]", ""));
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
    public void test16() {
        List<String> list = new ArrayList<>();

        System.out.println(list.size());    // 0

        list.add("123");
        list.add("456");
        list.add("789");
        list.add("000");

        System.out.println(list.size());    // 4

        System.out.println(list.get(3));    // 000

        System.out.println(list.subList(0, 3)); // [123, 456, 789];list.subList(x,y),包含x，不包含y,即[x,y)
    }

    @Test
    public void test17() {
        String str = "0123456789";

        int length = str.length();
        System.out.println(length); // 10

        char c1 = str.charAt(0);
        System.out.println(c1); // 0
        char c2 = str.charAt(9);
        System.out.println(c2); // 9

        String substring = str.substring(0, 2);
        System.out.println(substring);  // 01;  string.substring(x,y),包含x，不包含y,即[x,y)

        String substring2 = str.substring(0, 10);
        System.out.println(substring2); // 0123456789

        CharSequence charSequence = str.subSequence(1, 8);
        System.out.println(charSequence);   // 1234567
    }

    @Test
    public void test18() {
        Map<String, String> map = new HashMap<>();

        System.out.println(map.isEmpty());  // true
        System.out.println(map.size()); // 0
    }

    @Test
    public void test19() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("123");
        list.add("456");
        list.add("123");
        list.add("123");

        list.remove("123");
        System.out.println(list);   // [456, 123, 456, 123, 123];删除第一个该元素

        List<String> removeList = new ArrayList<>();
        removeList.add("123");
        removeList.add("456");

        System.out.println(list.removeAll(removeList)); // [];删除所有匹配到的元素
    }
}
