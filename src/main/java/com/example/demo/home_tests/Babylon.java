package com.example.demo.home_tests;

import java.util.*;


public class Babylon {

    public static void main(String[] args) {


        System.out.println(goodSegment(Arrays.asList(5, 4, 2, 15), 1, 10));
    }


    static boolean checkExpressionBraces(String str) {
        if (str.length() == 1)
            return false;

        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (!Character.isLetter(cur)) {
                if (!map.containsKey(cur)) {
                    stack.push(cur);
                } else {

                    if (!stack.isEmpty()) {
                        char open = stack.pop();
                        if (open != map.get(cur)) {
                            return false;
                        }
                    } else {
                        stack.push('#');
                    }
                }
            }
        }

        return stack.isEmpty();
    }


    public static List<Integer> onesGroups(List<List<Integer>> grid, List<Integer> queries) {
        int colLength = grid.size();
        if (colLength == 0)
            return null;
        int rowLength = grid.get(0).size();


        // init to all false
        boolean[][] visitMap = new boolean[colLength][rowLength];
        for (int i = 0; i < colLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                visitMap[i][j] = false;
            }
        }

        Queue<Integer[]> queue = new LinkedList<>();
        Map<Integer, Integer> islandCountsBySizes = new HashMap<>();

        for (int i = 0; i < colLength; i++) {

            for (int j = 0; j < rowLength; j++) {
                int curIslandCount = 0;
                if (!visitMap[i][j] && grid.get(i).get(j) == 1) {
                    queue.add(new Integer[]{i, j});

                    curIslandCount++;

                    while (!queue.isEmpty()) {
                        Integer[] x = queue.remove();
                        int row = x[0];
                        int col = x[1];

                        if (row < 0 || col < 0 || row >= colLength || col >= rowLength || visitMap[row][col] || grid.get(row).get(col) != 1)
                            continue;


                        visitMap[row][col] = true;
                        queue.add(new Integer[]{row, (col - 1)});
                        queue.add(new Integer[]{row, (col + 1)});
                        queue.add(new Integer[]{(row - 1), col});
                        queue.add(new Integer[]{(row + 1), col});
                    }

                    islandCountsBySizes.put(curIslandCount, islandCountsBySizes.getOrDefault(curIslandCount, 0) + 1);

                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (Integer q : queries) {
            int val = islandCountsBySizes.getOrDefault(q, 0);
            ans.add(val);
        }

        return ans;

    }


    public static int goodSegment(List<Integer> badNumbers, int lower, int upper) {
        int maxSegLen = 0;
        int curSegLen = 0;
        int lastGood = lower;

        Collections.sort(badNumbers);
        System.out.println(badNumbers);
        int len = badNumbers.size();

        for (Integer badNumber : badNumbers) {
            if (badNumber <= upper) {
                curSegLen = badNumber - lastGood;
                maxSegLen = Math.max(maxSegLen, curSegLen);
                lastGood = badNumber + 1;
            }
        }

        curSegLen = upper - lastGood + 1;

        return Math.max(maxSegLen, curSegLen);

    }




    static boolean checkSquareBracketRequirement(String str) {
        boolean sBracketOpend = false;
        for (char c : str.toCharArray()) {
            if (sBracketOpend) {
                if (c == '[')
                    return false;

                if (c == ']') {
                    sBracketOpend = false;
                }
            }

            if (!sBracketOpend && c == '[') {
                sBracketOpend = true;
            }
        }

        return true;
    }

//    static boolean checkCurlyBracketRequirement(String str) {
//        boolean anyOpenBracket = false;
//        for (char c : str.toCharArray()) {
//            if (!Character.isLetter(c)) {
//                if (!anyOpenBracket && c == '(' || c == '[') {
//                    anyOpenBracket = true;
//                }
//            }
//        }
//
//
//    }


    public static boolean checkBalance(String s, Map<Character, Character> map) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                stack.push(cur);
            } else {

                if (!stack.isEmpty()) {
                    char open = stack.pop();
                    if (open != map.get(cur)) {
                        return false;
                    }
                } else {
                    stack.push('#');
                }
            }

        }


        return stack.isEmpty();
    }
}
