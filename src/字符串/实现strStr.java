package 字符串;

/**
 * @author lyq on 2021-04-15 下午11:04
 * @desc 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class 实现strStr {

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = getNext(needle);
        char[] main = haystack.toCharArray();
        char[] sub = needle.toCharArray();
        // j表示模式串中的位置
        int j = 0;
        // i表示主串中的位置
        for (int i=0;i<main.length;i++) {
            // 遇到不匹配,将模式串位置重置为next数组中前一元素对应的值
            while (j > 0 && sub[j] != main[i]) {
                j = next[j-1];
            }
            // 匹配时同时向后移动
            if (main[i] == sub[j]) {
                j++;
            }
            // 匹配成功直接返回
            if (j == sub.length - 1) {
                return i - sub.length + 1;
            }
        }
        return -1;
    }

    /**
     * 构建next数组：next[i] 表示下标小于i的子串中最长相同前后子串的长度
     * @param needle
     * @return
     */
    private static int[] getNext(String needle) {
        char[] chars = needle.toCharArray();
        int[] next = new int[needle.length()];
        // j指向前缀的终止位置
        int j = 0;
        next[0] = 0;
        // i指向后缀的终止位置
        for (int i=1;i<needle.length();i++) {
            // 前后缀的末尾字符不同时向前回溯
            while (j > 0 && chars[j] != chars[i]) {
                j = next[j-1];
            }
            // 找到相同前后缀
            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
