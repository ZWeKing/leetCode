package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * Medium
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray215Medium {
    /*public int findKthLargest(int[] nums, int k) {

        //建立最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if (o1.compareTo(o2) > 0) {
                    return 1;
                } else if (o1.compareTo(o2) == 0) {
                    return 0;
                } else {
                    return -1;
                }

            }
        });

        for (int i = 0; i < nums.length; i++) {
            if(queue.size() < k) {
                queue.offer(nums[i]);
            } else {
                int topValue = queue.peek();
                if (nums[i] > topValue) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }

        return queue.poll();

    }*/

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        //建立最小堆
        Heap queue = new Heap(k);

        for (int i = 0; i < nums.length; i++) {
            if(queue.size() < k) {
                queue.insert(nums[i]);
            } else {
                int topValue = queue.array[0];
                if (nums[i] > topValue) {
                    queue.delete();
                    queue.insert(nums[i]);
                }
            }
        }

        return queue.delete();

    }

    public static  void main(String[] args) {
        System.out.println(
        new KthLargestElementInAnArray215Medium().findKthLargest(new int[]{1,3,5,9,6,8,-1},5)
        );
    }
}
