package leet.code;

import java.util.HashMap;
import java.util.Map;

public class Solution697 {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int maxNum, max;
        maxNum = max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxNum = entry.getKey();
            }
        }
        int front, behind;
        for (front = 0; front < nums.length; front++) {
            if (nums[front] == maxNum) {
                break;
            }
        }
        for (behind = nums.length - 1; behind >= 0; behind--) {
            if (nums[behind] == maxNum) {
                break;
            }
        }
        return behind - front + 1;
    }
}
