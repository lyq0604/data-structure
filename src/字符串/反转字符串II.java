package 字符串;

/**
 * @author lyq on 2021-04-12 下午10:45
 * @desc 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *      如果剩余字符少于 k 个，则将剩余字符全部反转。
 *      如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class 反转字符串II {

    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        // i表示每隔2k个字符的起点
        for (int i=0;i<chars.length;i+=2*k) {
            //
            if (i+k<=s.length()) {
                reverse(chars, i, i+k-1);
                continue;
            }
            // 剩余字符少于k个
            reverse(chars, i, chars.length-1);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        int offset = (end - start + 1) / 2;
        for (int i = start, j = end; i < start + offset; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }

}
