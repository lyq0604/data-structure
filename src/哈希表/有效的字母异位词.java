package 哈希表;

/**
 * @author lyq on 2021-04-09 下午10:30
 * @desc 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class 有效的字母异位词 {

    /**
     * 解法一：哈希表
     * 解法二：数组代替hash表，适用于哈希值较小的情况
     */
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            // 取相对位置代表对应字符即可
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr[c - 'a']--;
        }
        for (int i=0;i<arr.length;i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

}
