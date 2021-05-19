package 栈与队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lyq on 2021-05-19 下午11:08
 * @desc 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *      返回滑动窗口中的最大值。
 */
public class 滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return nums;
        int[] arr = new int[len - k + 1];
        // 单调递减队列
        Deque<Integer> deque = new LinkedList<>();
        // 初始化
        for (int i=0;i<k;i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                // 无需保留所有元素
                deque.removeLast();
            }
            deque.offer(nums[i]);
        }
        int idx = 0;
        arr[idx] = deque.peekFirst();
        for (int i=k;i<nums.length;i++) {
            // 队列中最大的值已经出队
            if (nums[i-k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            // 入队元素较大
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                // 无需保留所有元素
                deque.removeLast();
            }
            deque.offer(nums[i]);
            arr[idx] = deque.peekFirst();
        }
        return arr;
    }

}
