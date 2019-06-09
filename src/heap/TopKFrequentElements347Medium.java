package heap;

import java.util.*;

/**
 * 347. Top K Frequent Elements https://leetcode.com/problems/top-k-frequent-elements/
 * Medium
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 */
public class TopKFrequentElements347Medium {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], count + 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue(k, new Comparator<Map.Entry<Integer,Integer>>(){
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                });

        Set<Map.Entry<Integer, Integer>> keySet = map.entrySet();

        Iterator<Map.Entry<Integer, Integer>> iter = keySet.iterator();

        while (iter.hasNext()) {
            if (queue.size() < k) {
                queue.offer(iter.next());
            } else {
                Map.Entry<Integer, Integer> value = queue.peek();
                Map.Entry<Integer,Integer> queueTop = iter.next();
                if (queueTop.getValue() > value.getValue()) {
                    queue.poll();
                    queue.offer(queueTop);
                }
            }
        }

        List<Integer> result = new ArrayList(k);

        for (int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array= new int[] {1,1,1,2,2,3};
        System.out.println(
                new TopKFrequentElements347Medium().topKFrequent(array,2)
        );
    }
}
