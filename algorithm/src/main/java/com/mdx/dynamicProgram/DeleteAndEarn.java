package com.mdx.dynamicProgram;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Admin
 * @description 删除并获得点数
 * @since 2024/9/23 22:08
 **/
public class DeleteAndEarn {

    /**
     * 问题描述
     * 给你一个整数数组 nums ，你可以对它进行一些操作。
     * <p>
     * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
     * <p>
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,4,2]
     * 输出：6
     * 解释：
     * 删除 4 获得 4 个点数，因此 3 也被删除。
     * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,3,3,3,4]
     * 输出：9
     * 解释：
     * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
     * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
     * 总共获得 9 个点数。
     */

    @Test
    public void test() {
        int[] num1 = {3, 4, 2};
        int[] num2 = {2, 2, 3, 3, 3, 4};
        int[] num3 = {8, 10, 4, 9, 1, 3, 5, 9, 4, 10};
        List<int[]> nums = List.of(num1, num2, num3);
        for (int[] num : nums) {
            System.out.println("数组是: " + Arrays.toString(num));
            System.out.println("解法1的最大金额是: " + deleteAndEarn(num));
        }
    }

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        map.forEach((k, v) -> System.out.println("(" + k + "," + v + ")"));
        int result = 0;
        for (int num : nums) {
            //计算当前数字是否删除
            //获取数字总和
            int getSum = num * map.getOrDefault(num, 0);
            if (getSum == 0) {
                continue;
            }
            //获取数字+1的总和
            int delSum = (num - 1) * map.getOrDefault(num - 1, 0) + (num + 1) * map.getOrDefault(num + 1, 0);
            if (getSum >= delSum) {
                result += getSum;
                map.remove(num);
                map.remove(num - 1);
                map.remove(num + 1);
            }
        }
        return result;
    }


}
