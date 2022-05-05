package com.agmtopy.leetcode

import kotlin.math.max

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
class DataStructures2 {

    fun maximumSubarray(nums: IntArray): Int {
        var pre = 0
        var maxAns = nums[0]

        for (x in nums) {
            pre = max(x, pre + x)
            maxAns = max(pre, maxAns)
        }
        return maxAns;
    }
}

fun main() {
    val structures2 = DataStructures2()
    val repeat = structures2.maximumSubarray(intArrayOf(1, 1, 5, -2, 1, 3))
    print("该数组的最大和的连续子数组和是:${repeat}")
}