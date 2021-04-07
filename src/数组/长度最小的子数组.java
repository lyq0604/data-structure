package 数组;

/**
 * @author lyq on 2021-04-07 下午11:22
 * @desc 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 */
public class 长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            right++;
            while (sum >= target) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
