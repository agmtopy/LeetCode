package com.agmtopt.leetcode.algorithmtrainingcamp.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString_387 {

  public static void main(String[] args) {
    FirstUniqueCharacterInAString_387_Solution solution = new FirstUniqueCharacterInAString_387_Solution();
    int result = solution.firstUniqChar("leetcode");

    System.out.println("result:" + result);
  }
}

class FirstUniqueCharacterInAString_387_Solution {

  public int firstUniqChar(String s) {
    Map<Character, Integer> map = new HashMap<>();

    char[] array = s.toCharArray();
    for (char item : array) {
      map.put(item, map.getOrDefault(item, 0) + 1);
    }

    int index = -1;
    for (int i = 0; i < array.length; i++) {
      if (map.get(array[i]) == 1) {
        index = i;
        break;
      }
    }
    return index;
  }
}
