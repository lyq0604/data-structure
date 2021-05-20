package 栈与队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lyq on 2021-05-20 下午10:01
 * @desc 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class 前K个高频元素 {

    /**
     * 优先级队列：堆
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(map.size(), ((o1, o2) -> {
            return o1.getValue() - o2.getValue();
        }));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        for (int i=0;i<k;i++) {
            arr[i] = queue.poll().getKey();
        }
        return arr;
    }

}
