package com.mdx.dynamicProgram;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 爬楼梯
 */
public class ClimbingStairs {

    /**
     * leetcode  746.使用最小花费爬楼梯
     * 给你一个整数数组 cost ，其中 dp[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * <p>
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     * <p>
     * 请你计算并返回达到楼梯顶部的最低花费。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：cost = [10,15,20,10,0]
     * 输出：15
     * 解释：你将从下标为 1 的台阶开始。
     * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
     * 总花费为 15 。
     * 示例 2：
     * <p>
     * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
     * 输出：6
     * 解释：你将从下标为 0 的台阶开始。
     * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
     * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
     * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
     * 总花费为 6 。
     */

    @Test
    public void test() {
        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        List<int []> costs = List.of(cost1);
        for (int[] ints : costs) {
            System.out.println("数组: " + Arrays.toString(ints));
            System.out.println("解法1: " + minCostClimbingStairs(cost1));
            System.out.println("解法2: " + minCostClimbingStairs2(cost1));
        }
    }

    /**
     * @param cost
     * @return int
     * @description 使用最小花费爬楼梯
     * @author huangy
     * @since 2024/9/21 11:00
     **/
    public int minCostClimbingStairs(int[] cost) {
        int costLen = cost.length;
        if (costLen <= 1) {
            return 0;
        }
        int[] dp = new int[costLen + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i < costLen) {
                dp[i] = cost[i];
            } else {
                dp[i] = 0;
            }
        }
        int[] costPrice = new int[costLen + 1];
        costPrice[0] = dp[0];
        costPrice[1] = dp[1];
        for (int i = 2; i < dp.length; i++) {
            costPrice[i] = dp[i] + Math.min(costPrice[i - 1], costPrice[i - 2]);
        }
        return costPrice[costLen];
    }

    /**
     * @description 最小费用计算优化 - 参考leetcode上的题解
     * @author huangy
     * @since 2024/9/23 19:33
     * @param cost
     * @return int
     **/
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int cur = 0;
        int pre = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(cur + cost[i - 1], pre + cost[i - 2]);
            pre = cur;
            cur = next;
        }
        return cur;
    }

}
