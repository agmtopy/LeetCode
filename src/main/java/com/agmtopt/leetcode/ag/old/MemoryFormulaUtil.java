package com.agmtopt.leetcode.ag.old;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryFormulaUtil {

    public static void main(String[] args) {
        ArrayList<String> arrayList = Lists.newArrayList(value.split("."));
        List<String> varList = Lists.newArrayList();

        for (int i = 0; i < arrayList.size(); i++) {
            if (i % 2 == 1) {
                String[] split = arrayList.get(i).split("");
                varList.add(Lists.newArrayList(split).get(0));
            }
        }




    }

    public static final String value = "1.工厂方法\n" +
            "\n" +
            "2.抽象工厂\n" +
            "\n" +
            "3.生成/构造器\n" +
            "\n" +
            "4.原型模式\n" +
            "\n" +
            "6.单例模式";
}
