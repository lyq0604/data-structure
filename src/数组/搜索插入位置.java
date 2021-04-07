package 数组;

/**
 * @author lyq on 2021-04-07 下午10:36
 * @desc 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 假设数组中无重复元素。
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr, 0));
    }

    /**
     * 解题思路：循环不变量，即区间确定后，在循环过程中区间的边界与目标值的大小关系应在任何时候保持不变。
     *  区间选取：
     *      [left, right]：left == right时,区间[left, right]仍然有效,判断条件是 left <= right;
     *      [left, right)：left == right时,区间[left, right)是无效区间,判断条件是 left < right, 且 num[mid] > target时, right = mid;
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }

}
