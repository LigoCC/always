package com.always.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest(classes = test3.class)
public class test3 {

    int p; // 终点x坐标
    int q;  // 终点y坐标
    int min = 99999999;

    int[][] arr = new int[100][100];    // 存地图,1表示空地,2表示障碍物
    int[][] load = new int[100][100];   // 记录访问,0表示未访问,1表示访问

    @Test
    public void demo1() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();
            // 数据存入
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                    load[i][j] = 0;
                }
            }
            // 起始位置、终点位置
            load[0][0] = 1;
            dfs(0, 0, 0);
            System.out.println(min);
        }
    }

    @Test
    public void demo2() {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 计算上个月的年份和月份
        LocalDate previousMonth = currentDate.minusMonths(2);
        int previousYear = previousMonth.getYear();
        int previousMonthValue = previousMonth.getMonthValue();

        System.out.println("上个月的年份：" + previousYear);
        System.out.println("上个月的月份：" + previousMonthValue);
    }

    @Test
    public void demo2_2() {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 获取昨天的日期
        LocalDate yesterday = currentDate.minusDays(1);

        // 格式化日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = yesterday.format(formatter);

        // 获取年份、月份和日期
        int year = yesterday.getYear();
        int month = yesterday.getMonthValue();
        int day = yesterday.getDayOfMonth();

        System.out.println("昨天的年份：" + year);
        System.out.println("昨天的月份：" + month);
        System.out.println("昨天的日期：" + day);
        System.out.println("格式化后的日期：" + formattedDate);
    }

    /**
     * 拼音排序
     */
    @Test
    public void demo3() {
        String[] words = {"苹果", "香蕉", "橘子", "葡萄"};

        // 创建一个RuleBasedCollator对象，使用中文语言环境和拼音排序规则
        RuleBasedCollator collator;
        try {
            collator = (RuleBasedCollator) Collator.getInstance(Locale.CHINA);
            // collator = new RuleBasedCollator(collator.getRules() + "&[sort=zh]");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 使用RuleBasedCollator对象对字符串数组进行排序
        Arrays.sort(words, collator);

        // 打印排序后的结果
        for (String word : words) {
            System.out.println(word);
        }
    }

    @Test
    public void demo4() {
        List<String> words = Arrays.asList("苹果", "香蕉", "橘子", "葡萄", "朱");

        // 创建一个Collator对象，使用中文语言环境和拼音排序规则
        Collator collator = Collator.getInstance(Locale.CHINA);
        // collator = new RuleBasedCollator(collator.getRules() + "&[sort=zh]");

        // 使用Comparator.comparing方法结合Collator进行排序
        Comparator<String> comparator = Comparator.comparing(s -> s, collator);

        // 使用Stream流对字符串列表进行排序
        List<String> sortedWords = words.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        // 打印排序后的结果
        for (String word : sortedWords) {
            System.out.println(word);
        }
    }

    void dfs(int x, int y, int step) {
        if (x == p && y == q) { // 到达终点
            if (step < min) {
                min = step;
            }
            return; // 回溯
        }
        // 右
        if (arr[x][y + 1] == 1 && load[x][y + 1] == 0) {
            load[x][y + 1] = 1;
            dfs(x, y + 1, step + 1);
            load[x][y + 1] = 0;
        }
        // 下
        if (arr[x + 1][y] == 1 && load[x + 1][y] == 0) {
            load[x + 1][y] = 1;
            dfs(x + 1, y, step + 1);
            load[x + 1][y] = 0;
        }
        // 左
        if (arr[x][y - 1] == 1 && load[x][y - 1] == 0) {
            load[x][y - 1] = 1;
            dfs(x, y - 1, step + 1);
            load[x][y - 1] = 0;
        }
        // 上
        if (arr[x - 1][y] == 1 && load[x - 1][y] == 0) {
            load[x - 1][y] = 1;
            dfs(x - 1, y, step + 1);
            load[x - 1][y] = 0;
        }
        return;
    }
}
