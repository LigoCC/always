package com.always.demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main25 {

    public static void main(String[] args) {
        // 123+abc456+789-472*126dde45
        String str = "1*5-2*2+3abcd";
        Pattern pattern = Pattern.compile("\\d+([+|\\-|*]\\d+)+");
        String lengest = "";
        for (int i = 0; i < str.length(); i++) {
            String substring = str.substring(i, str.length());
            Matcher matcher = pattern.matcher(substring);
            if (matcher.find()) {
                String group = matcher.group();
                if (group.length() > lengest.length()) {
                    lengest = group;
                }
            }
        }
        dfs(lengest);
    }

    public static void dfs(String str) {
        // 先计算乘法
        Pattern pattern = Pattern.compile("\\d+[*]\\d+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String group = matcher.group();
            String[] split = group.split("\\*");
            long l = Long.valueOf(split[0]) * Long.valueOf(split[1]);
            str = str.replace(group, String.valueOf(l));
            dfs(str);
            return;
        }
        // 加法和减法
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                Pattern pattern2 = Pattern.compile("\\d+[+]\\d+");
                Matcher matcher2 = pattern2.matcher(str);
                if (matcher2.find()) {
                    String group = matcher2.group();
                    String[] split = group.split("\\+");
                    long l = Long.valueOf(split[0]) + Long.valueOf(split[1]);
                    str = str.replace(group, String.valueOf(l));
                    dfs(str);
                    return;
                }
            } else if (str.charAt(i) == '-') {
                // 减法
                Pattern pattern3 = Pattern.compile("\\d+[-]\\d+");
                Matcher matcher3 = pattern3.matcher(str);
                if (matcher3.find()) {
                    String group = matcher3.group();
                    String[] split = group.split("-");
                    long l = Long.valueOf(split[0]) - Long.valueOf(split[1]);
                    str = str.replace(group, String.valueOf(l));
                    dfs(str);
                    return;
                }
            }
        }
        System.out.println(str);
    }
}
