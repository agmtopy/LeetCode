package com.agmtopt.leetcode.algorithmtrainingcamp.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class MinStack_155 {

}

class MinStack_155_MinStack {

    private List<Integer> dStack = new ArrayList<>();

    /**
     * 初始化堆栈对象
     */
    public MinStack_155_MinStack() {
        //清空队列
        dStack.clear();
    }

    /**
     * 将元素val推入堆栈
     */
    public void push(int val) {
        dStack.add(val);
    }

    /**
     * 删除堆栈顶部的元素
     */
    public void pop() {
        dStack.remove(dStack.size() - 1);
    }

    /**
     * 获取堆栈顶部的元素
     */
    public int top() {
        return dStack.get(dStack.size() - 1);
    }

    /**
     * 获取堆栈中的最小元素
     */
    public int getMin() {
        return dStack.stream().mapToInt(Integer::intValue).min().getAsInt();
    }
}

