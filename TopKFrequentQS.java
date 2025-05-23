import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TopKFrequentQS {
    private static int[] unique;
    private static Map<Integer, Integer> count;

    public static void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    public static int partition(int left, int right, int pivot_index) {
        int pivot_frequency = count.get(unique[pivot_index]);
        // 1. Move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. Move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. Move the pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public static void quickselect(int left, int right, int k_smallest) {
        /*
        Sort a list within left..right till kth less frequent element
        takes its place.
        */

        // base case: the list contains only one element
        if (left == right) return;

        //Select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        // Find the pivot position in a sorted list
        pivot_index = partition(left, right, pivot_index);

        // If the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            // go left
            quickselect(left, pivot_index - 1, k_smallest);
        } else {
            // go right
            quickselect(pivot_index + 1, right, k_smallest);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // Build hash map: character and how often it appears
        // O(n)
        count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Array of unique elements
        // O(n)
        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int num: count.keySet()) {
            unique[i] = num;
            i++;
        }

        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array.
        // All elements on the left are less frequent.
        // All the elements on the right are more frequent.
        quickselect(0, n - 1, n - k);
        // Return top k frequent elements
        return Arrays.copyOfRange(unique, n - k, n);
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 5};
        int[] topK1 = topKFrequent(array1, 2);
        System.out.println("Top K Frequent Heap: " + Arrays.toString(topK1));
    }
}
