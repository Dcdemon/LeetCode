package leet.code;


import org.junit.Test;

import java.util.Arrays;

public class Solution480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || nums.length < k) {
            return null;
        }
        int len = nums.length - k + 1;
        boolean flag = k % 2 == 0;
        double[] result = new double[len];
        for (int i = 0; i < len; i++) {
            int[] sub = new int[k];
            for (int j = 0; j < k; j++) {
                sub[j] = nums[i + j];
            }
            Arrays.sort(sub);
            if (flag) {
                result[i] = (sub[k / 2] * 1.0 + sub[k / 2 - 1]) / 2;
            } else {
                result[i] = sub[k / 2];
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2147483647, 2147483647};
        double[] doubles = medianSlidingWindow(nums, 2);
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }

    }
}
