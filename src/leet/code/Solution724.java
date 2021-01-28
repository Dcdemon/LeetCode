package leet.code;

import org.junit.Test;

public class Solution724 {

    @Test
    public void test() {

    }


    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int index;
        int left = 0;
        int right = 0;
        int max = 0;
        for (int num : nums) {
            max += num;
        }
        right = max - nums[0];
        if (right == 0) {
            return 0;
        }
        for (index = 1; index < nums.length; index++) {
            left += nums[index - 1];
            right -= nums[index];
            if (left == right) {
                return index;
            }
        }
        return -1;
    }
}
