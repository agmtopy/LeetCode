package com.agmtopt.leetcode

import java.util.HashMap

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
class DataStructures3 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int?> = HashMap()
        for (i in nums.indices) {
            var temp = target - nums[i]
            if(map.containsKey(temp) && map.get(temp) != i ){
                return intArrayOf(map[temp]!!,i)
            }
            map[nums[i]] = i
        }
        return intArrayOf(0,0)
    }
}

fun main() {
    val structures3 = DataStructures3()
    val twoSum = structures3.twoSum(intArrayOf(7,6,-3, 3), 3)
    print("输出:${twoSum.toList()}")
}