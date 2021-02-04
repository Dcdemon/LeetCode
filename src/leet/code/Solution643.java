package leet.code;

public class Solution643 {


    public double findMaxAverage(int[] nums, int k) {
        double result = 0.0;
        double max = 0.0;
        double total = 0.0;
        for (int i = 0; i < k; i++) {
            total += nums[i];
        }
        max = total;
        for (int i = 1, len = nums.length; i <= len - k; i++) {
            total -= nums[i - 1];
            total += nums[i + k - 1];
            if (total > max) {
                max = total;
            }
        }
        return max / k;
    }
}
