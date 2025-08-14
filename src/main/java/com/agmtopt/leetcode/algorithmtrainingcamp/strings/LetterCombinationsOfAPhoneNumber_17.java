package com.agmtopt.leetcode.algorithmtrainingcamp.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LetterCombinationsOfAPhoneNumber_17 {

  public static void main(String[] args) {
    LetterCombinationsOfAPhoneNumber_17_Solution solution = new LetterCombinationsOfAPhoneNumber_17_Solution();

    List<String> results = solution.letterCombinations("234");
    System.out.println("results:" + results);
  }
}

class LetterCombinationsOfAPhoneNumber_17_Solution {

  // 数字到字母的映射表
  private static final Map<String, List<String>> map = new HashMap<>();
  static {
    map.put("2", Arrays.asList("a","b","c"));
    map.put("3", Arrays.asList("d","e","f"));
    map.put("4", Arrays.asList("g","h","i"));
    map.put("5", Arrays.asList("j","k","l"));
    map.put("6", Arrays.asList("m","n","o"));
    map.put("7", Arrays.asList("p","q","r","s"));
    map.put("8", Arrays.asList("t","u","v"));
    map.put("9", Arrays.asList("w","x","y","z"));
  }

  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
      return new ArrayList<>();
    }

    if (digits.length() == 1) {
      return map.get(digits);
    }

    String substring = digits.substring(1,digits.length());
    List<String> tempList = letterCombinations(substring);

    char firstChar = digits.charAt(0);
    List<String> results = new ArrayList<>();
    map.get(String.valueOf(firstChar)) .forEach(i -> tempList.forEach(t -> results.add(i + t)));

    return results;
  }
}
