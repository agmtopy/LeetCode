package com.agmtopt.leetcode

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
class DataStructures2 {

    fun maximumSubarray(intArray: IntArray): Int {
        var ans = intArray[0]
        var sum = 0

        for (item in intArray) {
            if (sum > 0) {
                sum += item
            }else{
                sum = item;
            }
           ans = Math.max(sum,ans)
        }
        return ans;
    }
}

fun main() {
    val structures2 = DataStructures2()
    val repeat = structures2.maximumSubarray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
    print("该数组的最大和的连续子数组和是:${repeat}")
}