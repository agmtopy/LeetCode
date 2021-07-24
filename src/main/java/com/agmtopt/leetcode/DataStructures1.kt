package com.agmtopt.leetcode

class DataStructures1 {

    fun isRepeat(args: IntArray): Boolean {
        return args.toList().stream()
            .distinct()
            .count()
            .compareTo(args.size) != 0
    }
}

fun main() {
    val dataStructures1 = DataStructures1()
    val repeat = dataStructures1.isRepeat(intArrayOf(1, 2, 2, 3, 4))
    print("该数组是否有重复元素:$repeat")
}
