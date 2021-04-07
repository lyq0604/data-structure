package 数组;

/**
 * @author lyq on 2021-04-07 下午11:05
 * @desc
 *  给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *  不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *  元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class 移除元素 {

    /**
     * 标记法：记录等于val的元素个数
     */
    public int removeElement1(int[] nums, int val) {
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == val) {
                count++;
            } else {
                nums[i-count] = nums[i];
            }
        }
        return nums.length - count;
    }

    /**
     * 快慢指针法
     */
    public int removeElement2(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

}
