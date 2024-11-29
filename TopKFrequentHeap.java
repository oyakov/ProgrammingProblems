import java.util.*;

public class TopKFrequentHeap {

    // Given an integer array nums and an integer k, return the k most frequent elements.
    // You may return the answer in any order.

    public static int[] topKFrequentHeap(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. Build hash map: character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(count::get));

        // 2. Keep k top frequent elements in the heap
        // O(k log N) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. Build an output array
        // O(k log N) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 5};
        int[] topK1 = topKFrequentHeap(array1, 2);
        System.out.println("Top K Frequent Heap: " + Arrays.toString(topK1));
    }
}
