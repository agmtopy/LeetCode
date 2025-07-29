package com.agmtopt.leetcode.algorithmtrainingcamp.map;

import com.alibaba.fastjson2.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        GroupAnagrams_49_Solution solution = new GroupAnagrams_49_Solution();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> rs = solution.groupAnagrams(strs);
        System.out.println(JSON.toJSONString(rs));
    }

}


class GroupAnagrams_49_Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for (String item : strs) {
            char[] array = item.toCharArray();
            Arrays.sort(array);
            int key = new String(array).hashCode();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
        }
        return map.values().stream().collect(Collectors.toList());
    }
}
