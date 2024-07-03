package com.agmtopt.leetcode.ag.old;

import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class T1 {
    public static void main(String[] args) {
        System.out.println(Stream.of(1,2,3,4).reduce((a, b) -> a +b).get() );

        Executors.newCachedThreadPool();

        Thread t = new Thread();
        t.stop();
    }
}
