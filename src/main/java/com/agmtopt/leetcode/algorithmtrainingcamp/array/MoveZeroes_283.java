package com.agmtopt.leetcode.algorithmtrainingcamp.array;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        int[] nums1 = new int[]{0, 1, 0, 3, 12};

        MoveZeroes_283_Solution solution = new MoveZeroes_283_Solution();
        solution.moveZeroes1(nums1);
        for (int num : nums1) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

    public static void test2() {
        int[] nums1 = new int[]{0};

        MoveZeroes_283_Solution solution = new MoveZeroes_283_Solution();
        solution.moveZeroes1(nums1);
        for (int num : nums1) {
            System.out.print(num + ",");
        }
        System.out.println();
    }


}

class MoveZeroes_283_Solution {

    /**
     * 不能复制数组,因此采用双指针的方式进行处理
     * 指针i负责标记为0的index
     * 指针j负责查找不能0的index
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        while (j != nums.length) {
            if (nums[j] != 0 && nums[i] == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                continue;
            }

            if (nums[i] != 0) {
                i++;
            }

            j++;
        }
    }

    /**
     * 双指针的变种形式,将非0的值填充到0值上
     */
    public void moveZeroes1(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur] = nums[i];
                cur++;
            }
        }

        for (int i = cur; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
