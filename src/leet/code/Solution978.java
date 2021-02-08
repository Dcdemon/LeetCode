package leet.code;

import org.junit.Test;

public class Solution978 {

    @Test
    public void test() {
        int[] arr = new int[]{0, 8, 45, 88, 48, 68, 28, 55, 17, 24};
        System.out.println(maxTurbulenceSize(arr));
    }

    public int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            return 1;
        }
        int max1 = 0;
        int temp = 0;
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] < arr[i + 1]) {
                    temp++;
                } else {
                    if (temp > max1) {
                        max1 = temp;
                    }
                    temp = 0;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    temp++;
                } else {
                    if (temp > max1) {
                        max1 = temp;
                    }
                    temp = 0;
                }
            }
        }
        if (temp > max1) {
            max1 = temp;
        }
        if (max1 == arr.length) {
            return max1;
        }
        int max2 = 0;
        temp = 0;
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] > arr[i + 1]) {
                    temp++;
                } else {
                    if (temp > max2) {
                        max2 = temp;
                    }
                    temp = 0;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    temp++;
                } else {
                    if (temp > max2) {
                        max2 = temp;
                    }
                    temp = 0;
                }
            }
        }
        if (temp > max2) {
            max2 = temp;
        }
        return (max1 > max2 ? max1 : max2) + 1;
    }
}
