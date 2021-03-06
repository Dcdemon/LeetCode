package leet.code;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution992 {


    @Test
    public void Test() {
        int[] A = new int[]{1, 2, 1, 3, 4};
        System.out.println(subarraysWithKDistinct(A, 3));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        int total = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < K; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        for (int start = 0, len = A.length; start <= len - K; start++) {
            if (start != 0) {
                if (map.get(A[start - 1]) == 1) {
                    map.remove(A[start - 1]);
                } else {
                    map.put(A[start - 1], map.get(A[start - 1]) - 1);
                }
                if (map.containsKey(A[start + K - 1])) {
                    map.put(A[start + K - 1], map.get(A[start + K - 1]) + 1);
                } else {
                    map.put(A[start + K - 1], 1);
                }
            }
            if (map.size() == K) {
                total++;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = start + K; i < len; i++) {
                if (map.containsKey(A[i]) || set.contains(A[i])) {
                    if ((map.size() + set.size()) == K) {
                        total++;
                    }
                } else {
                    if ((map.size() + set.size()) == K) {
                        break;
                    } else {
                        set.add(A[i]);
                        if ((map.size() + set.size()) == K) {
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }

    //    public int subarraysWithKDistinct(int[] A, int K) {
    //        int total = 0;
    //        for (int start = 0, len = A.length; start <= len - K; start++) {
    //            Set<Integer> set = new HashSet<>();
    //            for (int i = start; i < start + K; i++) {
    //                if (!set.contains(A[i])) {
    //                    set.add(A[i]);
    //                }
    //            }
    //            if (set.size() == K) {
    //                total++;
    //            }
    //            for (int i = start + K; i < len; i++) {
    //                if (set.contains(A[i])) {
    //                    if (set.size() == K) {
    //                        total++;
    //                    }
    //                } else {
    //                    if (set.size() == K) {
    //                        break;
    //                    } else {
    //                        set.add(A[i]);
    //                        if (set.size() == K) {
    //                            total++;
    //                        }
    //                    }
    //                }
    //            }
    //        }
    //        return total;
    //    }


}
