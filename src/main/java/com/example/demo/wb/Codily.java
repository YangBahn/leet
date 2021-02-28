package com.example.demo.wb;

import lombok.experimental.UtilityClass;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

@UtilityClass
public class Codily {

    public static void main(String[] args) {
        String s1 = "15:15:00";
        String s2 = "15:15:12";
        out.println(howManyInterestingInstances(s1, s2));


    }


    static int howManyInterestingInstances(String startStr, String endStr) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime end = LocalTime.parse(endStr);
        int count = 0;

        LocalTime startLocalTime = LocalTime.parse(startStr);
        for (LocalTime localTime = startLocalTime; localTime.isBefore(end); localTime = localTime.plusSeconds(1)) {

            String t2 = dtf.format(localTime).replace(":", "");
            count += isInteresting(t2);
        }

        count += isInteresting(dtf.format(end).replace(":", ""));

        return count;
    }

    private int isInteresting(String time) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : time.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        return map.size() <= 2 ? 1 : 0;
    }


    public static void printArr(int[] arr) {
        for (int n : arr) {
            out.print(n + ",");
        }
        out.println();
    }
}
