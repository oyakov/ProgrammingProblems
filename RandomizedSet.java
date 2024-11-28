import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class RandomizedSet {

    // Set there is not as efficient, it is is more efficient to use HashMap here
        private final Set<Integer> values;
        Random random= new Random();

        public RandomizedSet() {
            values = new HashSet<>();
        }

        public boolean insert(int val) {
            return values.add(val);
        }

        public boolean remove(int val) {
            return values.remove(val);
        }

        // Needed to avoid values to array here and then getting it by index
        public int getRandom() {
            return (int) values.toArray()[random.nextInt(values.size())];
        }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.remove(0);
        rs.remove(0);
        rs.insert(0);
        rs.getRandom();
        rs.remove(0);
        rs.insert(0);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
