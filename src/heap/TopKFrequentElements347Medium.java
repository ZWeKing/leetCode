package heap;

import java.util.*;

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
