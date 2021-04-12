package 字符串;

/**
 * @author lyq on 2021-04-12 下午11:17
 * @desc 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class 替换空格 {

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                count++;
            }
        }
        char[] newChars = new char[s.length() + 2 * count];
        for (int i=chars.length-1,j=newChars.length-1;i>=0;i--,j--) {
            if (chars[i] == ' ') {
                newChars[j] = '0';
                newChars[j-1] = '2';
                newChars[j-2] = '%';
                j-=2;
            } else {
                newChars[j] = chars[i];
            }
        }
        return new String(newChars);
    }

}
