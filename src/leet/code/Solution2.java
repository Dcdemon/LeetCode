package leet.code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        //        wordList.add("cog");
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static boolean is(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        boolean difCharFlag = false;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                if (difCharFlag) {
                    return false;
                } else {
                    difCharFlag = true;
                }
            }
        }
        return difCharFlag;
    }

    public static int BFS(List<String> beginList, String endWord, List<String> wordList, int nowStep) {
        List<String> newBeginList = new ArrayList<>();
        for (String s : beginList) {
            if (is(endWord, s)) {
                return nowStep + 1;
            } else {
                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()) {
                    String str = iterator.next();
                    if (is(s, str)) {
                        newBeginList.add(str);
                        iterator.remove();
                    }
                }
            }
        }
        if (newBeginList.size() == 0) {
            return 0;
        } else {
            return BFS(newBeginList, endWord, wordList, nowStep + 1);
        }
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        List beginList = new ArrayList();
        beginList.add(beginWord);
        return BFS(beginList, endWord, wordList, 1);
    }
}
