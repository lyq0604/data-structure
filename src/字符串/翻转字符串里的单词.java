package 字符串;

/**
 * @author lyq on 2021-04-13 下午11:47
 * @desc 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class 翻转字符串里的单词 {

    public static void main(String[] args) {
        String s = "  hello world!  ";
        reverseWords(s);
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        // 1、去除字符串中多余空格
        s = removeExtraSpace(s);
        if (s.length() == 0) return s;
        // 2、翻转
        s = reverse(s);
        return s;
    }

    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        // 1、翻转整个字符串
        int left = 0;
        int right = chars.length-1;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        // 2、逐个翻转每个单词
        int start = 0;
        for (int i=0;i<chars.length;i++) {
            if (chars[i] == ' ') {
                int l = start;
                int r = i - 1;
                while (l < r) {
                    char tmp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = tmp;
                    l++;
                    r--;
                }
                start=i+1;
            } else if (i == chars.length-1) {
                int l = start;
                int r = i;
                while (l < r) {
                    char tmp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = tmp;
                    l++;
                    r--;
                }
            }
        }
        return new String(chars);
    }

    /**
     * 快慢移除字符串中多余的空格
     * @param s
     */
    private static String removeExtraSpace(String s) {
        char[] chars = s.toCharArray();
        int fast = 0;
        int slow = 0;
        // 移除开头的空格
        while (fast < chars.length && chars[fast] == ' ') {
            fast++;
        }
        // 移除中间多余的空格
        for (;fast<chars.length;fast++) {
            // 连续空格
            if (fast > 0 && chars[fast] == chars[fast-1] && chars[fast] == ' ') {
                continue;
            } else {
                chars[slow++] = chars[fast];
            }
        }
        // 移除末尾空格
        if (slow - 1 > 0 && chars[slow-1] == ' ') {
            slow-=1;
        }
        char[] newArr = new char[slow];
        System.arraycopy(chars, 0, newArr, 0, slow);
        return new String(newArr);
    }

}
