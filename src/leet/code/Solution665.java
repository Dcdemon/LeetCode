package leet.code;

import org.junit.Test;

public class Solution665 {

    @Test
    public void test() {
        int[] nums = new int[]{5, 7, 1, 8};
        System.out.println(checkPossibility(nums));
    }


    public boolean checkPossibility(int[] nums) {
        boolean usedFlag = false;
        for (int i = 0, len = nums.length; i < len - 1; i++) {
            System.out.println(i);
            if (nums[i] > nums[i + 1]) {
                if (usedFlag) {
                    return false;
                } else {
                    usedFlag = true;
                    if (i >= 1) {
                        if (nums[i + 1] < nums[i - 1]) {
                            nums[i + 1] = nums[i];
                        }
                    }
                }
            }
        }
        return true;
    }
}
